package testcases;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import loginpage.LoginPage;

public class loginText extends BaseClass{
	@Test(dataProvider="loginData")
	public void verifylogin(String username,String password,Boolean isvaild) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPswd(password);
		loginpage.clickloginButton();
		if(isvaild){
			boolean dashboardVisible = loginpage.isDashboardvisible();
			Assert.assertTrue(dashboardVisible,"Dashboard should be visible");
			System.out.println("login successful for user:"+username);
		}else {
			String error=loginpage.getErrorMessage();
			Assert.assertTrue(error.contains("Invalid credentials")
					,"error message should be displayed for invaild login");
			System.out.println("login failed as expected for user:"+ username);	
		}	
	}
	 @DataProvider(name ="loginData")
	 public Object[][]loginData() {
		 return new Object[][] {
			 {"Admin","admin123",true},
			 {"Admin","wrongpass",false},
			 {"wronguser","admin123",false}
		 };
			 
		 }
	 }
		 
	 