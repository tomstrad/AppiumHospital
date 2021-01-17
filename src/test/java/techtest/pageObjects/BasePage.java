package techtest.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static org.junit.Assert.fail;

public abstract class BasePage {
    AppiumDriver<MobileElement> appiumDriver;

    boolean isElementDisplayed(By element) {
        List<MobileElement> elements = appiumDriver.findElements(element);
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    boolean isElementEnabled(By element) {
        List<MobileElement> elements = appiumDriver.findElements(element);
        return !elements.isEmpty() && elements.get(0).isEnabled();
    }

    boolean isElementSelected(By element) {
        List<MobileElement> elements = appiumDriver.findElements(element);
        return !elements.isEmpty() && elements.get(0).isSelected();
    }

}
