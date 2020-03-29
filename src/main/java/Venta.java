import java.time.LocalDate;
import java.util.List;

public class Venta {
    List<Prenda> prendas;
    LocalDate fecha;
    ITipoPago tipoPago = new Efectivo();

    public Venta(LocalDate fecha, List<Prenda> prendas) {
        this.fecha = fecha;
        this.prendas = prendas;
    }

    public Venta(LocalDate fecha, List<Prenda> prendas, ITipoPago tipoPago) {
        this.fecha = fecha;
        this.prendas = prendas;
        this.tipoPago = tipoPago;
    }

    private double montoUnitario(Prenda prenda) {
        return prenda.getPrecioVenta() + tipoPago.recargo(prenda.getPrecioVenta());
    }

    double monto() {
        return prendas.stream().mapToDouble(this::montoUnitario).sum();
    }

    public boolean enFecha(LocalDate fecha) {
        return this.fecha.equals(fecha);
    }
}

interface ITipoPago {
    double recargo(double precioVenta);
}

class Efectivo implements ITipoPago {
    public double recargo(double precioVenta) {
        return 0;
    }
}

class TarjetaCredito implements ITipoPago {
    int cantCuotas;
    int coeficienteRecargo;

    public TarjetaCredito(int cantCuotas, int coeficienteRecargo){
        this.cantCuotas = cantCuotas;
        this.coeficienteRecargo = coeficienteRecargo;
    }

    public double recargo(double precioVenta) {
        return cantCuotas * coeficienteRecargo + (0.01 * precioVenta);
    }
}