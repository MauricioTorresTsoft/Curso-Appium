package testSuites;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class EjemploDriver {

    public void inicioSession()
    {
        AppiumDriver driver;
        URL server = null;
        try {
            server= new URL("http:");
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","");
        cap.setCapability("","");
        cap.setCapability("","");
        cap.setCapability("","");
    }
}
