package Week4.Day1;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableJQuery {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/selectable/");
		Thread.sleep(1000);
		
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		WebElement item1 = driver.findElementByXPath("//ol[@id='selectable']/li[1]");
		WebElement item3 = driver.findElementByXPath("//ol[@id='selectable']/li[3]");
		WebElement item5 = driver.findElementByXPath("//ol[@id='selectable']/li[5]");
		WebElement item7 = driver.findElementByXPath("//ol[@id='selectable']/li[7]");
		
		builder.keyDown(Keys.CONTROL).perform();
		builder.click(item1).click(item3).click(item5).click(item7).perform();
		Thread.sleep(1000);
		builder.keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(4000);
		driver.close();

	}

}
