package ui.com.kainos.training.api_selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by benl on 27/10/2016.
 */
public class bbcpage {

    WebDriver webDriver;

    public  bbcpage(WebDriver webDriver){

        this.webDriver = webDriver;
    }


    public void onThirdLink(int n){

        webDriver.get("http://www.bbc.co.uk/news");

        List<WebElement> newslink = webDriver.findElements(By.cssSelector(".most-popular-list-item__link"));

      newslink.get(n-1).click();



    }
}
