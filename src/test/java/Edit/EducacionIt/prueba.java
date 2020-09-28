package Edit.EducacionIt;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class prueba {
	@Test
	public void lab2_E0() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIt\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://claawicroa00.risorse.enel:8242/#");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement inputUser = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
		inputUser.clear();
		inputUser.sendKeys("AR33901522");
		
		WebElement inputClave = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
		inputClave.clear();
		inputClave.sendKeys("Indra2020$");
		
		WebElement btnIngresar = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
		btnIngresar.click();
		
		Thread.sleep(6000);
		WebElement btnReco = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"toolbar\"]/div[4]/a/img")));
		btnReco.click();
		
		
		WebElement btnAguas = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Aguas Arriba']")));
		btnAguas.click();
		
	}
}
