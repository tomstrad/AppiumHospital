package deviceDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DeviceDriver {

    private static AppiumDriver<MobileElement> androidDriver;
    private static AppiumDriver<MobileElement> iosDriver;
    private static AppiumDriver<MobileElement> samsungS105GDriver;
    private static AppiumDriver<MobileElement> pixel4ADriver;


    private static AppiumDriverLocalService appiumServer = AppiumDriverLocalService.buildDefaultService();


    public synchronized static AppiumDriver<MobileElement> getAndroidDriver() {


        if (androidDriver == null) {

            //Set the Desired Capabilities
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "device");
            caps.setCapability("udid", "emulator-5554"); //Give Device ID of your mobile phone
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "11.0");
            caps.setCapability("appPackage", "com.sensynehealth.hospitals");
             caps.setCapability("appActivity", "com.sensynehealth.hospitals.activities.MainActivity");
            caps.setCapability("noReset", "false");
            caps.setCapability("autoGrantPermissions", "true");
            caps.setCapability("automationName", "uiautomator2");

            try {
                appiumServer.start();
                System.out.println("Server started");

                androidDriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
                System.out.println("driver created");
                androidDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            } finally {
                Runtime.getRuntime().addShutdownHook(
                        new Thread(new DriverCleanup()));
            }
//
        }
//
        return androidDriver;
    }
    public synchronized static AppiumDriver<MobileElement> getSamsungS105GDriver() {
        if (samsungS105GDriver == null) {

            //Set the Desired Capabilities
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "device");
            caps.setCapability("udid", "5200ca1342bbc5fb"); //Give Device ID of your mobile phone
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "8.0");
            caps.setCapability("appPackage", "com.sensynehealth.hospitals");
            caps.setCapability("appActivity", "com.sensynehealth.hospitals.activities.MainActivity");
            caps.setCapability("noReset", "false");
            caps.setCapability("autoGrantPermissions", "true");
            caps.setCapability("automationName", "uiautomator2");


            try {
                samsungS105GDriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
                samsungS105GDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            }
            finally {
                Runtime.getRuntime().addShutdownHook(
                        new Thread(new DriverCleanup()));
            }

        }

        return samsungS105GDriver;
    }


    public synchronized static AppiumDriver<MobileElement> getPixel4ADriver() {
        if (pixel4ADriver == null) {

            //Set the Desired Capabilities
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "device");
            caps.setCapability("udid", "5200ca1342bbc5fb"); //Give Device ID of your mobile phone
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "8.0");
            caps.setCapability("appPackage", "com.sensynehealth.hospitals");
            caps.setCapability("appActivity", "com.sensynehealth.hospitals.activities.MainActivity");
            caps.setCapability("noReset", "false");
            caps.setCapability("autoGrantPermissions", "true");
            caps.setCapability("automationName", "uiautomator2");


            try {
                pixel4ADriver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
                pixel4ADriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            }
            finally {
                Runtime.getRuntime().addShutdownHook(
                        new Thread(new DriverCleanup()));
            }

        }

        return pixel4ADriver;
    }

    public synchronized static AppiumDriver<MobileElement> getIosDriver() {
        throw new UnsupportedOperationException("Not supported yet. You are trying to run IOS!");
    }

    private static class DriverCleanup implements Runnable {
        public void run() {
            appiumServer.stop();
            System.out.println("Closing the Driver");
            close();

        }


        public static void close() {
            try {

                getAndroidDriver().quit();
                androidDriver = null;
                System.out.println("Closing the browser");

            } catch (UnreachableBrowserException e) {
                System.out.println("cannot close browser: unreachable browser");
            }
        }



    }
}

