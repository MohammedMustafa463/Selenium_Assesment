package org.trident.servicenow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.trident.servicenow.common.ProjectMainMethod;

public class SystemAdministrationPage extends ProjectMainMethod{
	
	public SystemAdministrationPage() {	
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.ID, using="filter")WebElement eFilter;
	@FindBy(how=How.XPATH, using="//div[text()='Create New']")WebElement clickCreateNew; 
	
	public SystemAdministrationPage searchFilterBox(String incdt) throws InterruptedException {
		Thread.sleep(2000);
		eFilter.sendKeys(incdt);
		return this;
	}
	public CreateIncidentPage clickCreateNew() throws InterruptedException {
		Thread.sleep(10000);
		clickCreateNew.click();
		return new CreateIncidentPage();
	}
	
}
