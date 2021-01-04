package testClases;

import pages.CarruselPage;
import pages.RegistroPage;
import pages.RegistroProductoPage;

public class Test_Crear_Producto{
    CarruselPage carrusel = new CarruselPage();
    RegistroPage registroPrincipal = new RegistroPage();
    RegistroProductoPage registroProducto = new RegistroProductoPage();

    public void validarFlujoCarrusel() throws InterruptedException {
        carrusel.validarCarrusel();
        carrusel.recorrerCarrusel();
    }
    public void crearProducto(String nombreProducto,Double precio) throws InterruptedException {
        registroPrincipal.validarPageRegistro();
        registroPrincipal.presionarBtnMas();
        registroPrincipal.presionarCrearProducto();
        registroProducto.validarPageRegistro();
        registroProducto.crearProducto(nombreProducto,String.format("%.2f", precio));
        registroPrincipal.presionarPestañaProducto();
        registroPrincipal.buscarProducto(nombreProducto,String.format("%.2f", precio));
    }
}

