package testSuites;

import org.testng.annotations.*;

public class ejerciciosTNG {

    @BeforeSuite
    public void metodo1()
    {
        System.out.println("inicio de suite");
    }

    @AfterSuite
    public void metodo2()
    {
        System.out.println("Termino de suite");

    }

    @Test(priority = 1)
    public void metodo3()
    {
        System.out.println("test 1");
    }

    @Test(priority = 2)
    public void metodo4()
    {
        System.out.println("test 2");

    }

    @AfterMethod
    public void metodo5()
    {
        System.out.println("termino de test");

    }
}
