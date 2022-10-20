package com.blp.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blp.base.Base;

public class LoginPage extends Base{

	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@name=\"remember\"]")
	WebElement checkbox;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement signInButton;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public HomePage loginPageTest(String un,String pw) {
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pw);
		checkbox.click();
		signInButton.click();
		return new HomePage();
		
	}
	
}
