
public class Prenda {
    private String tipo;
    IEstado estado = new Nueva();
    private double precioVenta;

    public Prenda(String tipo, double precioVenta) {
        this.tipo = tipo;
        this.precioVenta = precioVenta;
    }

    public Prenda(String tipo, int precioVenta, IEstado estado) {
        this.tipo = tipo;
        this.precioVenta = precioVenta;
        this.estado = estado;
    }

    public double getPrecioVenta() {
        return this.precioVenta - estado.descuento(precioVenta);
    }

    public String getTipo() {
        return tipo;
    }


}

interface IEstado {
    double descuento(double precioBase);
}

class Nueva implements IEstado {

    @Override
    public double descuento(double precioBase) {
        return 0;
    }
}

class Promocion implements IEstado {

    double valorFijo;

    Promocion(double valorFijo) {
        this.valorFijo = valorFijo;
    }

    @Override
    public double descuento(double precioBase) {
        return valorFijo;
    }
}

class Liquidacion implements IEstado {

    @Override
    public double descuento(double precioBase) {
        return precioBase * 0.5;
    }
}
