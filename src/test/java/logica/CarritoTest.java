package logica;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarritoTest {

    private ICarrito c;

    @BeforeEach
    public void setup() {
        c = FactoryCarrito.getCarrito();
    }

    @AfterEach
    public void tearDown() {
        c.vaciar();
    }

    /* VALIDACIONES AGREGAR PRODUCTO  */
 /* TEST01 - Controla que se agregue la cantidad adecuada al carrito */
    @Test
    void testAgregarProductoControlaCantidad() {
        // inicializo datos
        int precioP = 100;
        int cantP = 10;
        Producto prod = new Producto(precioP, "producto 1");
        // logica
        c.agregarProducto(prod, cantP);
        // assert
        Assertions.assertEquals(cantP, c.obtenerCantidad(prod.getNombre()));
    }

    /* TEST02 - Agrega dos productos iguales , valida la cantidad en el carrito */
    @Test
    void testAgregarDosProductosIgualesControlaCantidad() {
        // inicializo datos
        int precioP = 100;
        int cantP = 10;
        Producto prod = new Producto(precioP, "producto 1");
        // logica
        c.agregarProducto(prod, cantP);
        c.agregarProducto(prod, 2);
        // assert
        Assertions.assertEquals(cantP + 2, c.obtenerCantidad(prod.getNombre()));
    }

    /* TEST03 - Controla que se agregue la cantidad adecuada al carrito */
    @Test
    void testAgregarProductoNullControlaCantidad() {
        // inicializo datos
        int precioP = 100;
        int cantP = 10;
        Producto prod = new Producto(precioP, null);
        // logica
        c.agregarProducto(prod, cantP);
        // assert
        Assertions.assertEquals(cantP, c.obtenerCantidad(prod.getNombre()));
    }

    /* VALIDACIONES OBTENER PRECIO TOTAL */

 /* TEST04- Controla el precio total al agregar un solo producto */
    @Test
    void testAgregarUnProductoControlPrecio() {
        // inicializo datos
        int precioP = 150;
        int cantP = 10;
        Producto prod = new Producto(precioP, "producto 1");
        // logica
        c.agregarProducto(prod, cantP);
        // assert
        Assertions.assertEquals(precioP * (cantP), c.obtenerPrecioTotal());
    }

    /* TEST05 -  Agrega dos productos distintos y valida el precio total */
    @Test
    void testAgregarDosProductosDistintosControlPrecio() {
        // inicializo datos
        int precioP1 = 110;
        int cantP1 = 10;
        int precioP2 = 120;
        int cantP2 = 2;
        Producto prod1 = new Producto(precioP1, "producto 1");
        Producto prod2 = new Producto(precioP2, "producto 2");
        // logica
        c.agregarProducto(prod1, cantP1);
        c.agregarProducto(prod2, cantP2);
        // assert
        Assertions.assertEquals((precioP1 * cantP1) + (precioP2 * cantP2), c.obtenerPrecioTotal());
    }

    /* TEST06 - Agrega dos productos iguales , controla precio total */
    @Test
    void testAgregarDosProductosIgualesControlPrecio() {
        // inicializo datos
        int precioP = 100;
        int cantP = 10;
        Producto prod = new Producto(precioP, "producto 1");
        // logica
        c.agregarProducto(prod, cantP);
        c.agregarProducto(prod, 2);
        // assert
        Assertions.assertEquals(precioP * (cantP + 2), c.obtenerPrecioTotal());
    }

}
