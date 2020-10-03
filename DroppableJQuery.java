package Week4.Day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DroppableJQuery {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		WebElement drag = driver.findElementByXPath("//p[text()='Drag me to my target']");
		WebElement drop = driver.findElementByXPath("//p[text()='Drop here']");
		Actions builder = new Actions(driver);
		
		builder.moveToElement(drag).dragAndDrop(drag, drop).perform();
		Thread.sleep(5000);
		
		
		driver.close();
	}

}
