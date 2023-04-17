package com.carriersedge.stepDefinitions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.carriersedge.pages.HomePage;
import com.carriersedge.pages.LCVAdminPage;
import com.carriersedge.util.BrowserFactory;
import com.carriersedge.util.Myutilities;
import com.hlt.pages.HlHomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HLStepDefinition extends AbstractPageStepDefinition {
	
	public HLStepDefinition(){
	super();
	logger.info("HLStepDefinition initialized");
	}
	private static final Logger logger = LogManager.getLogger(HLStepDefinition.class);
	HlHomePage Hlhpage;
	
	@Then("I hide cookies disclaimer.")
	public void i_hide_cookies_disclaimer() {
		if (Hlhpage == null)
			Hlhpage = new HlHomePage(driver);
		Hlhpage.cookiesHide();
	}
	
	@Then("I clicked on services link.")
	public void i_clicked_on_services_link() {
		if (Hlhpage == null)
			Hlhpage = new HlHomePage(driver);
		Hlhpage.serviceLinkClick();
	}

	@Then("I verified the services page appeared.")
	public void i_verified_the_services_page_appeared() {
		if (Hlhpage == null)
			Hlhpage = new HlHomePage(driver);
		Hlhpage.verifyServices();
	}
	@Then("I will do this.")
	public void i_will_do_this() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I clicked on industry coverage group link.")
	public void i_clicked_on_industry_coverage_group_link() {
		if (Hlhpage == null)
			Hlhpage = new HlHomePage(driver);
		Hlhpage.industryCoveragePage();
	}

	@Then("I verified the industry coverage group page appeared.")
	public void i_verified_the_industry_coverage_group_page_appeared() {
		if (Hlhpage == null)
			Hlhpage = new HlHomePage(driver);
		Hlhpage.verifyIndustry();
	}
}
