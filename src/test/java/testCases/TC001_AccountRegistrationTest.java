package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;


public class TC001_AccountRegistrationTest extends BaseTest {
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration()
	{
		logger.info("**** Starting TC001_AccountRegistrationTest ****");
		
		try 
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info(" Clicked MyAccount link ");
		
		hp.clickRegister();
		logger.info(" Clicked Register link ");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info(" Providing Customer Details... ");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setPhoneNumber("8900890089");
		
		String pwd=randomeAlphaNumeric();
		regpage.setPassword(pwd);
		regpage.setConfirmPassword(pwd);
		
		regpage.clickToggleBtnSubscribe();
		regpage.clickToggleBtnPrivacy();
		regpage.clickBtnContinue();
		
		logger.info(" Validating Expected Massage ");
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			Thread.sleep(5000);
		}
		else
		{
			logger.error("Test was Failed...");
			logger.debug(" Debug logs.....");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC001_AccountRegistrationTest *****");
		
	}
	
	

}
