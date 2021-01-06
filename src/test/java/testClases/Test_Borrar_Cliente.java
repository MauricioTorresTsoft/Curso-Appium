package testClases;

import pages.CarruselPage;
import pages.RegistroDetalleCliente;
import pages.RegistroPage;
import utils.Util;

public class Test_Borrar_Cliente {

    CarruselPage carrusel = new CarruselPage();
    RegistroPage registroPrincipal = new RegistroPage();
    RegistroDetalleCliente registroDetalleCliente= new RegistroDetalleCliente();
    Util util=new Util();

    public void validarFlujoCarrusel() throws InterruptedException {
        carrusel.validarCarrusel();
        carrusel.recorrerCarrusel();
    }

    public void borrarCliente(String nombreCliente) throws InterruptedException {
        registroPrincipal.presionarClientePredefinido(nombreCliente);
        util.swipeAbajo();
        registroDetalleCliente.presionarBtnEliminar();
        registroDetalleCliente.validarInputBorrar();
        registroDetalleCliente.presionarBtnOK();
        //se comenta ya que al eliminar y volvel a la pág. principal, el elemento sigue existiendo pero no visible.
        //registroPrincipal.buscarClienteEliminado(nombreCliente);
        registroPrincipal.validarSinCliente();
    }



}
