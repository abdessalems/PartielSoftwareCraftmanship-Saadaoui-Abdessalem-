import java.util.*;

public class OrderSystem {
    private final Map<Integer, List<String>> orderList = new HashMap<>(); // Initialisation de la liste des commandes

    public synchronized void addNewOrder(Integer customerID, String itemName) {
        if (customerID == null || itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Customer ID and item name must not be null or empty.");
        }
        List<String> items = orderList.getOrDefault(customerID, new ArrayList<>());
        items.add(itemName);
        orderList.put(customerID, items);
    }

    public synchronized void modifyOrder(Integer customerID, Integer itemIndex, String newItemName) {
        if (customerID == null || itemIndex == null || newItemName == null || newItemName.isEmpty()) {
            throw new IllegalArgumentException("Customer ID, item index, and new item name must not be null or empty.");
        }
        List<String> items = orderList.get(customerID);
        if (items != null && itemIndex >= 0 && itemIndex < items.size()) {
            items.set(itemIndex, newItemName);
        } else {
            throw new IndexOutOfBoundsException("Invalid item index.");
        }
    }

    public synchronized void removeOrder(Integer customerID, Integer itemIndex) {
        if (customerID == null || itemIndex == null) {
            throw new IllegalArgumentException("Customer ID and item index must not be null.");
        }
        List<String> items = orderList.get(customerID);
        if (items != null && itemIndex >= 0 && itemIndex < items.size()) {
            items.remove(itemIndex);
        } else {
            throw new IndexOutOfBoundsException("Invalid item index.");
        }
    }

    public void printOrders() {
        for (Map.Entry<Integer, List<String>> entry : orderList.entrySet()) {
            System.out.println("Customer ID: " + entry.getKey());
            System.out.println("Items: " + String.join(", ", entry.getValue()));
            System.out.println();
        }
    }
}
