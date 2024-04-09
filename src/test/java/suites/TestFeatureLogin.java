package suites;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.extern.java.Log;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

@Test
@Ignore
@Log
public class TestFeatureLogin {


    private static final String APPIUM_HOST = "http://127.0.0.1";
    private static final int APPIUM_PORT = 4723;

    private static AndroidDriver getDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("C:\\Kerja\\git\\empty\\apk\\ApiDemos-debug.apk");
        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setPlatformVersion("10.0");

//        DesiredCapabilities options = new DesiredCapabilities();
//        options.setCapability("appium:DeviceName","emulator-5554");
//        options.setCapability("appium:App","C:\\Kerja\\git\\empty\\apk\\ApiDemos-debug.apk");
//        options.setCapability("PlatformName","Android");
//        options.setCapability("appium:PlatformVersion","10.0");
//        options.setCapability("appium:automationName","UIAutomator2");

        String appiumServer = String.format("%s:%d/wd/hub",APPIUM_HOST,APPIUM_PORT);
        log.info("this is the format appium host: port " + appiumServer);
        AndroidDriver android = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"),
                options
        );

        return android;
    }


    public void Test1AsASample() throws MalformedURLException {

        AndroidDriver androidDriver = getDriver();
        log.info("Running the test");
        try{
            androidDriver.findElement(AppiumBy.accessibilityId("Animation"));
            androidDriver.findElement(AppiumBy.accessibilityId("Cloning"));
            androidDriver.findElement(AppiumBy.accessibilityId("Run"));
        }
        finally {
            androidDriver.quit();
        }
    }

}
