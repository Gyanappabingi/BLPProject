import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.blp.base.Base;
import com.blp.page.HomePage;
import com.blp.page.LoginPage;
import com.blp.util.Utils;

public class LoginPageTest extends Base {

	LoginPage login;
	HomePage homepage;
	Utils utils;
	String sheetname="Sheet1";
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		login=new LoginPage();
	}
	@DataProvider(name = "getExcelData")
	public Object[][] getExcelData(){
		Object data[][]=utils.getTestData(sheetname);
		return data;
	}
	
	
	@Test
	public void TitleTest() {
		String actualTitle=login.validateLoginPageTitle();
		String expectedTitle="Predict.AI";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(dataProvider = "getExcelData")
	public void loginTest(String Username,String Password) throws Exception {
		homepage=login.loginPageTest(Username, Password);
		Thread.sleep(2000);
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://predict-ai-jspl.firebaseapp.com/page";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
