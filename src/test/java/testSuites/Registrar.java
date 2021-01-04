package testSuites;

import conexion.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reports.Report;
import testClases.Test_Carrusel;

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

    @Test
    public void Test1() throws InterruptedException {
        Test_Carrusel test = new Test_Carrusel();
        test.validarFlujoCarrusel();
        test.crearProducto("Arroz2",1000.1322);
    }
}
