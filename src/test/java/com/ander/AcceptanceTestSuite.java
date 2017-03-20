package com.ander;

import com.ander.single.step_definition.GoogleSteps;
import driver.DriverFactory;
import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 3/20/2017.
 */
public class AcceptanceTestSuite extends SerenityStories {
    private WebDriver driver;
    private DriverFactory driverFactory;

    public AcceptanceTestSuite() {
        driverFactory = new DriverFactory();
        driver = driverFactory.createWebDriver("chrome");
        getAllNeededSteps();
        findStoriesCalled(stories());
        runSerenity();
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), getAllNeededSteps());
    }

    private List<Object> getAllNeededSteps() {
        List<Object> stepObjects = new ArrayList<>();
        stepObjects.add(new GoogleSteps(driver));
        return stepObjects;
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration();
    }

    public String stories() {
        return "example.story";
    }
}
