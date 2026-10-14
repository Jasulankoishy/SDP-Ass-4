public class NotificationService {
    public void sendConfirmation(String customer, String shipment, int total) {
        if (customer == null || customer.isBlank()
                || shipment == null || shipment.isBlank() || total <= 0) {
            throw new IllegalArgumentException("Invalid confirmation details.");
        }
        System.out.println("Notification for " + customer + ": " + shipment
                + ". Total: " + total + " KZT.");
    }
}
