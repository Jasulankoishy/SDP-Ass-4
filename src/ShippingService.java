public class ShippingService {
    private int nextShipment = 1;

    public String createShipment(String customer, String product, int quantity) {
        if (customer == null || customer.isBlank()
                || product == null || product.isBlank() || quantity <= 0) {
            throw new IllegalArgumentException("Invalid shipment details.");
        }
        String trackingNumber = "SHIP-" + nextShipment++;
        return trackingNumber + ": " + quantity + " x " + product + " for " + customer;
    }
}
