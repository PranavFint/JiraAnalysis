// HomePageTest.java

package com.demo.project;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import com.demo.utility.JiraCreateIssue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.demo.listner.TestListener.class)
public class HomePageTest {
  private WebDriver driver;
  private String baseUrl;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    baseUrl = "https://www.browserstack.com/";
    driver.get(baseUrl);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  // Custom annotation explained in following sections
  @JiraCreateIssue(isCreateIssue = true)
  @Test
  public void verifyHomepageHeaderText() throws Exception {
    driver.get(baseUrl);
    WebElement el = driver.findElement(By.xpath("//h1[1]"));
    assertEquals(
        el.getText(),
        "Browser Testing Made Easy",
        "Wrong header text displayed in Home page");
  }

  @JiraCreateIssue(isCreateIssue = true)
  @Test
  public void verifyHomePageLogo() throws Exception {
    WebElement el = driver.findElement(By.id("logo"));
    assertTrue(el.isDisplayed(), "The browserstack logo not displaying in home page");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }
}
