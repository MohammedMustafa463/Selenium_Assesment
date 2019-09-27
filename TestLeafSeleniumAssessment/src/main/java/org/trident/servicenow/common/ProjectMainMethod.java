package org.trident.servicenow.common;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.trident.servicenow.utils.ExcelRead;

public class ProjectMainMethod {
	public static String incidentId="";
	public String excelFileName;
	public static RemoteWebDriver driver;

	@Parameters({ "url" })
	@BeforeMethod

	public void startWeb(String url) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	
	  @AfterMethod 
	  public void closeWeb() {
	   driver.close(); 
	   }
	@DataProvider(name="fetchData")
	public String[][] dataCentre() throws IOException {
		String[][] data = ExcelRead.readExcel(excelFileName);
		return data;
	}
}
