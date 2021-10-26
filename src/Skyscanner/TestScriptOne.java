package Skyscanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TestScriptOne
{
  public static void main(String[] args) throws InterruptedException
  {
    //Set up
    System.setProperty("webdriver.chrome.driver", "/home/rachel/selenium/chromedriver_linux64/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.skyscanner.net/");
    driver.manage().window().maximize();
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    //Clicks "Accepts Cookies" button
    driver.findElement(By.id("acceptCookieButton")).click();

    //Enter "Alicante" in "To:" field
    driver.findElement(By.id("fsc-destination-search")).sendKeys("Alicante");

    //Click on Depart field
    driver.findElement(By.id("depart-fsc-datepicker-button")).click();

    //Declare "month-year" drop-down element
    Select dropMonthYear = new Select(driver.findElement(By.id("depart-calendar__bpk_calendar_nav_select")));
    dropMonthYear.selectByVisibleText("January 2022");

    //Select date
    //driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).click();

    driver.close();
  }
}
