class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + " - " + productName + " - " + category + "]";
    }
}

public class Main {

    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] productList = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Footwear"),
            new Product(3, "Watch", "Accessories"),
            new Product(4, "Camera", "Electronics"),
            new Product(5, "Phone", "Electronics")
        };

        java.util.Arrays.sort(productList, java.util.Comparator.comparing(p -> p.productName.toLowerCase()));

        String searchName = "Phone";

        Product resultLinear = linearSearch(productList, searchName);
        Product resultBinary = binarySearch(productList, searchName);

        System.out.println("Linear Search Result: " + resultLinear);
        System.out.println("Binary Search Result: " + resultBinary);
    }
}
