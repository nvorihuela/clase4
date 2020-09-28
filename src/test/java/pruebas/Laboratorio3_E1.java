package pruebas;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class Laboratorio3_E1 {
	WebDriver driver;
	String rutaDriver= "..\\EducacionIt\\Drivers\\chromedriver.exe";
	String urlPrueba = "http://automationpractice.com/index.php?controller=authentication#account-creation";
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", rutaDriver);
		driver = new ChromeDriver();
		System.out.println("Inicio de Suite prueba");
	}

	@BeforeTest
	public void irUrl() {
		driver.get(urlPrueba);
	}

	@BeforeClass
	public void maxVentana() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test (priority=0,description="Prueba de Registro usuario inválido")
	public void registroUsuario() {
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
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication");
		
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		Assert.assertNull(null);
	}
	
	@Test (enabled=false, priority=1, description="Prueba")
	public void prueba() {
		System.out.println("prueba");
	}

	@AfterClass
	public void finPrueba() {
		System.out.println("Fin de prueba");
	}

	@AfterTest
	public void quit() {
		driver.quit();
	}

	@AfterSuite
	public void fin() {
		System.out.println("Fin de Suite prueba");

	}
	
	
}
