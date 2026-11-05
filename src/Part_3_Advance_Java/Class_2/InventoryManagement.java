package Part_3_Advance_Java.Class_2;

import Part_3_Advance_Java.Class_2.Milestone1.Book;
import Part_3_Advance_Java.Class_2.Milestone1.Clothing;
import Part_3_Advance_Java.Class_2.Milestone1.Electronics;
import Part_3_Advance_Java.Class_2.Milestone1.Item;
import Part_3_Advance_Java.Class_2.Milestone2.Inventory;
import Part_3_Advance_Java.Class_2.Milestone3.RecentlyViewedItems;
import Part_3_Advance_Java.Class_2.Milestone4.Order;
import Part_3_Advance_Java.Class_2.Milestone4.OrderQueue;
import Part_3_Advance_Java.Class_2.Milestone5.ItemPriceComparator;
import Part_3_Advance_Java.Class_2.Milestone5.ItemQuantityComparator;
import Part_3_Advance_Java.Class_2.Milestone6.Wishlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class InventoryManagement {
    public static void main(String[] args) {
        // ── Milestone 1: Item Hierarchy + Comparable ──
        System.out.println("=== M1: Comparable (natural order by name) ===");
        List<Item> items = new ArrayList<>();

    // Electronics
        Electronics e1 = new Electronics("1", "Laptop", 75000, 10, 2);
        Electronics e2 = new Electronics("2", "Headphones", 2500, 20, 1);
        Electronics e3 = new Electronics("3", "iPhone 18", 179_000, 2, 2);

    // Clothing
        Clothing c1 = new Clothing("4", "T-Shirt", 799, 50, "M");
        Clothing c2 = new Clothing("5", "Jeans", 1999, 30, "L");
        Clothing c3 = new Clothing("6", "Supreme BoGo", 7_500, 10, "S");

    // Books
        Book b1 = new Book("7", "Clean Code", 599, 15, "Robert C. Martin");
        Book b2 = new Book("8", "Atomic Habits", 450, 25, "James Clear");
        Book b3 = new Book("9", "DDIA", 1_500, 100, "Kleppmann");

    // Adding items to the list
        items.add(e1);
        items.add(e2);
        items.add(e3);

        items.add(c1);
        items.add(c2);
        items.add(c3);

        items.add(b1);
        items.add(b2);
        items.add(b3);


        Collections.sort(items);
        System.out.println("Sorted by name: " + items);

        // ── Milestone 2: Generic Inventory ──
        System.out.println("\n=== M2: Inventory<Item> (HashMap) ===");

        Inventory<Item> itemInventory = new Inventory<>();
        itemInventory.addItem(e1);
        itemInventory.addItem(c1);
        itemInventory.addItem(b1);

//        itemInventory.addItem(b1); // exception

        System.out.println("Get id=1: " + itemInventory.getItem("1"));
        System.out.println("Get id=4: " + itemInventory.getItem("4"));
        System.out.println("Get id=7: " + itemInventory.getItem("7"));
        System.out.println("All items: " + itemInventory.getAllItems());

        itemInventory.removeItem("4");
        System.out.println("After removing id=4: " + itemInventory.getAllItems());

        // ── Milestone 3: Recently Viewed Items ──
        System.out.println("\n=== M3: RecentlyViewedItems (LinkedList, max 10) ===");

        RecentlyViewedItems recents = new RecentlyViewedItems();

        for (int i = 1; i <= 10; i++) {
            recents.addRecentlyViewedItem(new Item("A-" + i, "Test Item " + i, 10, 10));
        }

        System.out.println("After adding 10: size=" + recents.getRecents().size());

        recents.addRecentlyViewedItem(new Item("A-11", "Test Item 11", 10, 10));
        System.out.println("After adding 11th: size=" + recents.getRecents().size());
        System.out.println("First (most recent): " + recents.getRecents().get(0));
        System.out.println("Last (oldest):       " + recents.getRecents().get(recents.getRecents().size() - 1));

        // ── Milestone 4: Order Queue (express first) ──
        System.out.println("\n=== M4: OrderQueue (express orders first) ===");

        OrderQueue orderQueue = new OrderQueue();
        orderQueue.addOrder(new Order("123", true));
        orderQueue.addOrder(new Order("456", false));
        orderQueue.addOrder(new Order("789", true));
        orderQueue.addOrder(new Order("000", false));

        System.out.println("  " + orderQueue.processOrder());
        System.out.println("  " + orderQueue.processOrder());
        System.out.println("  " + orderQueue.processOrder());
        System.out.println("  " + orderQueue.processOrder());

        // ── Comparator: Sort by price ──
        System.out.println("\n=== Comparator (sort by price ASC) ===");

        List<Item> items2 = new ArrayList<>();
        items2.add(e1);
        items2.add(c1);
        items2.add(b1);

        Collections.sort(items2, new ItemPriceComparator());
        System.out.println("Sorted by price: " + items2);

        // PriorityQueue with Comparator
        System.out.println("\n=== PriorityQueue (price order) ===");

        PriorityQueue<Item> priorityQueue = new PriorityQueue<>(new ItemPriceComparator());
        // Electronics
        Electronics e4 = new Electronics("E104", "Smartwatch", 12999, 15, 2);

    // Clothing
        Clothing c4 = new Clothing("C104", "Hoodie", 2499, 25, "XL");

    // Book
        Book b4 = new Book("B104", "The Pragmatic Programmer", 899, 20, "Andrew Hunt");

        priorityQueue.add(e4);
        priorityQueue.add(c4);
        priorityQueue.add(b4);

        while (!priorityQueue.isEmpty()) {
            System.out.println("  poll: " + priorityQueue.poll());
        }


        // ── Setup items ──
        Electronics ee1 = new Electronics("1", "iPhone 18", 179_000, 2, 2);
        Clothing cc1 = new Clothing("2", "Supreme BoGo", 7_500, 10, "S");
        Book bb1 = new Book("3", "DDIA", 1_500, 100, "Klepmann");
        Item outOfStock = new Item("4", "Vintage Poster", 3_000, 0);

        Inventory<Item> inventory = new Inventory<>();
        inventory.addItem(e1);
        inventory.addItem(c1);
        inventory.addItem(b1);
//        inventory.addItem(outOfStock);

        // ── M5: Custom Comparators ──
        System.out.println("=== M5: Sort by price (Comparator) ===");
        List<Item> byPrice = new ArrayList<>(inventory.getAllItems());
        Collections.sort(byPrice, new ItemPriceComparator());
        for (Item item : byPrice) {
            System.out.println("  " + item);
        }

        System.out.println("\n=== M5: Sort by quantity (Comparator) ===");
        List<Item> byQty = new ArrayList<>(inventory.getAllItems());
        Collections.sort(byQty, new ItemQuantityComparator());
        for (Item item : byQty) {
            System.out.println("  " + item);
        }

        // ── M5: Filtering ──
        System.out.println("\n=== M5: Filter by price range [1000, 10000] ===");
        List<Item> inRange = inventory.filterByPriceRange(1_000, 10_000);
        for (Item item : inRange) {
            System.out.println("  " + item);
        }

        System.out.println("\n=== M5: Filter by availability (quantity > 0) ===");
        List<Item> available = inventory.filterByAvailability();
        System.out.println("  Available: " + available.size() + " / " + 4);
        for (Item item : available) {
            System.out.println("  " + item);
        }

        // ── M6: Wishlist (Set-based uniqueness) ──
        System.out.println("\n=== M6: Wishlist (Set) ===");
        Wishlist wishlist = new Wishlist();

        System.out.println("Add iPhone 18:    " + wishlist.addToWishlist(e1));
        System.out.println("Add DDIA:         " + wishlist.addToWishlist(b1));
        System.out.println("Add iPhone again: " + wishlist.addToWishlist(new Item("1", "iPhone 18", 179_000, 2)));
        System.out.println("Size (should be 2): " + wishlist.size());
        System.out.println(wishlist);

        System.out.println("Remove DDIA:      " + wishlist.removeFromWishlist(b1));
        System.out.println("Size (should be 1): " + wishlist.size());
        System.out.println(wishlist);
    }
}