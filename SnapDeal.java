package Week4.Day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(9000);
		
		Actions builder = new Actions(driver);
		
		WebElement men = driver.findElementByXPath("//div[@class='leftNavigationLeftContainer expandDiv']//li[@navindex='6']//span");
		WebElement shirts = driver.findElementByXPath("//div[@id='category6Data']//div[@class='midData colDataBlk']//p[3]/a");
		
		builder.moveToElement(men).perform();				Thread.sleep(2000);
		builder.moveToElement(shirts).click().perform();	Thread.sleep(6000);
		
		WebElement firstShirtHover = driver.findElementByXPath("//div[@class='col-xs-6  favDp product-tuple-listing js-tuple ']//a");
		builder.moveToElement(firstShirtHover).perform();
		Thread.sleep(3000);
		
		WebElement quickView = driver.findElementByXPath("//div[@class='col-xs-6  favDp product-tuple-listing js-tuple ']//div[contains(text(),'Quick')]");
		builder.moveToElement(quickView).click().perform();
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
