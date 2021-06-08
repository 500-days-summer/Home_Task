package step_defs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.EnvironmentManager;

public class Hooks {


    @Before
    public void setUp() throws Exception{
        EnvironmentManager.setUpEnvironment();

    }

    @After
    public void tearDown(Scenario scenario){
        try{
            if(scenario.isFailed()){
                final byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot,"image/png");
            }

        }catch(Exception e){
            System.out.println("The error happened while taking screenshot and cleaning up after the test");
            e.getMessage();
        }

        Driver.closeDriver();
    }





}
