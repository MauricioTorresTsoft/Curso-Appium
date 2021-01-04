package testSuites;

import conexion.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reports.Report;
import testClases.Test_Crear_Producto;

import static conexion.DriverContext.setUp;

public class Registrar {

    @BeforeMethod
    public void inicioSession(){
        setUp("4200b529972d6449",
                "Android",
                "f:\\Documents\\registroDeUsuarios.apk",
                "4200b529972d6449",false);
    }

    @AfterMethod
    public void cerrarSession(){
        Report.finalAssert();
        DriverContext.quitDriver();

    }

    @Test(description = "Se agrega un nuevo producto (nombre y precio), luego se verifica su creación en un listado de productos")
    public void Test_Case1() throws InterruptedException {
        Test_Crear_Producto test = new Test_Crear_Producto();
        test.validarFlujoCarrusel();
        test.crearProducto("Arroz",1000.1322);
    }
}
