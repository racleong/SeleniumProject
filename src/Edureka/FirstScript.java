package Edureka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {
  public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/home/rachel/selenium/chromedriver_linux64/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.amazon.co.uk");
    driver.manage().window().maximize();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bike");
    Thread.sleep(2000);
    driver.findElement(By.id("nav-search-submit-button")).click();
    Thread.sleep(2000);

    String actualTitle = driver.getTitle();
    System.out.println("Your page title is: " + actualTitle);
    String expectedTitle = "Amazon.co.uk : bike";
    driver.close();
    if (actualTitle.equalsIgnoreCase(expectedTitle)) {
      System.out.println("Test Successful");
    } else {
      System.out.println("Test Failure");
    }
  }
}
