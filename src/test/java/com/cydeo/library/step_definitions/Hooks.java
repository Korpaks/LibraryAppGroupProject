package com.cydeo.library.step_definitions;

import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.DBUtilities;
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
        //Here we can setup if scenario has tag name @firefox or @chrome it will check that and it till do test on given browser

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

    @Before("@db")
    public void setupDB(){
        DBUtilities.createConnection(ConfigurationReader.getProperty("library2.db.url"), );
        System.out.println("CONNECTION IS SUCCESSFUL");
    }

    @After("@db")
    public void destroyDB(){
        DBUtilities.destroy();
        System.out.println("CONNECTION IS DESTROYED");
    }
}
