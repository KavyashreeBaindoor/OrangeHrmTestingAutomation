package com.bankinPageObjects;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {

WebDriver driver;


public LoginPage(WebDriver d) {
	this.driver=d;
	PageFactory.initElements(driver, this);
}


@FindBy(name="username")
WebElement txtUsername;
@FindBy(name="password")
WebElement txtPassword;
@FindBy(xpath="//button[contains(@class,' oxd-button--main')]")
WebElement loginBtn;
@FindBy(xpath="//span[@class='oxd-userdropdown-tab']/img[@alt='profile picture']")
WebElement dropDownIcon;
@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/li[4]/a")
WebElement logoutBtn;
@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
WebElement ErrorMssg;




//action methods

public void userName(String un){
	
	if(txtUsername.isDisplayed() && txtUsername.isEnabled())
	txtUsername.sendKeys(un);
	
}

public void password(String pass){
	
	if(txtPassword.isDisplayed() && txtPassword.isEnabled())
	txtPassword.sendKeys(pass);	
}

public void clickLogin(){
	
	if(loginBtn.isDisplayed() && loginBtn.isEnabled())
	loginBtn.click();
}



public void logout() {
	dropDownIcon.click();
	logoutBtn.click();
}

public String displayErrMssg() {
	return ErrorMssg.getText();
}




}
