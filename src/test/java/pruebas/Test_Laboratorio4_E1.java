package pruebas;

import org.testng.Assert;
import org.testng.annotations.*;

import paginas.PaginaInicio;
import paginas.PaginaLogin;
import utilidades.DatosExcel;
import utilidades.DatosXML;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class Test_Laboratorio4_E1 {
	WebDriver driver;
	String rutaDriver = "..\\EducacionIt\\Drivers\\chromedriver.exe";
	String urlPrueba = "http://automationpractice.com/index.php";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", rutaDriver);
		driver = new ChromeDriver();
		driver.get(urlPrueba);
	}
	
	@Test (priority=0, description="Prueba Login inválido", dataProvider="Datos login inválido XML")
	public void ingresoCuentaInvalida(String usuario, String clave) {
		PaginaInicio objInicio = new PaginaInicio(driver);
		objInicio.clickLogin();
		
		PaginaLogin objLogin = new PaginaLogin(driver);
		objLogin.loginUsuario(usuario, clave);
		
		Assert.assertEquals(objLogin.getTitulo(), "AUTHENTICATION");
	}
	
	@DataProvider (name="Datos login inválido")
	public static Object[][] datos(){
		Object[][] datos = new Object[3][2];
		datos[0][0]="Pedro";
		datos[0][1]="clave123";
		
		datos[1][0]="Nadia";
		datos[1][1]="123";
		
		datos[2][0]="UsuarioPrueba";
		datos[2][1]="prueba";
		
		return datos;
	}
	
	@DataProvider (name="Datos login inválido XLSX")
	public static Object[][] datosXLSX() throws Exception{
		String rutaExcel= "..\\EducacionIt\\Recursos\\Datos.xlsx";
		String nombreHoja="Login";
		Object[][] datos= DatosExcel.leerExcel(rutaExcel,nombreHoja);
		return datos;
	}
	
	@DataProvider (name="Datos login inválido XML")
	public static Object[][] datosXML() throws Exception{
		String rutaXML= "..\\EducacionIt\\Recursos\\Datos.xml";
		String tagDatos="Usuario";
		Object[][] datos= DatosXML.leerXML(rutaXML, tagDatos);
		return datos;
	}
	
	@AfterSuite
	public void quit() {
		driver.quit();
	}

	
}
