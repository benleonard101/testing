package api.com.kainos.training.api_selenium_test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.com.kainos.training.api_selenium_test.bbcpage;

public class LoginServiceApiTest {

    WebDriver webDriver;
    bbcpage bbcpage;

    @Before
    public void setupWebddriver() {
        webDriver = new FirefoxDriver();
        bbcpage = new bbcpage(webDriver);

        bbcpage.onThirdLink(2);
    }

    @After
    public void closeWebdriverConnection() {
        webDriver.close();
    }

    @Test

    public void bbc3(){


        bbcpage.onThirdLink(2);
    }

    @Test
    public void loginSuccessTest() {

        webDriver.get("http://localhost:8900/test/login");

        WebElement usernameField = webDriver.findElement(By.name("username"));

        Assert.assertTrue(usernameField.isDisplayed());

        usernameField.sendKeys("admin");

        WebElement passwordField = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));

        Assert.assertTrue(passwordField.isDisplayed());

        passwordField.sendKeys("password");

        WebElement button = webDriver.findElement(By.name("button"));
        button.click();

        WebElement pageText = webDriver.findElement(By.id("message"));

        pageText.toString().contains("success");
    }

    @Test
    public void loginFailureTest() {

        webDriver.get("http://localhost:8900/test/login");

        WebElement usernameField = webDriver.findElement(By.name("username"));

        Assert.assertTrue(usernameField.isDisplayed());

        usernameField.sendKeys("admin");

        WebElement passwordField = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));

        Assert.assertTrue(passwordField.isDisplayed());

        passwordField.sendKeys("password1");

        WebElement button = webDriver.findElement(By.name("button"));
        button.click();

        WebElement pageText = webDriver.findElement(By.id("message"));

        pageText.toString().contains("failure");

    }

//    @Test
//    public void bbcTest() {
//
//        webDriver.get("http://www.bbc.co.uk");
//
//        WebElement newsLink = (new WebDriverWait(webDriver, 10)
//                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("News"))));
//
//        newsLink.click();
//
//        WebElement thirdMostPopularstory = (new WebDriverWait(webDriver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".column-1:nth-child(3) .most-popular-list-item__headline , .column-1:nth-child(5) .most-popular-list-item__headline")));
//
//        Assert.assertTrue(thirdMostPopularstory.getText().contains("final reaches"));
//
//    }
//
//
//
//    @Test
//    public void bbcTest2() {
//
//        webDriver.get("http://www.bbc.co.uk");
//
//        WebElement newsLink = (new WebDriverWait(webDriver, 10)
//                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("News"))));
//
//        newsLink.click();
//
//        WebElement thirdMostPopularstory = (new WebDriverWait(webDriver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".column-1:nth-child(3) .most-popular-list-item__headline , .column-1:nth-child(5) .most-popular-list-item__headline")));
//
//        Assert.assertTrue(thirdMostPopularstory.getText().contains("final reaches"));
//
//    }
//
//
//
//
//    @Test
//    public void googleTest() {
//
//        webDriver.get("http://www.google.co.uk");
//
//        WebElement searchLink = (new WebDriverWait(webDriver, 10)
//                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lst-ib"))));
//
//        Assert.assertTrue(searchLink.isDisplayed());
//
//    }
//
//    @Test
//    public void ticketmasterOrderTest() {
//
//        webDriver.get("http://www.ticketmaster.co.uk");
//
//
//        Select select = new Select(webDriver.findElement(By.xpath("/html/body[@id='body']/div[@id='site-header']/div[@class='frame clearfix require_ie_fix']/div[2]/ul[@id='site-nav']/li[@id='sports']/a[@id='navLinkCat_sports']/span")));
//        select.deselectAll();
//        select.selectByVisibleText("Football");
//
//    }


}
