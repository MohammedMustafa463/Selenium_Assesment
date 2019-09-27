package org.trident.servicenow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.trident.servicenow.common.ProjectMainMethod;

public class LoginCredentailPage extends ProjectMainMethod {
	
	public LoginCredentailPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.ID, using = "user_name")WebElement usrnme;
	@FindBy(how = How.ID, using = "user_password")WebElement psswrd;
	@FindBy(how = How.ID, using = "sysverb_login")WebElement login;

	public LoginCredentailPage enterUsername(String username) {
		driver.switchTo().frame(0);
		usrnme.sendKeys(username);
		System.out.println("The user name is  :" + username);
		return this;
	}

	public LoginCredentailPage enterPassword(String password) {
		psswrd.sendKeys(password);
		System.out.println("The password name is  :" + password);
		return this;
	}

	public SystemAdministrationPage clickLogin() {
		login.click();
		return new SystemAdministrationPage();
	}

}
