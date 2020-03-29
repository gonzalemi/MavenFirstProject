import org.junit.Assert;
import org.junit.Test;

public class PrendaTest {

    @Test
    public void elprecioDeVentaSeCalculaCorrectamenteSiLaPrendaEsNueva() {
        Assert.assertEquals(500, TestHelper.ProveedorPrendas.pantalonNuevo().getPrecioVenta(),0);
    }

    @Test
    public void elprecioDeVentaSeCalculaCorrectamenteSiLaPrendaEstaEnPromocion() {
        Assert.assertEquals(50, TestHelper.ProveedorPrendas.camisaPromocion50().getPrecioVenta(),0);
    }

    @Test
    public void elprecioDeVentaSeCalculaCorrectamenteSiLaPrendaEstaEnLiquidacion() {
        Assert.assertEquals(250, TestHelper.ProveedorPrendas.pantalonLiquidacion().getPrecioVenta(),0);
    }
}
