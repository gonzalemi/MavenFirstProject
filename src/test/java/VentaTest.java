import org.junit.Assert;
import org.junit.Test;

public class VentaTest {
    @Test
    public void elmontoDeVentaSeCalculaCorrectamenteSiElPagoEsEnEfectivo() {
        Assert.assertEquals(410, TestHelper.ProveedorVentas.ventaUnaCamisaDosSacos().monto(),0);
    }

    @Test
    public void elmontoDeVentaSeCalculaCorrectamenteSiElPagoEsConTarjeta() {
        Assert.assertEquals(880, TestHelper.ProveedorVentas.ventaDosPantalonesYUnaCamisa().monto(),0);
    }
}
