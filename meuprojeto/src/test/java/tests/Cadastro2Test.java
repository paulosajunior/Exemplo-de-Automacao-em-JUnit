package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CadastroUsuarioPage;
import support.Generator;
import support.Screenshot;

public class Cadastro2Test {

	WebDriver driver = new ChromeDriver();
	@Rule
	//Para capturar o nome do Método, foi declarado a variavel publica do tipo TestName
	public TestName teste = new TestName();
	//---------------------------------------------------------
	//@Before é um hook que é executado antes de cada teste. É um estado que o sistema deve está antes de executar o teste
	@Before
	public void abreBrowseer(){
		driver.get("https://automacaocombatista.herokuapp.com/users/new");
	}
	//---------------------------------------------------------
	//@Test defini cada caso de teste que está sendo automatizado. Este é o Usúario criado com sucesso.
	@Test
	public void confirmaCadastro(){
		String mensagem = new CadastroUsuarioPage(driver).CadastroConfirmadoPageComParametros("Paulo4", "Junior4", "paulojunior4@gmail.com", "Rua Daqui mesmo").mensagemCadastroSucesso();				
		Assert.assertEquals("===>>>ERRO NA SAIDA DE DADOS<<<===","Usuário Criado com sucesso" ,mensagem);
	}
			
	//---------------------------------------------------------
	//@After que grava a evidência após cada teste finalizar
	
	@After 
	public void a(){
		String EvidênciaDeTeste = System.getProperty("user.dir")+"\\target\\relatorios\\evidencias\\" + Generator.dataHoraParaArquivo() + teste.getMethodName() + ".png";
		Screenshot.tirar(driver, EvidênciaDeTeste );
	}
	//@After que fecha o browser
	@After
	public void b() {
		driver.quit();
	}	
}
