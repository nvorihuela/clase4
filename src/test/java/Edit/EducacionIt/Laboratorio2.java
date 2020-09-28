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

public class Laboratorio2 {
	@Ignore
	public void lab2_E0() {
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIt\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");

		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement inputBuscador = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
		inputBuscador.clear();
		inputBuscador.sendKeys("prueba");

		// WebElement linkDescargas =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/nav/a[1]")));
		WebElement linkDescargas = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@href='/downloads' and @class='nav-item' ]")));
		linkDescargas.click();

		WebElement linkDoc = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[text()='Documentation' and @class= 'nav-item']")));
		linkDoc.click();

		driver.navigate().back();
		WebElement linkBlog = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(@href,'/blog') and @class='nav-item']")));
		linkBlog.click();

		driver.navigate().back();
		WebElement inputBusq2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gsc-i-id1")));
		inputBusq2.clear();
		inputBusq2.sendKeys("prueba2");

		driver.quit();

	}
	
	@Test
	public void lab2_E1() {
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIt\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication#account-creation");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email_create")));
		inputEmail.sendKeys("pruebaEJ1@email.com");
		
		WebElement btnCreate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SubmitCreate\"]/span")));
		btnCreate.click();
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement inputFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_firstname")));
		inputFirstName.sendKeys("prueba");
		
		WebElement inputClave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd")));
		inputClave.sendKeys("1232");
		
		Select dropMes = new Select (wait.until(ExpectedConditions.presenceOfElementLocated(By.name("months"))));
		//dropMes.selectByVisibleText("April ");
		//dropMes.selectByValue("4");
		dropMes.selectByIndex(4);
		//driver.quit();
		
		WebElement inputRadio = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"id_gender1\"]")));
		inputRadio.click();
		
		WebElement btnRegistro = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Register']")));
		btnRegistro.click();
		
		driver.quit();
	}
}
