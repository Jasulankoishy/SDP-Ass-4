public class PaymentProcessor {
    private int balance = 10000;

    public boolean pay(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment must be positive.");
        }
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public int getBalance() {
        return balance;
    }
}
