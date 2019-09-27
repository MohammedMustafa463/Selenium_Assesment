package org.trident.servicenow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.trident.servicenow.common.ProjectMainMethod;

public class CreateIncidentPage extends ProjectMainMethod {

	public CreateIncidentPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='incident.number']")
	WebElement incidentID;
	@FindBy(how = How.ID, using = "sys_display.incident.caller_id")
	WebElement eCallerName;
	@FindBy(how = How.ID, using = "incident.short_description")
	WebElement eShortDescription;
	@FindBy(how = How.XPATH, using = "(//button[@id='sysverb_insert'])[1]")
	WebElement clickSubmit;

	public CreateIncidentPage getIncidentId() throws InterruptedException {
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		incidentId = incidentID.getAttribute("value");
		System.out.println("Incident ID =" + incidentId);
		return this;
	}

	public CreateIncidentPage enterCallerName(String callName) throws InterruptedException {
		Thread.sleep(3000);
		eCallerName.sendKeys(callName + Keys.TAB);
		return this;
	}

	public CreateIncidentPage enterShortDescription(String shrtDecpt) throws InterruptedException {
		Thread.sleep(3000);
		eShortDescription.sendKeys(shrtDecpt);
		return this;
	}

	public ViewIncidentPage clickSubmitIncident() throws InterruptedException {
		for (int i = 0; i <= 1; i++) {
			Thread.sleep(3000);
			WebElement ele = clickSubmit;
			ele.click();
			try {
				if (driver.findElementByXPath("//*[contains(@class,'notification-error')]").isDisplayed()) {
					Thread.sleep(3000);
					incidentID.click();
					Thread.sleep(3000);
					ele.click();
				}
			} catch (Exception e) {
			}
			break;
		}
		return new ViewIncidentPage();
	}

}
