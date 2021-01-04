package testSuites;

import conexion.DriverContext;
import io.appium.java_client.MobileElement;
import io.qameta.allure.model.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reports.Report;

import static conexion.DriverContext.setUp;
import static reports.Report.addStep;

public class EjemploDriver {

    @BeforeMethod
    public void inicioSession()    {
        setUp("4200b529972d6449","Android","f:\\Documents\\registroDeUsuarios.apk","4200b529972d6449",false);
    }

    @AfterMethod
    public void cerrarSession(){
        Report.finalAssert();
        DriverContext.quitDriver();

    }

    @Test
    public void Test121(){
        MobileElement btnNext=(MobileElement) DriverContext.getDriver().findElementById("com.rodrigo.registro:id/next");
        btnNext.click();
        btnNext.click();
        addStep("validar tercera vista carrusel",true, Status.FAILED,false);
    }
}
