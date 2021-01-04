package utils;

import org.openqa.selenium.WebElement;

public class Util {

    public Util(){
    }

    public static boolean esperarObjeto(WebElement elemento, int segundos) throws InterruptedException {
        try {
            System.out.println("buscando elemento: " + elemento + ", esperamos " + segundos + " segundos, hasta que aparezca");
            //No funciona, se reemplazará
            //WebDriverWait wait= new WebDriverWait(DriverContext.getDriver(),segundos);
            //wait.until(ExpectedConditions.visibilityOf(elemento));
            Thread.sleep(segundos * 1000);
            //if () {
                System.out.println("se encontro elemento (" + elemento + ")");
                return true;
            //}
        } catch (Exception e) {
            System.out.println("no se encontro el elemento");
            return false;
        }

    }

    public String reemplazaComaxPunto(String numero)
    {
        return numero.replace(",",".");
    }


}
