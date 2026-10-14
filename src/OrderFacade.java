public class OrderFacade {
    private final InventoryService inventory = new InventoryService();
    private final PaymentProcessor payment = new PaymentProcessor();
    private final ShippingService shipping = new ShippingService();
    private final NotificationService notification = new NotificationService();

    public String placeOrder(String product, int quantity, String customer) {
        if (customer == null || customer.isBlank()) {
            throw new IllegalArgumentException("Customer name is required.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }

        int price = inventory.getPrice(product);
        if (!inventory.reserve(product, quantity)) {
            return "Order failed: not enough stock.";
        }

        int total = price * quantity;
        if (!payment.pay(total)) {
            inventory.release(product, quantity);
            return "Order failed: payment declined. Stock was released.";
        }

        String shipment = shipping.createShipment(customer, product, quantity);
        notification.sendConfirmation(customer, shipment, total);
        return "Order placed: " + shipment;
    }
}
