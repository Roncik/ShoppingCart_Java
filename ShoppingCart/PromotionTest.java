import org.junit.*;

public class PromotionTest {
    @Test
    public void testDiscountIfTotalExceeds() {
        Promotion promocja = new Promotion();
        ShoppingCart koszyk = new ShoppingCart();
            Product produkt1 = new Product("0001", "Piłka do koszykówki", 169.99);
            Product produkt2 = new Product("0002", "Piłka do piłki nożnej", 99.99);
            Product produkt3 = new Product("0003", "Buty sportowe Nike", 239.99);
            Product produkt4 = new Product("0004", "Buty sportowe Adidas", 219.99);
            Product produkt5 = new Product("0005", "Piłki tenisowe 3szt", 9.99);
            Product produkt6 = new Product("0006", "Rower górski", 2199.99);
            Product produkt7 = new Product("0007", "Rower miejski", 999.99);
            //Dodawanie do koszyka
            koszyk.addProduct(produkt1);
            koszyk.addProduct(produkt2);
            koszyk.addProduct(produkt3);
            koszyk.addProduct(produkt4);
            koszyk.addProduct(produkt5);
            koszyk.addProduct(produkt6);
            koszyk.addProduct(produkt7);
            promocja.applyDiscountIfTotalExceeds(koszyk, 100, 10);
            Assert.assertEquals(3545.937, koszyk.calculateTotalPrice(), 0.001);
    }

    @Test
    public void testBuy3GetCheapestFree() {
        Promotion promocja = new Promotion();
        ShoppingCart koszyk = new ShoppingCart();
            Product produkt1 = new Product("0001", "Piłka do koszykówki", 169.99);
            Product produkt2 = new Product("0002", "Piłka do piłki nożnej", 99.99);
            Product produkt3 = new Product("0003", "Buty sportowe Nike", 239.99);
            //Dodawanie do koszyka
            koszyk.addProduct(produkt1);
            koszyk.addProduct(produkt2);
            koszyk.addProduct(produkt3);
            promocja.applyBuy3GetCheapestFree(koszyk);
            Assert.assertEquals(0.01, koszyk.findCheapestProduct().getDiscountPrice(), 0.001);
            Assert.assertEquals("0002", koszyk.findCheapestProduct().getCode());
    }

    @Test
    public void testFreeProductIfTotalExceeds() {
        Promotion promocja = new Promotion();
        ShoppingCart koszyk = new ShoppingCart();
            Product produkt1 = new Product("0001", "Piłka do koszykówki", 169.99);
            Product produkt2 = new Product("0002", "Piłka do piłki nożnej", 99.99);
            Product produkt3 = new Product("0003", "Buty sportowe Nike", 239.99);
            //Dodawanie do koszyka
            koszyk.addProduct(produkt1);
            koszyk.addProduct(produkt2);
            promocja.addFreeProductIfTotalExceeds(koszyk, 100, produkt3);
            for (Product produkt : koszyk.products)
            {
                if (produkt.getCode() == "0003")
                {
                    Assert.assertEquals(0.01, produkt.getDiscountPrice(), 0.001);
                }
            }
    }

    @Test
    public void testSpecificDiscount() {
        Promotion promocja = new Promotion();
        ShoppingCart koszyk = new ShoppingCart();
            Product produkt1 = new Product("0001", "Piłka do koszykówki", 169.99);
            Product produkt2 = new Product("0002", "Piłka do piłki nożnej", 99.99);
            Product produkt3 = new Product("0003", "Buty sportowe Nike", 239.99);
            //Dodawanie do koszyka
            koszyk.addProduct(produkt1);
            koszyk.addProduct(produkt2);
            koszyk.addProduct(produkt3);
            promocja.applySpecificDiscount(koszyk, "0002", 50);
            Assert.assertEquals(460, koszyk.calculateTotalPrice(), 1);
    }

}
