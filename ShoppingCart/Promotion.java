public class Promotion{
    /*public void applyDiscountIfTotalExceeds(ShoppingCart cart, double threshold, double discountPercentage) {
        double total = cart.calculateTotalPrice(); //suma wartosci koszyka
        if (total > threshold)
        {
            for (Product product : cart.products)
            {
                double discountedPrice = product.getPrice() * (1 - discountPercentage / 100);
                product.setDiscountPrice(discountedPrice);
            }
        }
    }*/

    public void applyDiscountIfTotalExceeds(ShoppingCart cart, double threshold, double discountPercentage) { 
        cart.Value_multiplier = (1 - discountPercentage/100)*cart.Value_multiplier; //Robie tak dlatego, zeby kolejnosc aplikowania promocji nie miala wplywu na wynik koncowy
    }

    public void applyBuy3GetCheapestFree(ShoppingCart cart) 
    {
        if (cart.products.size() >= 3) //wieksze lub rowne 3?
        {
            Product cheapest = cart.findCheapestProduct();
            if (cheapest != null)
            {
                cheapest.setDiscountPrice(0.01);
            }
        }
    }

    public void addFreeProductIfTotalExceeds(ShoppingCart cart, double threshold, Product freeProduct)
    {
        double total = cart.calculateTotalPrice();
        if (total > threshold)
        {
            Product product_with_price_0 = new Product(freeProduct.getCode(), freeProduct.getName(), freeProduct.getPrice());
            product_with_price_0.setDiscountPrice(0.01);
            cart.addProduct(product_with_price_0, product_with_price_0.getDiscountPrice());
        }
    }

    public void applySpecificDiscount(ShoppingCart cart, String productCode, double discountPercentage) {
        for (Product product : cart.products) {
            if (product.getCode().equals(productCode)) {
                double discountedPrice = product.getPrice() * (1 - discountPercentage / 100);
                product.setDiscountPrice(discountedPrice);
            }
        }
    }
}