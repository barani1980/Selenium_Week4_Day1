package Week4.Day1;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableJQuery {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable/");
		Thread.sleep(3000);
			
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
			
		WebElement source = driver.findElementByXPath("//ul[@class='ui-sortable']/li[1]");
		WebElement destin = driver.findElementByXPath("//ul[@class='ui-sortable']/li[4]");
		Point destLocat = destin.getLocation();
		int x = destLocat.getX();
		int y = destLocat.getY();
		builder.moveToElement(source).dragAndDropBy(source, x, y).perform();
		
		Thread.sleep(5000);
		driver.close();
	}

}
