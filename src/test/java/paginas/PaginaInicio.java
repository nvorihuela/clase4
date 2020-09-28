package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaInicio {
	
	WebDriver driver;
	
	@FindBy (xpath="//*[@class='login']")
	WebElement btnLogin;
	
	@FindBy (css="head > meta:nth-child(1)")
	WebElement txtTitulo;
	
	public PaginaInicio(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public String getTextTitulo() {
		return txtTitulo.getText();
	}

}
