package testSuites;

import conexion.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reports.Report;
import testClases.Test_Borrar_Cliente;
import testClases.Test_Crear_Producto;

import java.io.File;

import static conexion.DriverContext.setUp;

public class Registrar {

    public static String pathDirectorio = new File("").getAbsolutePath();
    public static String app = new String( pathDirectorio.concat( "\\src\\app_apk\\registroDeUsuarios.apk" ) );

    @BeforeMethod
    public void inicioSession(){
        setUp("4200b529972d6449",
                "Android",
                app,
                "4200b529972d6449",false);
        //"f:\\Documents\\registroDeUsuarios.apk"

    }

    @AfterMethod
    public void cerrarSession(){
        Report.finalAssert();
        DriverContext.quitDriver();
    }

    @Test(priority = 1, description = "Se agrega un nuevo producto (nombre y precio), " +
            "luego se verifica su creación en un listado de productos")
    public void Test_Case1() throws InterruptedException {
        Test_Crear_Producto test = new Test_Crear_Producto();
        test.validarFlujoCarrusel();
        test.crearProducto("Arroz",1000.1322);
        Report.finalAssert();
    }

    @Test(priority = 2, description = "se elimina a un cliente predefinido ," +
            "luego se verifica su correcta eliminación en la lista de clientes")
    public void Test_Case3() throws InterruptedException {
        Test_Borrar_Cliente test = new Test_Borrar_Cliente();
        test.validarFlujoCarrusel();
        //SE DEBE ESPECIFICAR EL NOMBRE PREVIAMENTE CREADO EN LA APP
        test.borrarCliente("Emilia");
        Report.finalAssert();
    }
}
