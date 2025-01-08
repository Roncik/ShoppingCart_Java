import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    public List<Product> products; //Koszyk jako lista
    public Double Value_multiplier = 1.0; //Zamiast aplikowac promocje ogolne na kazdy produkt osobno aplikujemy je do mnoznika wartosci calego koszyka

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        Product product_copy = new Product(product.getCode(), product.getName(), product.getPrice()); //tworze kopie produktu zeby oryginalny nadal mogl zostac uzyty w innym koszyku
        products.add(product_copy); //dodaje kopie produktu do listy
        sortProducts(); //sortuj produkty
    }

    public void addProduct(Product product, Double discountprice) {
        Product product_copy = new Product(product.getCode(), product.getName(), product.getPrice(), discountprice); //tworze kopie produktu zeby oryginalny nadal mogl zostac uzyty w innym koszyku
        products.add(product_copy); //dodaje kopie produktu do listy
        sortProducts(); //sortuj produkty
    }

    public void removeProduct(String productCode) {
        for (Product product : products) {
            if (product.getCode().equals(productCode)) { //szukam wskazanego produktu po kodzie w koszyku
                products.remove(product); //usuwam znaleziony produkt
                sortProducts(); //sortuj produkty
                return; //usuwam tylko jeden na raz
            }
        }
    }

    public double calculateTotalPrice() {
        return products.stream().mapToDouble(Product::getDiscountPrice).sum() * Value_multiplier;
    }

    public Product findCheapestProduct() {
        return products.stream().min(Comparator.comparingDouble(Product::getPrice)).orElse(null);
    }

    public Product findMostExpensiveProduct() {
        return products.stream().max(Comparator.comparingDouble(Product::getPrice)).orElse(null);
    }

    public List<Product> findNCheapestProducts(int n) {
        return products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Product> findNMostExpensiveProducts(int n) {
        return products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice)
                .reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public void sortProducts() {
        products.sort(Comparator.comparingDouble(Product::getPrice)
                .reversed()
                .thenComparing(Product::getName));
    }

    public void sortProductsByPrice() {
        products.sort(Comparator.comparingDouble(Product::getPrice)
                .reversed());
    }

    public void sortProductsByName() {
        products.sort(Comparator.comparing(Product::getName));
    }

    public void printProducts() {
        for (Product produkt : products)
        {
            System.out.println(produkt.ProductToString());
        }
    }
}


