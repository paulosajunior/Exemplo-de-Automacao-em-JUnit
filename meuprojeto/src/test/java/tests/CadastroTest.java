package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroTest {

	WebDriver driver = new ChromeDriver();
	
	@Test
	public void abreBrowser(){
		//acessar o site https://automacaocombatista.herokuapp.com/users/new
		driver.get("https://automacaocombatista.herokuapp.com/users/new");
		//preencher os dados do usuario
		driver.findElement(By.id("user_name")).sendKeys("Paulo2");
		driver.findElement(By.id("user_lastname")).sendKeys("Junior1");
		driver.findElement(By.id("user_email")).sendKeys("paulojunior2@teste.com.br");
		driver.findElement(By.id("user_address")).sendKeys("Av. Afonso Pena, 4000");
		
		// clicar em criar
		driver.findElement(By.name("commit")).click();
		//Então eu confiro a mensagem Usuário Criado com sucesso
		String mensagem  = driver.findElement(By.id("notice")).getText();
		
		Assert.assertEquals("===>>>ERRO NA SAIDA DE DADOS<<<===","Usuário Criado com sucesso." ,mensagem);
		
	
	}
	@After
	public void fechaBrowser() {
		driver.quit();
	}

	
	
}
