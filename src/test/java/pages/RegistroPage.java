package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Util;

import java.util.List;

import static reports.Report.addStep;

public class RegistroPage {

    private AppiumDriver driver;
    public Util metodosGenericos = new Util();

    public RegistroPage(){
        this.driver= DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this );
    }

    @AndroidFindBy(xpath = "//*[contains(@text,'Registro')]")
    private MobileElement lblRegistro;

    @AndroidFindBy(id = "com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnMas;

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_producto")
    private MobileElement btnCrearProducto;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'PRODUCTOS')]")
    private MobileElement pestañaProductos;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView")
    private List<MobileElement> listaProductosRegistrados;

    @AndroidFindBy(xpath = "//*[@resource-id='com.rodrigo.registro:id/nombre_producto']")
    private List<MobileElement> listaNombreProducto;

    @AndroidFindBy(xpath = "//*[@resource-id='com.rodrigo.registro:id/precio_producto']")
    private List<MobileElement> listaPrecioProducto;

    @AndroidFindBy(xpath = "//*[@resource-id='com.rodrigo.registro:id/nombre_cliente']")
    private List<MobileElement> listaClientesRegistrado;

    @AndroidFindBy(xpath = "//*[contains(@text,'No hay clientes, registre sus clientes y productos antes de realizar acciones')]")
    private MobileElement lblSinClientes;

    public void presionarPestañaProducto() throws InterruptedException {
        if(metodosGenericos.esperarObjeto(pestañaProductos,3)){
            if(pestañaProductos.isDisplayed() && pestañaProductos.isEnabled()){
                pestañaProductos.click();
                addStep("La pestaña 'PRODUCTOS' esta disponible para interacción",true, Status.PASSED,false);
            }
            else {
                addStep("La pestaña 'PRODUCTOS' NO esta disponible para interacción",true, Status.FAILED,true);
            }
        }
    }

    public void presionarBtnMas() throws InterruptedException {
        if(metodosGenericos.esperarObjeto(pestañaProductos,3)){
            if(pestañaProductos.isDisplayed() && pestañaProductos.isEnabled()){
                btnMas.click();
                addStep("El botón 'Más' esta disponible para interacción",true, Status.PASSED,false);
            }
            else {
                addStep("El botón 'Más' NO esta disponible para interacción",true, Status.FAILED,true);
            }
        }
    }
    public void presionarCrearProducto() throws InterruptedException {
        if(metodosGenericos.esperarObjeto(btnCrearProducto,3)) {
            if (btnCrearProducto.isDisplayed() && btnCrearProducto.isEnabled()) {
                btnCrearProducto.click();
                addStep("El botón 'Crear Producto' esta disponible para interacción", true, Status.PASSED, false);
            } else {
                addStep("El botón 'Crear Producto' NO esta disponible para interacción", true, Status.FAILED, true);
            }
        }
    }

    public void validarPageRegistro() throws InterruptedException {
        if(metodosGenericos.esperarObjeto(lblRegistro,3)) {
            if (lblRegistro.isDisplayed()) {
                addStep("Se presenta Page principal Registro", true, Status.PASSED, false);
            } else {
                addStep("Se presenta Page principal Registro", false, Status.FAILED, true);
            }
        }
    }

    public void buscarProducto(String producto,String precio){
        String nombreActual;
        String precioActual;
        boolean coincide=false;
        for(int i=0;i<=listaNombreProducto.size();i++){
            nombreActual=listaNombreProducto.get(i).getText();
            precioActual=listaPrecioProducto.get(i).getText();
            if(nombreActual.equals(producto) && precioActual.equals(metodosGenericos.reemplazaComaxPunto(precio)))
            {
                System.out.println("[VALIDACIÓN] El nombre del producto a buscar es '"+producto+"' \n" +
                        "y se encontro en la posición "+i+" de la lista");
                System.out.println("[VALIDACIÓN] El precio del producto "+producto+" es '"+metodosGenericos.reemplazaComaxPunto(precio)+"' \n" +
                        "y se encontro en la posición "+i+" de la lista");
                coincide=true;
                break;
            }
        }
        if (coincide) {
            addStep("Se encuentra producto creado anteriormente", true, Status.PASSED, false);
        } else {
            addStep("No se encuentra producto creado anteriormente", false, Status.FAILED, true);
        }
    }

    public void buscarClienteEliminado(String clientePredefinido){
        String nombreActual;
        boolean coincide=false;
        if(listaClientesRegistrado.size()>0) {
            for(int i=0;i<listaClientesRegistrado.size();i++){
                nombreActual=listaClientesRegistrado.get(i).getText();
                if(nombreActual.equals(clientePredefinido) && listaClientesRegistrado.get(i).isDisplayed()
                        && listaClientesRegistrado.get(i).isEnabled())
                {
                    coincide=true;
                }
            }
        }
        else{
            coincide=false;
        }

        if (!coincide) {
            System.out.println("[Verificación] El cliente no se encuentra en la lista, se ha eliminado correctamente");
            addStep("Se eliminó el cliente correctamente", true, Status.PASSED, false);
        } else {
             addStep("El cliente se visualiza en la lista de Clientes, no se elimino correctamente", false, Status.FAILED, true);
        }
    }
    public void presionarClientePredefinido(String clientePredefinido) throws InterruptedException {
        MobileElement cliente = (MobileElement) driver.findElement(By.xpath("//*[contains(@text,'"+clientePredefinido+"')]"));
        if(metodosGenericos.esperarObjeto(cliente,3)){
            if(cliente.isDisplayed() && cliente.isEnabled()){
                cliente.click();
                addStep("El cliente esta disponible para interacción",true, Status.PASSED,false);
            }
            else {
                addStep("El cliente NO esta disponible para interacción",true, Status.FAILED,true);
            }
        }
    }
    public void validarSinCliente() throws InterruptedException {
        if(metodosGenericos.esperarObjeto(lblSinClientes,3)) {
            if (lblSinClientes.isDisplayed()) {
                addStep("[Validación] Se valida que no hay clientes registrados, por lo tanto se elimino el cliente correctamente", true, Status.PASSED, false);
            } else {
                addStep("Hay registro de clientes", false, Status.FAILED, true);
            }
        }
    }
}
