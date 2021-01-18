package techtest.pageObjects;

import deviceDriver.DeviceDriver;
import deviceDriver.DriverType;
import org.openqa.selenium.By;

public class ResultPage extends techtest.pageObjects.BasePage {

    private By infoLines = By.className("android.widget.TextView");
    private By backToSearchButton = By.className("android.widget.ImageButton");


    //Creates the page for the Driver that is specified in Constructor Call
    public ResultPage(DriverType driverType) {

        switch (driverType) {
            case ANDROID:
                appiumDriver = DeviceDriver.getAndroidDriver();
                break;
            case IOS:
                appiumDriver = DeviceDriver.getIosDriver();
                break;
            case ANDROID_SAMSUNG_S105G:
                appiumDriver = DeviceDriver.getSamsungS105GDriver();
                break;
            case ANDROID_GOOGLE_PXL4:
                appiumDriver = DeviceDriver.getPixel4ADriver();
                break;
        }
    }

    public int getListSize(){
        return appiumDriver.findElements(infoLines).size();
    }
    public String getLineOfText(int index){
        return appiumDriver.findElements(infoLines).get(index).getText();
    }

    public void goBack(){
        appiumDriver.findElement(backToSearchButton).click();
    }
}
