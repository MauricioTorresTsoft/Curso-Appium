package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;
import utils.Util;

import static reports.Report.addStep;

public class CarruselPage {
    private AppiumDriver driver;
    public Util metodosGenericos = new Util();

    public CarruselPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.rodrigo.registro:id/next")
    private MobileElement btnNext;

    @AndroidFindBy(xpath = "//*[contains(@text,'Échale un vistazo')]")
    private MobileElement carruseldesplegado;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement permisosAppAceptar;

    @AndroidFindBy(id = "com.rodrigo.registro:id/done")
    private MobileElement btnHecho;

    public void validarCarrusel() throws InterruptedException {
        System.out.println("se validará que exista el carrusel mediante un texto = " + carruseldesplegado.getText());
        if (metodosGenericos.esperarObjeto(carruseldesplegado, 3)) {
            addStep("Se presenta el carrusel", true, Status.PASSED, false);
        } else {
            addStep("No se presenta el carrusel", false, Status.FAILED, true);
        }
    }

    public void recorrerCarrusel() {
        System.out.println("se recorrerá el Carrusel");
        for (int i = 0; i < 3; i++) {
            btnNext.click();
        }
        if (permisosAppAceptar.isDisplayed()) {
            permisosAppAceptar.click();
            addStep("Se presiona botón de permisos para continuar con el carrusel", true, Status.PASSED, false);
        } else {
            addStep("El boton de permisos no se encuentra desplegado", false, Status.FAILED, true);
        }
        if (btnHecho.isDisplayed()) {
            btnHecho.click();
            addStep("Se presiona botón de hecho para finalizar el carrusel", true, Status.PASSED, false);
        } else {
            addStep("El boton de Hechp no se encuentra desplegado", false, Status.FAILED, true);
        }
    }
}


