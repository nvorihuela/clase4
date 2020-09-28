package Edit.EducacionIt;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    
	public void lab1(){
		//instanciar Driver de Chrome + importar libreria org.openqa.selenium.chrome.ChromeDriver
		WebDriver d= new ChromeDriver();
		//Propiedades para Ejecutar el driver de Chrome
		System.setProperty("webdriver.chrome.driver","C:\\workplaces\\Trunk\\EducacionIt\\Drivers\\chromedriver63.exe");
		//Ir a url
		d.get("https://selenium.dev/");
		//Cerrar navegador
		d.quit();
	}
	
	public void lab2(){
	
		//Instancias Driver de Firefox + importar libreria	
		
		WebDriver d= new FirefoxDriver();
		
		//Propiedades para ejecutar el driver de Firefox	
		
		System.setProperty("webdriver.gecko.driver","C:\\workplaces\\Trunk\\EducacionIt\\Drivers\\geckodriver.exe");
		
		d.get("https://selenium.dev/");
		
		d.manage().window().maximize();
		//Localizando elementos
		d.findElement(By.id("gsc-i-id1")).sendKeys("maven");
		d.findElement(By.id("gsc-i-id1")).sendKeys(Keys.ENTER);
		
		
		//espera implicita antes de cerrar
		d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Cerrar el navegador
		d.quit();
	}
	

	public void lab3(){

		WebDriver d= new ChromeDriver();
		//Propiedades para Ejecutar el driver de Chrome
		System.setProperty("webdriver.chrome.driver","C:\\workplaces\\Trunk\\EducacionIt\\Drivers\\chromedriver63.exe");
		//Ir a url
		d.get("https://selenium.dev/");
		
		//Con asignacion de elemento a variable
		WebElement textBuscador = d.findElement(By.id("gsc-i-id1"));
		textBuscador.sendKeys("Maven");
		textBuscador.sendKeys(Keys.ENTER);
		
		
		//Cerrar navegador
		d.quit();
	}
}
