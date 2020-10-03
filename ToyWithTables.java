package Week4.Day1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyWithTables {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/table.html");
		Thread.sleep(1000);
		
		List<WebElement> headers = driver.findElementsByXPath("//table[@id='table_id']//th");
		int countOfHeaders = headers.size();
		System.out.println("Number of columns = " + countOfHeaders);
		
		List<WebElement> rows = driver.findElementsByXPath("//table[@id='table_id']//tr");
		int countOfRows = rows.size();
		System.out.println("Number of rows = " + countOfRows);

		List<String> proRate = new ArrayList<String>();
		
		
		for (int i = 2; i <= countOfRows; i++  ) {
			WebElement details = driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]/td[1]");
			WebElement progress = driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]/td[2]");
			
			String text1 = details.getText();
			String text2 = progress.getText();
			if (text1.equals("Learn to interact with Elements")) {
				System.out.println("Progress value of " + text1 + " = " + text2);
			}
			proRate.add(text2);
			
		}
		System.out.println(proRate);
		
		driver.findElementByXPath("//table[@id='table_id']//tr[4]/td[3]/input").click();
		Thread.sleep(3000);
		
		driver.close();
	}

}
