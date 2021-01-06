package utils;

import conexion.DriverContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {

    public Util(){
    }

    public static boolean esperarObjeto(MobileElement elemento, int segundos) throws InterruptedException {
        try {
            System.out.println("buscando elemento: " + elemento + ", esperamos " + segundos + " segundos, hasta que aparezca");
            //No funciona, se reemplazará
            WebDriverWait wait= new WebDriverWait(DriverContext.getDriver(),segundos);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            //Thread.sleep(segundos * 1000);

            System.out.println("se encontro elemento (" + elemento + ")");
            return true;

        } catch (Exception e) {
            System.out.println("no se encontro el elemento");
            return false;
        }

    }

    public static void swipeAbajo() throws InterruptedException {
        Thread.sleep(2000);
        int ancho = (int) (DriverContext.getDriver().manage().window().getSize().width * 0.08D);
        int startPoint = (int) (DriverContext.getDriver().manage().window().getSize().height *0.9D);
        int endPoint = (int) (DriverContext.getDriver().manage().window().getSize().height * 0.65D);

        TouchAction touchAction = new TouchAction(DriverContext.getDriver());
        touchAction.press(PointOption.point(ancho,startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500L))).moveTo(PointOption.point(ancho,endPoint)).release().perform();
        System.out.println("[Util] Swipe hacia abajo");

    }

    public String reemplazaComaxPunto(String numero)
    {
        return numero.replace(",",".");
    }



}
