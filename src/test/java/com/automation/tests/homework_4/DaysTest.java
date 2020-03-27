package com.automation.tests.homework_4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DaysTest {

    private WebDriver driver;
    @Test
    public void daysTest(){

        driver = DriverFactory.createDriver("chrome");
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=\"checkbox\"]"));
        List<WebElement> dayNames = driver.findElements(By.cssSelector(".gwt-CheckBox>label"));

        Random random = new Random();

        int counter = 0;
        while (counter<3){
            int index = random.nextInt(checkboxes.size());
            if(checkboxes.get(index).isEnabled()) {
                checkboxes.get(index).click();
                if(dayNames.get(index).getText().equals("Friday")){
                 counter++;
                }
                System.out.println(dayNames.get(index).getText());
                checkboxes.get(index).click();
            }
        }
        driver.quit();
    }
}
