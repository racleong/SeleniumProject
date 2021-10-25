package Edureka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "/home/rachel/selenium/chromedriver_linux64/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.amazon.co.uk");
    driver.manage().window().maximize();

    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("carabiner");

    driver.findElement(By.id("nav-search-submit-button")).click();
  }

}
