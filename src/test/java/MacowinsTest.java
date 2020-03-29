import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;

public class MacowinsTest {
    private Macowins macowins;

    @Test
    public void liquidacionSinVentas() {
        Macowins macowins = new Macowins(new ArrayList<Venta>());

        Assert.assertEquals(0, macowins.liquidacion(LocalDate.of(2019,01,01)),0);
    }

    @Test
    public void liquidacionConVentas() {
        Macowins macowins = new Macowins(new ArrayList<Venta>());
        macowins.ventas.add(TestHelper.ProveedorVentas.ventaDosPantalonesYUnaCamisa());
        macowins.ventas.add(TestHelper.ProveedorVentas.ventaDosPantalonesYUnaCamisa());
        macowins.ventas.add(TestHelper.ProveedorVentas.ventaUnaCamisaDosSacos());

        Assert.assertEquals(1760, macowins.liquidacion(LocalDate.of(2020,03,24)),0);
    }
}
