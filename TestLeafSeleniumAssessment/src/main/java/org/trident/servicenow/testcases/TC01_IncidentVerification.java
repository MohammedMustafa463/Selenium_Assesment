package org.trident.servicenow.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.trident.servicenow.common.ProjectMainMethod;
import org.trident.servicenow.pages.LoginCredentailPage;

public class TC01_IncidentVerification extends ProjectMainMethod {
	@BeforeClass
	public void setData() {
		excelFileName="TC01";
	}
	@Test(dataProvider="fetchData")
	public void incidentVerification(String username,String password,String incdt,String callName, String shrtDecpt) throws InterruptedException {
		LoginCredentailPage idv = new LoginCredentailPage();
		idv.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.searchFilterBox(incdt)
		.clickCreateNew()
		.getIncidentId()
		.enterCallerName(callName)
		.enterShortDescription(shrtDecpt)
		.clickSubmitIncident()
		.searchIncidentId()
		.verifyIncidentId();

}
}