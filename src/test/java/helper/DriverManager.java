package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static DriverManager driverManager;
    private final Map<DriverType, String[]> driverSettings;

    private DriverManager() {
        String baseFolder = "src/test/resources/drivers";
        driverSettings = new HashMap<DriverType, String[]>() {{
            put(DriverType.FIREFOX, new String[]{"webdriver.gecko.driver", baseFolder + "/geckodriver.exe"});
            put(DriverType.CHROME, new String[]{"webdriver.chrome.driver", baseFolder + "/chromedriver95.exe"});
        }};
    }

    //Gets instance of DriverManager object.
    public static DriverManager getInstance() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    //Gets an instance of WebDriver object.
    public WebDriver getDriver(DriverType driverType) {
        String[] properties = driverSettings.get(driverType);
        System.setProperty(properties[0], properties[1]);

        return createDriver(driverType);
    }

    //Creates an instance of WebDriver object.
    private WebDriver createDriver(DriverType driverType) {
        switch (driverType){
            case FIREFOX :

                return new FirefoxDriver();
            case CHROME :
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                return new ChromeDriver(chromeOptions);
        };

        return null;  //return driver
    }


}