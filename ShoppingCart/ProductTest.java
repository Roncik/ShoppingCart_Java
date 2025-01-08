import org.junit.*;

public class ProductTest {
    
    @Test
    public void testGetInfo() {
        Product produkt = new Product("34245", "TestName", 7643.87);
        Assert.assertEquals("34245", produkt.getCode());
        Assert.assertEquals("TestName", produkt.getName());
        Assert.assertEquals(7643.87, produkt.getPrice(), 0.001);
        Assert.assertEquals(7643.87, produkt.getDiscountPrice(), 0.001);
        
    }

    @Test
    public void testSetDiscountPrice() {
        Product produkt = new Product("34245", "TestName", 7643.87);
        produkt.setDiscountPrice(43.99);
        Assert.assertEquals(43.99, produkt.getDiscountPrice(), 0.001);
    }

    @Test
    public void testEqualsCheck() {
        Product produkt = new Product("34245", "TestName", 7643.87);
        Product produkt2 = new Product(produkt.getCode(), produkt.getName(), produkt.getPrice());

        Assert.assertTrue(produkt.equals(produkt2));
    }
}
