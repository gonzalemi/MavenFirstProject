import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MacowinsTest {
    private Macowins macowins;

    @Before
    public void init() {
        macowins = new Macowins(new ArrayList<Venta>());
    }


    @Test
    public void liquidacionSinVentas() {
        Assert.assertEquals(0, macowins.liquidacion(LocalDate.of(2019, 01, 01)), 0);
    }

    @Test
    public void liquidacionConVentas() {
        macowins.ventas.add(TestHelper.ProveedorVentas.ventaDosPantalonesYUnaCamisa());
        macowins.ventas.add(TestHelper.ProveedorVentas.ventaDosPantalonesYUnaCamisa());
        macowins.ventas.add(TestHelper.ProveedorVentas.ventaUnaCamisaDosSacos());

        Assert.assertEquals(1760, macowins.liquidacion(LocalDate.of(2020, 03, 24)), 0);
    }

    @Test
    public void realizarUnaVenta() {
        List<Prenda> prendas = new ArrayList<Prenda>();
        prendas.add(TestHelper.ProveedorPrendas.camisaPromocion50());
        prendas.add(TestHelper.ProveedorPrendas.sacoPromocion20());
        macowins.realizarVenta(prendas, new TarjetaCredito(12,2));

        Assert.assertEquals(1, macowins.getVentas(LocalDate.now()).size());
    }
}
