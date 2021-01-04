package conexion;

import io.appium.java_client.AppiumDriver;

public class DriverContext {

    private static DriverManager driverManager = new DriverManager();

    public static void setUp(String deviceName, String platformName, String app, String udid, boolean emulador)
    {
        driverManager.inicioSession(deviceName,platformName,app,udid,emulador);
    }

    public static AppiumDriver getDriver()
    {
        return driverManager.getDriver();
    }

    public static void quitDriver()
    {
        driverManager.getDriver().quit();
    }
}
