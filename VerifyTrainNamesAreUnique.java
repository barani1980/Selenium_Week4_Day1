package Week4.Day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTrainNamesAreUnique {

	public static void main(String[] args) throws InterruptedException {
		
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();				
				driver.get("https://erail.in/");
				Thread.sleep(4000);
				
				
				driver.findElementById("txtStationFrom").clear();
				driver.findElementById("txtStationFrom").sendKeys("ms");
				driver.findElementById("txtStationFrom").sendKeys(Keys.TAB);
				
				driver.findElementById("txtStationTo").clear();
				driver.findElementById("txtStationTo").sendKeys("mdu");
				driver.findElementById("txtStationTo").sendKeys(Keys.TAB);
				
				driver.findElementById("tdDateOnly").click();
				Thread.sleep(2000);
				
				int rowCount = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr").size();
				List<String> trainNames = new ArrayList<String> ();
				
				for (int i = 1; i <= rowCount; i++) {
					
					String text = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]/a").getText();
					trainNames.add(text);
				}
				
				int listSize = trainNames.size();
								
				Set<String> setTrainNames = new HashSet<String>(trainNames);
				
				
				int setSize = setTrainNames.size();
				
				if(listSize == setSize) {
					System.out.println("no duplicates");
				}else {
					System.out.println("duplicates are available");
				}
				
				
				driver.close();
	}

}
