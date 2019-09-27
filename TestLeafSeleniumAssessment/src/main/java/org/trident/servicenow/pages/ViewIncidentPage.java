package org.trident.servicenow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.trident.servicenow.common.ProjectMainMethod;

public class ViewIncidentPage extends ProjectMainMethod {
	
	public ViewIncidentPage() {	
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH, using="(//input[@class='form-control'])[1]")WebElement srchIncdt; 
	@FindBy(how=How.XPATH, using="(//a[@class='linked formlink'])[1]")WebElement vrfyIncdtId;
	
public ViewIncidentPage searchIncidentId() throws InterruptedException {
	Thread.sleep(2000);
	WebElement incId = srchIncdt; 
	incId.click();
	Thread.sleep(3000);
	incId.sendKeys(incidentId+Keys.ENTER);
	return this;
}
public ViewIncidentPage verifyIncidentId() throws InterruptedException {
	Thread.sleep(3000);
	String createInciId = vrfyIncdtId.getText();
	System.out.println(createInciId);
	
	if(createInciId.equals(incidentId)) {
		System.out.println("Incident Id has matched successfully");
	}
	else {
		System.out.println("Failed! Incident Id has mismatched");
	}
	return this;
	
}


}
