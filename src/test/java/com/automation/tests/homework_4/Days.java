package com.automation.tests.homework_4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

public class Days {

    private WebDriver driver;

    /*
    DAYS
    1. go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
    2. Randomly select a checkbox.
    3. As soon as you check any day, print the name of the day
    4. and uncheck immediately.
    5. After you check and uncheck Friday for the third time, exit the program.

    NOTE: Remember some checkboxes are not selectable. You need to find a way
    to ignore them when they are randomly selected. It has to be dynamic.
    Do not hard code Saturday and Sunday. Use values of certain attributes.
     */

    @Test
    public void selectDayTest()throws Exception{

        //1. go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        driver.manage().window().maximize();

        //to check disable or not = > if disabled we will not click it
        List<WebElement> daysCheckboxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        //to get the text of days that are selected
        //List<WebElement> dayNames = driver.findElements(By.xpath("//input[@type=\"checkbox\"]/following-sibling::label"));
        List<WebElement> dayNames = driver.findElements(By.cssSelector(".gwt-CheckBox>label"));//  => css selector

        Random random = new Random();
        int countOfFriday = 0;
        do {

            int index = random.nextInt(daysCheckboxes.size());

            //5. After you check and uncheck Friday for the third time, exit the program.
            //(count to see how many times you click)
            if(dayNames.get(index).getText().equals("Friday")){
                countOfFriday++;
            }
            if( daysCheckboxes.get(index).isEnabled()) {
                //2. Randomly select a checkbox (index comes from random class object)
                daysCheckboxes.get(index).click();
                Thread.sleep(500);
                //3. As soon as you check any day, print the name of the day
                System.out.println(dayNames.get(index).getText());
                //4. and uncheck immediately.
                daysCheckboxes.get(index).click();
            }else{
                continue;
            }

         //5. After you check and uncheck Friday for the third time, exit the program.
        }while (countOfFriday != 3);
    }

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
