package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaLogin {
WebDriver driver;
	
	@FindBy (id="email_create")
	WebElement inputEmail;
	
	@FindBy (xpath="//*[@id=\"SubmitCreate\"]/span/i")
	WebElement btnCreate;
	
	@FindBy (xpath="//*[@id=\"center_column\"]/h1")
	WebElement txtTitulo;
	
	@FindBy (id="email")
	WebElement inputEmailLogin;
	
	@FindBy (id="passwd")
	WebElement inputPass;
	
	@FindBy (xpath="//*[@id=\"SubmitLogin\"]/span")
	WebElement btnLogin;
	
	public PaginaLogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	}
	
	public void sendKeysEmail(String email) {
		inputEmail.sendKeys(email);
	}
	
	public void clickCreate() {
		btnCreate.click();
	}
	
	public String getTitulo() {
		
		return txtTitulo.getText();
	}
	
	public void loginUsuario(String email, String clave) {
		inputEmailLogin.clear();
		inputEmailLogin.sendKeys(email);
		
		inputPass.clear();
		inputPass.sendKeys(clave);
		
		btnLogin.click();
		
	}
}
