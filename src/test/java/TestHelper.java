import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public static class ProveedorPrendas {

        private static IEstado promocion20 = new Promocion(20);
        private static IEstado promocion50 = new Promocion(50);
        private static IEstado liquidacion = new Liquidacion();

        public static Prenda pantalonNuevo() {
            return new Prenda("pantalon", 500);
        }

        public static Prenda pantalonLiquidacion() {
            return new Prenda("pantalon", 500, liquidacion);
        }

        public static Prenda sacoPromocion20() {
            return new Prenda("saco", 200, promocion20);
        }

        public static Prenda camisaPromocion50() {
            return new Prenda("camisa", 100, promocion50);
        }
    }

    public static class ProveedorVentas {
        private static ITipoPago tarjetaDoceCuotas = new TarjetaCredito(12,2);
        private static ITipoPago tarjetaSeisCuotas = new TarjetaCredito(6,3);

        public static Venta ventaDosPantalonesYUnaCamisa() {
            List<Prenda> prendas = new ArrayList<Prenda>();
            prendas.add(ProveedorPrendas.camisaPromocion50());
            prendas.add(ProveedorPrendas.pantalonLiquidacion());
            prendas.add(ProveedorPrendas.pantalonNuevo());

            return new Venta(LocalDate.of(2020, 3, 24), prendas, tarjetaDoceCuotas);
        }

        public static Venta ventaUnaCamisaDosSacos() {
            List<Prenda> prendas = new ArrayList<Prenda>();
            prendas.add(ProveedorPrendas.sacoPromocion20());
            prendas.add(ProveedorPrendas.sacoPromocion20());
            prendas.add(ProveedorPrendas.camisaPromocion50());

            return new Venta(LocalDate.of(2020, 3, 22), prendas);
        }
    }
}
