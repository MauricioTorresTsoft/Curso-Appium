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

public class RegistroProductoPage {

    private AppiumDriver driver;
    private Util metodosGenericos = new Util();

    public RegistroProductoPage(){
        this.driver= DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this );
    }

    @AndroidFindBy(xpath = "//*[contains(@text,'Crear Producto')]")
    private MobileElement lblCrearProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement nombreProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/precio")
    private MobileElement precio;

    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;

    public void crearProducto(String nombreProducto,String precio) throws InterruptedException {
        validarInputNombre(nombreProducto);
        validarInputPrecio(metodosGenericos.reemplazaComaxPunto(precio));
        clickBtnConfirmar();
    }

    public void validarPageRegistro() throws InterruptedException {
        if(metodosGenericos.esperarObjeto(lblCrearProducto,3)) {
            if (lblCrearProducto.isDisplayed()) {
                addStep("Se presenta Page Registro Producto", true, Status.PASSED, false);
            } else {
                addStep("Se presenta Page Registo Producto", false, Status.FAILED, true);
            }
        }
    }
    public void validarInputNombre(String nombre) throws InterruptedException {
        if (metodosGenericos.esperarObjeto(nombreProducto, 3)) {
            if (nombreProducto.isDisplayed() && nombreProducto.isEnabled()) {
                nombreProducto.sendKeys(nombre);
                addStep("El campo 'nombre' esta disponible para interaccón", true, Status.PASSED, false);
            } else {
                addStep("El campo 'nombre' NO esta disponible para interaccón", false, Status.FAILED, true);
            }
        }
    }
    public void validarInputPrecio(String precioProducto) throws InterruptedException {
        if (metodosGenericos.esperarObjeto(precio, 3)) {
            if (precio.isDisplayed() && precio.isEnabled()) {
                precio.sendKeys(precioProducto);
                addStep("El campo 'precio' esta disponible para interaccón", true, Status.PASSED, false);
            } else {
                addStep("El campo 'precio' NO esta disponible para interaccón", false, Status.FAILED, true);
            }
        }
    }
    public void clickBtnConfirmar() throws InterruptedException {
        if (metodosGenericos.esperarObjeto(btnConfirmar, 3)) {
            if (btnConfirmar.isDisplayed() && btnConfirmar.isEnabled()) {
                btnConfirmar.click();
                addStep("El botón 'Confirmar' esta disponible para interaccón", false, Status.PASSED, false);
            } else {
                addStep("El campo 'Confirmar' NO esta disponible para interaccón", false, Status.FAILED, true);
            }
        }
    }

}
