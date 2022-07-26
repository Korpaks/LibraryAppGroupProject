package com.cydeo.library.step_definitions;

import com.cydeo.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(){
        System.out.println("Before Scenario is running");
        //Driver.getDriver().get("https://library2.cydeo.com/login.html");
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("After Scenario is running");

        if(scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
