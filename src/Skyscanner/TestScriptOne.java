package Skyscanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class TestScriptOne
{
  public static void main(String[] args) throws InterruptedException
  {
    //Set up incognito browser
    ChromeOptions options = new ChromeOptions();
    options.setCapability("capability_name", "capability_value");
    options.addArguments("incognito");

    //Set up driver and get website
    System.setProperty("webdriver.chrome.driver", "/home/rachel/selenium/chromedriver_linux64/chromedriver");
    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.get("https://www.skyscanner.net/");
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

    //Select departure date
    driver.findElement(By.xpath("//button[@aria-label=\"Saturday, 8 January 2022\"]")).click();

    //Click on Return field
    driver.findElement(By.id("return-fsc-datepicker-button")).click();

    //Select return date
    driver.findElement(By.xpath("//button[@aria-label=\"Saturday, 15 January 2022\"]")).click();

    //Search
    driver.findElement(By.xpath("//button[@aria-label=\"Search flights\"]")).click();

    //Navigates to result page
    String actualTitle = driver.getTitle();
    System.out.println("Your page title is: " + actualTitle);

    //Select flight

    driver.close();
  }
}
