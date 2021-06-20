package org.runner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.jvmrep.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources",glue="org.step",plugin= {"html:C:\\Users\\Sethu\\eclipse-workspace\\AdhiparasakthiEngCollege\\Reports\\htmlReport",
		"json:C:\\Users\\Sethu\\eclipse-workspace\\AdhiparasakthiEngCollege\\Reports\\jsonReport\\Adhi.json",
		"junit:C:\\Users\\Sethu\\eclipse-workspace\\AdhiparasakthiEngCollege\\Reports\\junitReport\\apec.xml"})
public class RunnerClass {
	
	@AfterClass 
	public static void generateAll() {
		JVMReport.jvmReport("C:\\Users\\Sethu\\eclipse-workspace\\AdhiparasakthiEngCollege\\Reports\\jsonReport\\Adhi.json");

	}

}














