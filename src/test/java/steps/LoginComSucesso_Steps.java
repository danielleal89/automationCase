package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;

public class LoginComSucesso_Steps {
	
	private static WebDriver driver;
	
	@Dado("^O Usuario acessa a pagina \"([^\"]*)\"$")
	public void o_Usuario_acessa_a_pagina(String pagina) throws Throwable {
		// Configuração de conexão e abertura do navegador
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		// Acesso a url
		driver.get(pagina);
		Thread.sleep(3000);
	}

	@E("^O Usuario insere o username \"([^\"]*)\" e o password \"([^\"]*)\"$")
	public void o_Usuario_insere_o_username_e_o_password(String username, String password) throws Throwable {
		// Aguarda os campos aparecerem e insere o username e o password
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
		driver.findElement(By.id("user-name")).sendKeys(username);
		Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(3000);
        
        // Clica no botão login
        driver.findElement(By.id("login-button")).click();
	}

	@Entao("^O Usuario visualiza a tela com os produtos$")
	public void o_Usuario_visualiza_a_tela_com_os_produtos() throws Throwable {
		// Aguarda o botão Add to cart e finaliza o teste
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
		WebElement btnAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		Thread.sleep(5000);
		
		System.out.println("######################");
		if (btnAddToCart.isDisplayed()) {
			System.out.println("     TESTE PASSOU     ");
		} else {
			System.out.println("     TESTE FALHOU     ");
		}
		System.out.println("######################");
		
		driver.quit();
	}
	
}
