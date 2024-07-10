public class OrderProcessor {
    private Database database;
    private EmailService emailService;
    private InventorySystem inventorySystem;

    public OrderProcessor(Database database, EmailService emailService, InventorySystem inventorySystem) {
        this.database = database;
        this.emailService = emailService;
        this.inventorySystem = inventorySystem;
    }

    public void processOrder(Order order) {
        validateOrder(order);
        database.saveOrder(order);
        sendConfirmationEmail(order);
        updateInventory(order);
        applyLoyaltyDiscount(order);
    }

    private void validateOrder(Order order) {
        for (Item item : order.getItems()) {
            if (!inventorySystem.isItemAvailable(item)) {
                throw new RuntimeException("Item not available in inventory");
            }
        }
    }

    private void sendConfirmationEmail(Order order) {
        String message = "Your order has been received and is being processed.";
        emailService.sendEmail(order.getCustomerEmail(), "Order Confirmation", message);
    }

    private void updateInventory(Order order) {
        for (Item item : order.getItems()) {
            inventorySystem.updateInventory(item, item.getQuantity() * -1);
        }
    }

    private void applyLoyaltyDiscount(Order order) {
        if (order instanceof LoyalCustomerOrder) {
            ((LoyalCustomerOrder) order).applyDiscount();
        }
    }
}
