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
import static utils.Util.esperarObjeto;

public class RegistroDetalleCliente {

    private AppiumDriver driver;
    private Util metodosGenericos = new Util();

    public RegistroDetalleCliente(){
        this.driver= DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this );
    }

    @AndroidFindBy(id = "com.rodrigo.registro:id/eliminar_cliente")
    private MobileElement btnEliminar;

    @AndroidFindBy(id = "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement InputBorrar;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement btnOK;

    public void presionarBtnEliminar() throws InterruptedException {

        if(esperarObjeto(btnEliminar,3)) {
            if (btnEliminar.isDisplayed() && btnEliminar.isEnabled()) {
                btnEliminar.click();
                addStep("El botón 'Eliminar' esta disponible para interaccón", false, Status.PASSED, false);
            } else {
                addStep("El campo 'Eliminat' NO esta disponible para interaccón", false, Status.FAILED, true);
            }
        }
    }

    public void validarInputBorrar() throws InterruptedException {
        if (metodosGenericos.esperarObjeto(InputBorrar, 3)) {
            if (InputBorrar.isDisplayed() && InputBorrar.isEnabled()) {
                InputBorrar.sendKeys("BORRAR");
                addStep("El campo 'InputBorrar' esta disponible para interaccón", true, Status.PASSED, false);
            } else {
                addStep("El campo 'InputBorrar' NO esta disponible para interaccón", false, Status.FAILED, true);
            }
        }
    }
    public void presionarBtnOK() throws InterruptedException {
        if(esperarObjeto(btnOK,2)) {
            if (btnOK.isDisplayed() && btnOK.isEnabled()) {
                btnOK.click();
                addStep("El botón 'OK' esta disponible para interaccón", false, Status.PASSED, false);
            } else {
                addStep("El campo 'OK' NO esta disponible para interaccón", false, Status.FAILED, true);
            }
        }
    }


}
