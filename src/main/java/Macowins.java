import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Macowins {
    List<Venta> ventas;

    Macowins(List<Venta> ventas) {
        this.ventas = ventas;
    }

    private List<Venta> getVentas(LocalDate fecha) {
        return ventas.stream().filter(venta -> venta.enFecha(fecha)).collect(Collectors.toList());
    }

    public double liquidacion(LocalDate fecha) {
        return this.getVentas(fecha).stream().mapToDouble(Venta::monto).sum();
    }
}
