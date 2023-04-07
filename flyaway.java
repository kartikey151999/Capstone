package com.test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import com.test.JDBC.JDBC;

public class flyaway{
	

	public String[] exp_details() {
		    flyawayjdbc flyawayjdbc = new flyawayjdbc();
		// TODO Auto-generated method stub
	
		String str[]=new String[5];
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/flyaway/");
		driver.findElement(By.linkText("Login/Signup")).click();
		driver.findElement(By.xpath("//input[@name=\"email_id\"]")).sendKeys("kp@pubg.com");
		driver.findElement(By.xpath("//input[@name=\"pwd\"]")).sendKeys("kp");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		
		String exp_email="kp@pubg.com";
		String exp_pwd ="pubg";
		String exp_name = "kp";
		String exp_adress ="kaverrapa layout";
		String exp_city ="banglore";
		
		
		str[0]=exp_name;
		str[1]=exp_city;
		str[2]=exp_email;
		str[3]=exp_adress;
		str[4]=exp_pwd;
		
		
		driver.findElement(By.linkText("Login/Signup")).click();
		driver.findElement(By.linkText("Not a member? Signup")).click();
		driver.findElement(By.xpath("//input[@name=\"email_id\"]")).sendKeys(exp_email);
		driver.findElement(By.xpath("//input[@name=\"pwd\"]")).sendKeys(exp_pwd);
		driver.findElement(By.xpath("//input[@name=\"pwd2\"]")).sendKeys(exp_pwd);
		driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys(exp_name);
		driver.findElement(By.xpath("//input[@name=\"address\"]")).sendKeys(exp_adress);
		driver.findElement(By.xpath("//input[@name=\"city\"]")).sendKeys(exp_city);
		
		
		driver.findElement(By.xpath("//button")).click();
//		driver.close();
	
		String[] jdbc = flyawayjdbc.Jdbc();
		for (String string : jdbc) {
			System.out.println(string);
		}
		return str;
	}
	
	
	
	
	public int Login_SearchFlight_Validate() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/flyAway/");
		driver.findElement(By.linkText("Login/Signup")).click();
		driver.findElement(By.xpath("//input[@name=\"email_id\"]")).sendKeys("kp@pubg.com");
		driver.findElement(By.xpath("//input[@name=\"pwd\"]")).sendKeys("kp");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.linkText("Home")).click();
		
		
		String str[]=new String[18];
		int i=0;
		
		WebElement table = driver.findElement(By.xpath("//table[@border='1']"));
		List<WebElement> list = table.findElements(By.tagName("tr"));
		System.out.println("printing No of Rows"+list.size());
		
		for (WebElement ls : list) {
			
			 List<WebElement> clist = ls.findElements(By.tagName("td"));
			
			 for (WebElement wl : clist) {
				 str[i]=wl.getText();
				 i++;
//				 System.out.println(wl.getText()+",");
				
			}
			 
			
			
		}
		
		
		
		
		System.out.println("   \n\n");
		
		System.out.println("Printing the table from home page");
		for (int j = 0; j < str.length; j++) {
			System.out.println(str[j]);
			
		}
		
		System.out.println("\n\n");
		
		
		
		driver.findElement(By.xpath("//select[@name='source']")).click();
		driver.findElement(By.xpath("//select[@name='source']//option[@value='1']")).click();
		String text = driver.findElement(By.xpath("//select[@name='source']//option[@value='1']")).getText();
		System.out.println("Printing From location inside dropdown");
		System.out.println(text);
		
		System.out.println("\n\n");
		
		
		
		driver.findElement(By.xpath("//select[@name='destination']")).click();
		driver.findElement(By.xpath("//select[@name='destination']//option[@value='11']")).click();
		String text2 = driver.findElement(By.xpath("//select[@name='destination']//option[@value='11']")).getText();
		System.out.println("Printing TO location inside dropdown");
		System.out.println(text2);
		
		
		driver.findElement(By.xpath("//button")).click();
		

		String str1[]=new String[12];
		int k=0;
		
		WebElement table1 = driver.findElement(By.xpath("//table[@border='1']"));
		List<WebElement> list1 = table1.findElements(By.tagName("tr"));
		System.out.println("printing No of Rows"+list1.size());
		
		for (WebElement ls : list1) {
			
			 List<WebElement> clist = ls.findElements(By.tagName("td"));
			
			 for (WebElement wl : clist) {
				 str1[k]=wl.getText();
				 k++;
				 System.out.println(wl.getText()+",");
				
			}
			
			
		}
		System.out.println("\n\n");
		for (int j = 0; j < str1.length; j++) {
			System.out.println(str1[j]);
			
		}
		String from_table=str1[6];
		String to_table = str1[7];
		System.out.println("printing from and to from table after submit to verify");
		System.out.println(from_table+"\n"+to_table);
		System.out.println("\n\n");
		
		int ret =0;
		
		if ((text.contains(from_table))){
			ret++;
			System.out.println("Source Location Validated");
			
		} else {
			System.out.println("Source Location did not validation");

		}
		
		
		
		if ((text2.contains(to_table))) {
			ret++;
			System.out.println("Destination Location Validated");
			
		} else {
			System.out.println("Destination Location not Validated");

		}
		
