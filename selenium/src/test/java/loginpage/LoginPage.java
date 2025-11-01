package loginpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait Wait;
	private By usernamefield = By.name("username");
	private By passwordfield = By.name("password");
	private By loginButton = By.xpath("//button[@type='submit']");
	private By errormessage = By.xpath("//p[normalize-space()='Invalid credentials']");
	private By dashboardheader = By.xpath("//h6[text()='Dashboard']");
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.Wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
	}
	public void enterUsername(String username) {
		WebElement userfield= Wait.until(ExpectedConditions.visibilityOfElementLocated(usernamefield));
		userfield.clear();
		userfield.sendKeys(username);
	}
	public void enterPswd(String pswd) {
	WebElement passfield = Wait.until(ExpectedConditions.visibilityOfElementLocated(passwordfield));
	passfield.clear();
	passfield.sendKeys(pswd);
	}
	public void clickloginButton() {
		Wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}
	public String getErrorMessage() {
		return Wait.until(ExpectedConditions.visibilityOfElementLocated(errormessage)).getText();
	}
	public boolean isDashboardvisible() {
		return Wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardheader)).isDisplayed();
	
	}
		
	
		
	}
	
	

	
	
	
