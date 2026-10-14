# Assignment 4 - Facade Pattern

This Java console project uses Option B: online order processing.
`Main` calls `OrderFacade.placeOrder(product, quantity, customer)`.
The facade reserves stock, processes payment, creates a shipment label,
and sends a confirmation to the console. If payment is declined,
the reserved stock is released.

## Structure

```text
src/
  Main.java
  OrderFacade.java
  InventoryService.java
  PaymentProcessor.java
  ShippingService.java
  NotificationService.java
```

## Run

Install JDK 17 or newer. Run these commands from the repository folder:

```sh
javac --release 17 -d out src/*.java
java -cp out Main
```

In IntelliJ IDEA, select a JDK, mark `src` as Sources Root, and run `Main`.
No extra libraries are needed.

## Demo

The demo shows a successful order, a declined payment, another order after
rollback, insufficient stock, and invalid quantity.

Initial stock: 10 notebooks and 20 pens. Prices are 1500 KZT and 300 KZT.
The payment processor has one simulated balance of 10000 KZT, shared by
the demo orders. Money is stored as whole tenge.

The first order costs 3000 KZT. The next order costs 12000 KZT, so it is
declined and its eight notebooks are returned to stock. The following order
then succeeds. Failed orders do not create shipment labels or confirmations.

## Facade

The client only uses the facade. All four subsystem classes are public and
can also be used directly. They do not know about `OrderFacade`.

Payments, shipments, and notifications are local simulations. There is no
database, actual bank payment, delivery integration, or order cancellation.
Rollback covers declined payment after stock reservation.

Repository: https://github.com/Jasulankoishy/SDP-Ass-4