//		return ret;
		
		
		
		
		
//		Not able to perform select element from dropdown menu
		
//		WebElement WE_TO = driver.findElement(By.xpath("//select[@name='destination']"));
//		Select select2 = new Select(WE_TO);
//		select2.selectByVisibleText("Hyderabad");
		
		
		
		
//		driver.findElement(By.xpath("//select[@name='source']")).click();
		
//		WebElement WE_From = driver.findElement(By.xpath("//select[@name='source']"));
//		System.out.println(WE_From.getAttribute("type"));
//		Select select = new Select(WE_From);
//		select.selectByValue("1");
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		driver.findElement(By.xpath("//button")).click();
//		driver.close();
		return ret;
	}
	
	
	
	
	
	
	public int Book_Show_and_Validate() {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/flyAway/");
		driver.findElement(By.linkText("Login/Signup")).click();
		driver.findElement(By.xpath("//input[@name=\"email_id\"]")).sendKeys("kp@pubg.com");
		driver.findElement(By.xpath("//input[@name=\"pwd\"]")).sendKeys("kp");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.linkText("Home")).click();
		
		
		driver.findElement(By.xpath("//select[@name='source']")).click();
		driver.findElement(By.xpath("//select[@name='source']//option[@value='1']")).click();
		String text = driver.findElement(By.xpath("//select[@name='source']//option[@value='1']")).getText();
		System.out.println("Printing From location inside dropdown");
		System.out.println(text);
		
		System.out.println("\n\n");
		
		
		
		driver.findElement(By.xpath("//select[@name='destination']")).click();
		driver.findElement(By.xpath("//select[@name='destination']//option[@value='11']")).click();
		String text2 = driver.findElement(By.xpath("//select[@name='destination']//option[@value='11']")).getText();
		System.out.println("Printing TO location inside dropdown");
		System.out.println(text2);
		
		
		driver.findElement(By.xpath("//button")).click();
		
		
		
		

		driver.findElement(By.linkText("Book Flight")).click();
		driver.findElement(By.linkText("Click to complete booking")).click();
		driver.findElement(By.linkText("See Your Bookings")).click();
		
		
		
		
		WebElement table2 = driver.findElement(By.xpath("//table[@border='1']"));
		List<WebElement> list2 = table2.findElements(By.tagName("tr"));
		System.out.println("printing No of Rows"+list2.size());
		
		
//		String str1[]=new String[12];
		String str3[] = new String[list2.size()*5];
		int l=0;
		for (WebElement ls : list2) {
			
			 List<WebElement> clist = ls.findElements(By.tagName("td"));
			
			 for (WebElement wl : clist) {
				 System.out.println(wl.getText()+",");
				 str3[l]=wl.getText();
				 l++;
				
			}
			
			
		}
		
		System.out.println("\n\n");
		
		for (int j = 0; j < str3.length; j++) {
			System.out.println(str3[j]);
			
		}
		System.out.println("\n\n");
		
		String show_Source_AB=str3[6];
		String show_Destination_AB = str3[7];
		
		System.out.println("\n\n");
		System.out.println(show_Source_AB+"\n"+show_Destination_AB+"\n\n");
		
		int ret =0;
		
		if (text.contains(show_Source_AB)) {
			ret++;
			System.out.println("Validation of Source after booking");
			
		} else {
			System.out.println("Validation failed Of source after booking");

		}
		
		
		if (text2.contains(show_Destination_AB)) {
			ret++;
			System.out.println("Validation of Destination after booking");
			
		} else {
			System.out.println("Validation Failed for destination after booking");

		}
		
		
		System.out.println("\n\n");
		return ret;
		
		
	}
	
	
	
		


}