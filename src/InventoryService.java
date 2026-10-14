import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();
    private final Map<String, Integer> prices = new HashMap<>();

    public InventoryService() {
        stock.put("Notebook", 10);
        stock.put("Pen", 20);
        prices.put("Notebook", 1500);
        prices.put("Pen", 300);
    }

    public int getPrice(String product) {
        if (!prices.containsKey(product)) {
            throw new IllegalArgumentException("Unknown product: " + product);
        }
        return prices.get(product);
    }

    public int getStock(String product) {
        getPrice(product);
        return stock.get(product);
    }

    public boolean reserve(String product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        int available = getStock(product);
        if (available < quantity) {
            return false;
        }
        stock.put(product, available - quantity);
        return true;
    }

    public void release(String product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        stock.put(product, getStock(product) + quantity);
    }
}
