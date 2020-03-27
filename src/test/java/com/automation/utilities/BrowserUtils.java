package com.automation.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public static void wait(int seconds){

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    //to collect text and  to be able to compare as expected
    // to convert the List of Collections to WebElement in order to use the Assert method?
    //We created list of WebElement in our test method. But in assert method we need to compare two list of Strings.
    //Browser utils convert our list of WebElement to list of String. To make life easier. This is what I understand :))
    public static List<String> getTextFromWebElement(List<WebElement> elements){

        List<String> textValues = new ArrayList<String>();

        for(WebElement element : elements){
            textValues.add(element.getText());
        }
        return textValues;
    }
}
