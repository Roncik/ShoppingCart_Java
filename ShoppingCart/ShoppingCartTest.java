import org.junit.*;

public class ShoppingCartTest {

    @Test
    public void testAddProduct() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("P1", "Product 1", 100));
        Assert.assertEquals(1, cart.products.size());
        Product produkt = cart.products.get(0);
        Assert.assertEquals("P1", produkt.getCode());
        Assert.assertEquals("Product 1", produkt.getName());
        Assert.assertEquals(100, produkt.getPrice(), 0.001);
    }

    @Test
    public void testRemoveProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product produkt_test = new Product("P1", "Product 1", 100);
        cart.addProduct(produkt_test);
        cart.addProduct(produkt_test);
        Assert.assertEquals(2, cart.products.size());
        cart.removeProduct("P1");
        Assert.assertEquals(1, cart.products.size());
        cart.removeProduct("P1");
        Assert.assertEquals(0, cart.products.size());
    }

    @Test
    public void testCalculateTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        Product produkt_test1 = new Product("P1", "Product 1", 100);
        Product produkt_test2 = new Product("P2", "Product 2", 50);
        cart.addProduct(produkt_test1);
        cart.addProduct(produkt_test2);
        Assert.assertEquals(150, cart.calculateTotalPrice(),0.001);

    }

    @Test
    public void testFindCheapestProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product produkt_test1 = new Product("P1", "Product 1", 100);
        Product produkt_test2 = new Product("P2", "Product 2", 50);
        cart.addProduct(produkt_test1);
        cart.addProduct(produkt_test2);
        Assert.assertTrue(produkt_test2.equals(cart.findCheapestProduct()));

    }

    @Test
    public void testFindMostExpensiveProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product produkt_test1 = new Product("P1", "Product 1", 100);
        Product produkt_test2 = new Product("P2", "Product 2", 50);
        cart.addProduct(produkt_test1);
        cart.addProduct(produkt_test2);
        Assert.assertTrue(produkt_test1.equals(cart.findMostExpensiveProduct()));

    }

    
}
