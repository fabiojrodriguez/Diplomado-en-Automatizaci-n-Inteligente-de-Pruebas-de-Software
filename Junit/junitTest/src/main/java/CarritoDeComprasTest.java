import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarritoDeComprasTest {

    private CarritoDeCompras carrito;
    private Producto producto;

    @BeforeEach
    public void setUp() {
        carrito = new CarritoDeCompras();
        producto = new Producto("Laptop", 1000.00);
    }

    @Test
    public void testAgregarProducto() {
        carrito.agregarProducto(producto);
        assertEquals(1, carrito.getCantidadProductos());
        assertEquals(1000.00, carrito.getTotal(), 0.01);
    }
}
