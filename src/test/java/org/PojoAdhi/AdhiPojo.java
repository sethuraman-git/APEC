package org.PojoAdhi;

import org.baseclasscucumber.LibGlobalcucumber;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdhiPojo extends LibGlobalcucumber {
	public AdhiPojo(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text()='Home'])[1]") 
	private WebElement home;
	
	@FindBy(xpath="(//a[text()='Academics'])[1]") 
	private WebElement academics;
	
	@FindBy(xpath="(//a[text()='Placements'])[1]") 
	private WebElement placements;

	public WebElement getHome() {
		return home;
	}

	public WebElement getAcademics() {
		return academics;
	}

	public WebElement getPlacements() {
		return placements;
	}
	

}


