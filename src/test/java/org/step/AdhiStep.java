package org.step;

import org.PojoAdhi.AdhiPojo;
import org.baseclasscucumber.LibGlobalcucumber;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdhiStep extends LibGlobalcucumber{




@Given("To get into the Apec page")
public void to_get_into_the_Apec_page() {
    browserLaunch();
    toLoadUrl("https://adhiparasakthi.in/");
}

@When("To move to the home button")
public void to_move_to_the_home_button() {
    AdhiPojo a = new AdhiPojo();
    toMouseHover(a.getHome());
}

@Then("click the about us field")
public void click_the_about_us_field() {
    driver.findElement(By.xpath("//a[text()='About Us']")).click();
}

@When("To move to home button")
public void to_move_to_home_button() {
	AdhiPojo a = new AdhiPojo();
    toMouseHover(a.getHome());
}

@Then("click the virtual tour field")
public void click_the_virtual_tour_field() {
    driver.findElement(By.xpath("//a[text()='Virtual Tour']")).click();
}







}
