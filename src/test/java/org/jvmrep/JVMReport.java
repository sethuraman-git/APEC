package org.jvmrep;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {

	
	public static void jvmReport(String json) {
		//1.Target folder location 
		File f = new File("C:\\Users\\Sethu\\eclipse-workspace\\AdhiparasakthiEngCollege\\Reports\\JVMReports");
		
		//2.Add additional features in report
		Configuration c = new Configuration(f, "APEC application");
		c.addClassifications("platform", "windows");
		c.addClassifications("version", "10");
		c.addClassifications("browser", "chrome");
		c.addClassifications("Driver version", "90");
		
		//3.add json filepath to list
		List<String> li = new ArrayList<String>();
		li.add(json);
		
		//4.to generate reports
		
		ReportBuilder r = new ReportBuilder(li, c);
		r.generateReports();
	}
}
