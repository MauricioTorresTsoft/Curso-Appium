package conexion;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private AppiumDriver driver;
    private URL server = null;
    private DesiredCapabilities cap = new DesiredCapabilities();

    protected void inicioSession(String deviceName, String platformName, String app, String udid, boolean emulador)
    {
        try {
            server= new URL("http://localhost:4723/wd/hub");
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        /*cap.setCapability("deviceName","4200b529972d6449");
        cap.setCapability("platformName","Android");
        cap.setCapability("app","f:\\Documents\\registroDeUsuarios.apk");
        cap.setCapability("udid","4200b529972d6449");
         */
        cap.setCapability("deviceName",deviceName);
        cap.setCapability("platformName",platformName);
        cap.setCapability("app",app);
        cap.setCapability("udid",udid);
        if(!emulador) {
            cap.setCapability("udid",udid);
        }

        driver= new AndroidDriver(server,cap);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected AppiumDriver getDriver()
    {

        return driver;
    }
}
