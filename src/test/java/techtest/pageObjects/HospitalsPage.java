package techtest.pageObjects;

import deviceDriver.DeviceDriver;
import deviceDriver.DriverType;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.sql.SQLOutput;
import java.util.List;

public class HospitalsPage extends techtest.pageObjects.BasePage {

    private By titleHospitals = By.id("com.sensynehealth.hospitals:id/toolbar");
    private By listHospitals =  By.id("com.sensynehealth.hospitals:id/list");
    private By hospitalName = By.id("com.sensynehealth.hospitals:id/hospitalName");
    private By hospitalType = By.id("com.sensynehealth.hospitals:id/hospitalType");
    private By searchBar = By.id("com.sensynehealth.hospitals:id/search_bar");
    private By editableSearchBar = By.id("com.sensynehealth.hospitals:id/search_src_text");
    private By searchButton = By.id("com.sensynehealth.hospitals:id/search_button");
    private By searchClose = By.id("com.sensynehealth.hospitals:id/search_close_btn");



    //Creates the page for the Driver that is specified in Constructor Call
    public HospitalsPage(DriverType driverType) {

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


    public boolean isTitleVisible(){
        return isElementDisplayed(titleHospitals);
    }

    public boolean isListVisible(){
        return isElementDisplayed(listHospitals);
    }

    public int getListSize(){
        List<MobileElement> elements = appiumDriver.findElements(hospitalName);
        return elements.size();
    }

    public boolean isSearchBarVisible(){
        return isElementDisplayed(searchBar);
    }

    public boolean isSearchBarUsable(){
        return isElementEnabled(searchBar);
    }

    public void clickSearchButton(){
        appiumDriver.findElement(searchButton).click();
    }

    public boolean isSearchBoxTextEntryVisible(){
        return isElementDisplayed(editableSearchBar);
    }

    public void enterSearchText(String text){
        appiumDriver.findElement(editableSearchBar).sendKeys(text);
    }

    public String getSearchText(){
        return appiumDriver.findElement(editableSearchBar).getText();
    }

    public boolean isTypeVisible(){
        return isElementDisplayed(hospitalType);
    }

    public boolean isSearchClearVisible(){
        return isElementDisplayed(searchClose);
    }

    public void clickClearSearch(){
        appiumDriver.findElement(searchClose).click();
    }

    public String getFirstResultHospitalName(){
        return appiumDriver.findElements(hospitalName).get(0).getText();
    }

    public boolean checkAllNamesForString(String str){
        boolean retVal = false;
        List<MobileElement> nameList = appiumDriver.findElements(hospitalName);
        for(MobileElement me : nameList) {
            System.out.println(me.getText());
            retVal = me.getText().contains(str);
        }
        return retVal;
    }

    public void clickFirstItemInList(){
        appiumDriver.findElement(hospitalName).click();
    }
}
