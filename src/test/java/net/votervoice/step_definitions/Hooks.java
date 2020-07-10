package net.votervoice.step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.votervoice.util.ConfigurationReader;
import net.votervoice.util.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks { @Before
public void setUp(){
    System.out.println("Before hooks");
    Driver.get().get(ConfigurationReader.get("url"));
    Driver.get().manage().window().maximize();
    Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        System.out.println("After hooks");
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        Driver.closeDriver();
    }
}

