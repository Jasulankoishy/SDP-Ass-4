public class Main {
    public static void main(String[] args) {
        OrderFacade shop = new OrderFacade();

        System.out.println("1. Successful order");
        printOrder(shop, "Notebook", 2, "Zhasulan");

        System.out.println("\n2. Declined payment");
        printOrder(shop, "Notebook", 8, "Zhasulan");

        System.out.println("\n3. Order after rollback");
        printOrder(shop, "Notebook", 1, "Zhasulan");

        System.out.println("\n4. Not enough stock");
        printOrder(shop, "Pen", 100, "Zhasulan");

        System.out.println("\n5. Invalid quantity");
        printOrder(shop, "Pen", 0, "Zhasulan");
    }

    private static void printOrder(OrderFacade shop, String product,
                                   int quantity, String customer) {
        try {
            System.out.println(shop.placeOrder(product, quantity, customer));
        } catch (IllegalArgumentException error) {
            System.out.println("Order failed: " + error.getMessage());
        }
    }
}
