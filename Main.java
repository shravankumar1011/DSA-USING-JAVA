
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {

    private int productId;
    private String productName;
    private int productPrice;
    private String productDescription;
    private int productQuantity;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}

public class Main {

    public static List<Product> listOfProducts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. Update product");
            System.out.println("4. Search product");
            System.out.println("5. List products");
            System.out.println("6. Buy product");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Product name: ");
                    String name = scanner.nextLine();
                    System.out.println("Product price: ");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Product description: ");
                    String description = scanner.nextLine();
                    System.out.println("Product quantity: ");
                    int quantity = scanner.nextInt();
                    add(name, price, description, quantity);
                    break;
                case 2:
                    System.out.println("Enter product index to remove: ");
                    int index = scanner.nextInt();
                    removeProduct(index);
                    break;
                case 3:
                    System.out.println("Enter product name to update: ");
                    String updateName = scanner.nextLine();
                    updateProduct(updateName, scanner);
                    break;
                case 4:
                    System.out.println("Enter product name to search: ");
                    String searchName = scanner.nextLine();
                    searchProduct(searchName);
                    break;
                case 5:
                    printList();
                    break;
                case 6:
                    System.out.println("Enter product name to buy: ");
                    String buyName = scanner.nextLine();
                    System.out.println("Enter quantity to buy: ");
                    int buyQuantity = scanner.nextInt();
                    buyProduct(buyName, buyQuantity);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void printList() {
        for (Product product : listOfProducts) {
            System.out.println("ID: " + product.getProductId());
            System.out.println("Name: " + product.getProductName());
            System.out.println("Price: " + product.getProductPrice());
            System.out.println("Description: " + product.getProductDescription());
            System.out.println("Quantity: " + product.getProductQuantity());
            System.out.println("--------------------------");
        }
    }

    public static void add(String name, int price, String description, int quantity) {
        Product product = new Product();
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductDescription(description);
        product.setProductQuantity(quantity);
        product.setProductId(listOfProducts.size() + 1);
        listOfProducts.add(product);
        System.out.println("Product added");
    }

    public static void removeProduct(int index) {
        if (index >= 1 && index <= listOfProducts.size()) {
            listOfProducts.remove(index - 1);
            System.out.println("Product removed");
        } else {
            System.out.println("Invalid product index!");
        }
    }

    public static void updateProduct(String name, Scanner scanner) {
        for (Product product : listOfProducts) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                System.out.println("Enter new price: ");
                int newPrice = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter new description: ");
                String newDescription = scanner.nextLine();
                System.out.println("Enter new quantity: ");
                int newQuantity = scanner.nextInt();

                product.setProductPrice(newPrice);
                product.setProductDescription(newDescription);
                product.setProductQuantity(newQuantity);
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public static void buyProduct(String name, int quantity) {
        for (Product product : listOfProducts) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                if (product.getProductQuantity() >= quantity) {
                    product.setProductQuantity(product.getProductQuantity() - quantity);
                    System.out.println("Purchase successful! Remaining quantity: " + product.getProductQuantity());
                } else {
                    System.out.println("Not enough stock available!");
                }
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public static void searchProduct(String name) {
        boolean found = false;
        for (Product product : listOfProducts) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                System.out.println("Product found: ");
                System.out.println("ID: " + product.getProductId());
                System.out.println("Name: " + product.getProductName());
                System.out.println("Price: " + product.getProductPrice());
                System.out.println("Description: " + product.getProductDescription());
                System.out.println("Quantity: " + product.getProductQuantity());
                System.out.println("--------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Product not found!");
        }
    }
}
