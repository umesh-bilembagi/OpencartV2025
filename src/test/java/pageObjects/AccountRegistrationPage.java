package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconfirmPassword;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement togglebtnSubscribe;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement togglebtnPrivacypolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setPhoneNumber(String email)
	{
		txtTelephone.sendKeys(email);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txtconfirmPassword.sendKeys(pwd);
	}
	
	public void clickToggleBtnSubscribe()
	{
		togglebtnSubscribe.click();
	}
	
	public void clickToggleBtnPrivacy()
	{
		togglebtnPrivacypolicy.click();
	}
	
	public void clickBtnContinue()
	{
		//sol1
		btnContinue.click();
		
		//sol2
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
		
		//sol3
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//sol4
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue));
	}
	
	public String getConfirmationMsg()
	{
		try 
		{
			return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
}
