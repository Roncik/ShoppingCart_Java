public class cartmain
{
        public static void main(String[] args)
        {
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
            System.out.println("Wartość koszyka: " + koszyk.calculateTotalPrice());

            //Odejmowanie z koszyka
            koszyk.removeProduct("0002");
            System.out.println("Wartość koszyka: " + koszyk.calculateTotalPrice());

            //inicjalizacja promocji
            Promotion promocja = new Promotion();

            

            //Promocja jezeli wartosc koszyka przekracza
            System.out.println("\n");
            System.out.println("Promocja jezeli wartosc koszyka przekracza");
            promocja.applyDiscountIfTotalExceeds(koszyk, 3800, 10);
            System.out.println("Wartość koszyka: " + koszyk.calculateTotalPrice());

            //Darmowy produkt jezeli wartosc koszyka przekracza
            System.out.println("\n");
            System.out.println("Darmowy produkt jezeli wartosc koszyka przekracza");
            Product produkt8 = new Product("0008", "Ręcznik z logiem sklepu", 25.99);
            promocja.addFreeProductIfTotalExceeds(koszyk, 0, produkt8);
            System.out.println("Wartość koszyka: " + koszyk.calculateTotalPrice());

            //Promocja na dany produkt
            System.out.println("\n");
            System.out.println("Promocja na dany produkt");
            promocja.applySpecificDiscount(koszyk, "0007", 50);
            System.out.println("Wartość koszyka: " + koszyk.calculateTotalPrice());

            //Najtanszy za darmo przy zakupie trzech lub wiecej
            System.out.println("\n");
            System.out.println("Najtanszy za darmo przy zakupie trzech lub wiecej");
            promocja.applyBuy3GetCheapestFree(koszyk);
            System.out.println("Wartość koszyka: " + koszyk.calculateTotalPrice());

            //Wyszukiwanie najtanszego i najdrozszego produktu
            System.out.println("\n");
            System.out.println("Wyszukiwanie najtanszego i najdrozszego produktu");
            System.out.println(koszyk.findCheapestProduct().ProductToString());
            System.out.println(koszyk.findMostExpensiveProduct().ProductToString());

            //Wyszukiwanie n najtanszych produktow
            System.out.println("\n");
            System.out.println("Wyszukiwanie n najtanszych produktow");
            for (Product produkt : koszyk.findNCheapestProducts(2))
            {
                System.out.println(produkt.ProductToString());
            }
            //Wyszukiwanie n najdrozszych produktow
            System.out.println("Wyszukiwanie n najdrozszych produktow");
            for (Product produkt : koszyk.findNMostExpensiveProducts(2))
            {
                System.out.println(produkt.ProductToString());
            }

            //Sortowanie produktow po nazwie
            System.out.println("\n");
            System.out.println("Sortowanie produktow po nazwie");
            koszyk.printProducts();
            System.out.println("");
            koszyk.sortProductsByName();
            koszyk.printProducts();

            
        }

}
