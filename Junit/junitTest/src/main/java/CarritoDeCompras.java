import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {
    private List<Producto> productos;

    public CarritoDeCompras() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public int getCantidadProductos() {
        return productos.size();
    }

    public double getTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
