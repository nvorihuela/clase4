package pruebas;

//import java.io.File;
//import java.io.IOException;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import paginas.PaginaInicio;
import paginas.PaginaLogin;


public class Laboratorio3_E2 {
	WebDriver driver;
	String rutaDriver= "..\\EducacionIt\\Drivers\\chromedriver.exe";
	String urlPrueba = "http://automationpractice.com/index.php";
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", rutaDriver);
		driver = new ChromeDriver();
		System.out.println("Inicio de Suite prueba");
		driver.get(urlPrueba);
	}
	
	@Test (priority=0)
	public void irRegistroLogin() {
		PaginaInicio objInicio = new PaginaInicio(driver);
		objInicio.clickLogin();
		
		PaginaLogin objLogin = new PaginaLogin(driver);
		
		Assert.assertEquals(objLogin.getTitulo(), "AUTHENTICATION");
	}
	
	@Test (priority=1)
	public void crearCuentaInvalida() throws IOException {
		PaginaLogin objLogin = new PaginaLogin(driver);
		objLogin.sendKeysEmail("email");
		objLogin.clickCreate();
		
		Assert.assertEquals(objLogin.getTitulo(), "AUTHENTICATION");
		
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionIt\\Evidencias\\TestCrearCuenta.png"));
		
	}
	
	@AfterSuite
	public void quit() {
		driver.quit();
	}
}
