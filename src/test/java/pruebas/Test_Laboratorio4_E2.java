package pruebas;
import org.testng.Assert;
import org.testng.annotations.*;

import paginas.PaginaInicio;
import paginas.PaginaLogin;
import utilidades.DatosExcel;
import utilidades.Screenshots;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Laboratorio4_E2 {
	WebDriver driver;
	String rutaDriver = "..\\EducacionIt\\Drivers\\chromedriver.exe";
	String urlPrueba = "http://automationpractice.com/index.php";
	String urlEvidencia ="..\\EducacionIt\\Evidencias";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", rutaDriver);
		driver = new ChromeDriver();
		driver.get(urlPrueba);
	}
	
	@Test (dataProvider="Datos registro inválido XLSX")
	public void  crearCuentaInvalida(String email) throws Exception {
		PaginaInicio objInicio = new PaginaInicio (driver);
		objInicio.clickLogin();
		
		PaginaLogin objLogin = new PaginaLogin (driver);
		objLogin.sendKeysEmail(email);
		objLogin.clickCreate();
		
		
		Assert.assertEquals(objLogin.getTitulo(), "AUTHENTICATION");
		Screenshots.screenshot(urlEvidencia, "TestRegistroInvalido", driver);
	}
	
	@DataProvider (name="Datos registro inválido XLSX")
	public static Object[][] datosXLSX() throws Exception{
		String rutaExcel= "..\\EducacionIt\\Recursos\\Datos.xlsx";
		String nombreHoja="Registro";
		Object[][] datos= DatosExcel.leerExcel(rutaExcel,nombreHoja);
		return datos;
	}
	
	@AfterSuite
	public void quit() {
		driver.quit();
	}
}
