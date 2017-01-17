package com.hpe.digitalsafe.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hpe.digitalsafe.Helper.BrowserFactory;
import com.hpe.digitalsafe.Pages.ACModule.AuditCenterTab;
import com.hpe.digitalsafe.Pages.ACModule.ConfirmAndRunPage;
import com.hpe.digitalsafe.Pages.ACModule.CreateAuditPage;
import com.hpe.digitalsafe.Pages.ACModule.CreateQueryPage;
import com.hpe.digitalsafe.Pages.ACModule.CreateSelectCustodiansPage;
import com.hpe.digitalsafe.Pages.ACModule.DeliveryWorkflowPage;
import com.hpe.digitalsafe.Pages.ACModule.PostProcessingPage;
import com.hpe.digitalsafe.Pages.ACModule.SelectDateRangePage;
import com.hpe.digitalsafe.Pages.ACModule.SelectRepositoriesPage;
import com.hpe.digitalsafe.Pages.Commons.HomePage;
import com.hpe.digitalsafe.Pages.Commons.LoginPage;
import com.hpe.digitalsafe.Pages.DSDModule.DigitalSafeTab;
import com.hpe.digitalsafe.zippy.utils.BaseTest;
import com.hpe.digitalsafe.zippy.utils.DataObject;
import com.hpe.digitalsafe.zippy.utils.DataSet;
import com.hpe.digitalsafe.zippy.utils.TestCase;

public class CreateAuditTests extends BaseTest  {
	protected WebDriver driver;
	protected HomePage home_page;
	protected DigitalSafeTab selectRepositories_page;
	protected AuditCenterTab auditCenter_Tab;
	protected CreateAuditPage CreateAudit_page;
	protected SelectDateRangePage SelectDateRange_page;
	protected SelectRepositoriesPage SelectRepositories_Page;
	protected CreateSelectCustodiansPage CreateSelectCustodians_Page;
	protected CreateQueryPage CreateQuery_Page;
	protected DeliveryWorkflowPage DeliveryWorkflow_Page;
	protected PostProcessingPage PostProcessing_Page;
	protected ConfirmAndRunPage ConfirmAndRun_Page;
	 
	@Test
	@BeforeMethod
	 public void setUp() {
		 driver=BrowserFactory.startBrowserDefault();
			
			LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
			home_page=PageFactory.initElements(driver, HomePage.class);
			auditCenter_Tab=PageFactory.initElements(driver, AuditCenterTab.class);
			CreateAudit_page=PageFactory.initElements(driver, CreateAuditPage.class);
			SelectDateRange_page=PageFactory.initElements(driver, SelectDateRangePage.class);
			SelectRepositories_Page=PageFactory.initElements(driver, SelectRepositoriesPage.class);
			CreateSelectCustodians_Page=PageFactory.initElements(driver, CreateSelectCustodiansPage.class);
			CreateQuery_Page=PageFactory.initElements(driver, CreateQueryPage.class);
			DeliveryWorkflow_Page=PageFactory.initElements(driver, DeliveryWorkflowPage.class);
			PostProcessing_Page=PageFactory.initElements(driver, PostProcessingPage.class);
			ConfirmAndRun_Page=PageFactory.initElements(driver, ConfirmAndRunPage.class);
			login_page.login_fromPropFile();
			home_page.clickOnTab("AuditCenterTab");
	 }
	   
	@Test(dataProvider="datasetDataProvider",dependsOnMethods = { "setUp" })
	@TestCase(id = "HPDS_01", Author = "Venu Paleti", Description = "Create Audits")
	public void CreateNewAudit(DataSet set) throws InterruptedException {
		
		DataObject obj = set.getDataObject("data");
		
		auditCenter_Tab.ClickCreateAuditLink();
		CreateAudit_page.Fill_CreateAuditPage(obj.get("auditname"), obj.get("auditname"));
		SelectDateRange_page.Fill_SelectdateRangePage(obj.get("daterange1"),obj.get("daterange2"));
		SelectRepositories_Page.Fill_SelectRepositoriesPage(obj.get("repname"));
		CreateSelectCustodians_Page.Fill_CreateSelectCustodiansPage(obj.get("custodian1"), obj.get("custodian2"));
		CreateQuery_Page.Fill_CreateQueryPage(obj.get("queryLanguage"), obj.get("querydoctype"), obj.get("quertdata"));
		DeliveryWorkflow_Page.Fill_DeliveryWorkflowPage();
		PostProcessing_Page.Fill_PostProcessingPage(obj.get("postprocessdate"));
		ConfirmAndRun_Page.SubmitAudit();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	   }

}
