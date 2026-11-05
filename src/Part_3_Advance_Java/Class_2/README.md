# Java Inventory Management System

A Java-based inventory management project built milestone by milestone to practise **object-oriented programming, generics, Java Collections, and custom sorting/filtering logic**.

The project models different types of inventory items, stores them by unique ID, tracks recently viewed items, prioritizes express orders, and supports item filtering and customer wishlists.

## Learning Objectives

- Model common and specialized data using inheritance.
- Use `Comparable` and `Comparator` to define natural and custom sorting orders.
- Build reusable generic classes with bounded type parameters.
- Choose appropriate Java Collections for different use cases.
- Understand how collection behavior depends on `equals()` and `hashCode()`.

## Milestones

### Milestone 1 — Item Class Hierarchy

Create a common base class named `Item` with these attributes:

| Attribute | Type | Description |
|---|---|---|
| `id` | `String` | Unique item identifier |
| `name` | `String` | Item name |
| `price` | `double` | Item price |
| `quantity` | `int` | Available stock quantity |

Create the following subclasses:

| Class | Additional attribute |
|---|---|
| `Electronics` | `int warranty` |
| `Clothing` | `String size` |
| `Book` | `String author` |

`Item` implements `Comparable<Item>` so items can be sorted alphabetically by name. Create instances of each subclass, add them to a list, and verify the sorting behavior.

### Milestone 2 — Generic Inventory

Implement `Inventory<T extends Item>` using a `HashMap<String, T>`.

The item's ID is used as the map key. The inventory provides these operations:

| Method | Responsibility |
|---|---|
| `addItem(T item)` | Add an item to the inventory |
| `removeItem(String id)` | Remove an item using its ID |
| `getItem(String id)` | Retrieve an item using its ID |
| `getAllItems()` | Return all stored items as a `Collection<T>` |

Test adding, retrieving, and removing items. Also define and test the expected behavior when an item with an existing ID is added.

### Milestone 3 — Recently Viewed Items

Create a separate `RecentlyViewedItems` class backed by a `LinkedList<Item>`.

- Add newly viewed items at the beginning of the list using `addFirst()`.
- Keep a maximum of **10 items**.
- When the limit is exceeded, remove the oldest item from the end using `removeLast()`.
- Test the behavior by adding more than 10 items.

The list can also avoid duplicate entries by removing an item before adding it to the front again. This allows an item viewed again to become the most recently viewed item.

### Milestone 4 — Express Order Processing

Create an `Order` class containing:

| Attribute | Type | Description |
|---|---|---|
| `orderId` | `String` | Unique order identifier |
| `isExpress` | `boolean` | `true` for express orders; `false` for regular orders |

Use a `PriorityQueue<Order>` to process express orders before regular orders.

- `addOrder(Order order)` adds an order to the queue.
- `processOrder()` retrieves and removes the highest-priority order.
- Test with a mixture of express and regular orders to verify the priority rule.

### Milestone 5 — Sorting and Filtering

Add custom comparators to sort items by:

- Price.
- Quantity.

Add filtering operations to the inventory:

| Method | Responsibility |
|---|---|
| `filterByPriceRange(double minPrice, double maxPrice)` | Return items whose prices fall within the given range |
| `filterByAvailability()` | Return items with `quantity > 0` |

Test the comparators and filtering operations with different item types and values.

### Milestone 6 — Customer Wishlist

Use a `Set<Item>` to maintain a customer's wishlist without duplicate items.

- `addToWishlist(Item item)` adds an item.
- `removeFromWishlist(Item item)` removes an item.
- Test adding the same item more than once and verify that the wishlist contains only unique entries.

For duplicate detection across different object instances, make sure `Item` (or the relevant item type) implements `equals()` and `hashCode()` consistently. A common approach is to use the unique item ID for equality.

## Java Concepts and Collections Used

| Concept / Collection | Where it is used | Why it is used |
|---|---|---|
| Inheritance | `Item`, `Electronics`, `Clothing`, `Book` | Shares common fields while allowing specialized attributes |
| `Comparable<Item>` | Natural item ordering | Sorts items by name |
| Generics and bounded types | `Inventory<T extends Item>` | Restricts inventory contents to `Item` types and subclasses |
| `HashMap<String, T>` | Inventory storage | Looks up items by ID |
| `LinkedList<Item>` | Recently viewed items | Efficiently adds/removes items at either end |
| `PriorityQueue<Order>` | Order processing | Retrieves the highest-priority order first |
| `Comparator<Item>` | Custom sorting | Sorts items by price or quantity |
| `Set<Item>` | Wishlist | Stores unique items according to equality rules |

## Suggested Test Scenarios

- Sort a mixed list of books, clothing, and electronics by item name.
- Add, retrieve, and remove inventory items by ID.
- Attempt to add an item with an ID that is already present and verify the chosen duplicate-ID policy.
- Add more than 10 recently viewed items and confirm that the oldest entries are discarded.
- View an existing item again and confirm that it moves to the front if duplicate prevention is enabled.
- Add express and regular orders and confirm that express orders are processed first.
- Sort items by price and quantity, and filter by price range and stock availability.
- Add the same logical item to a wishlist more than once and confirm that it is stored only once.

## Project Status

This project is organized into six learning milestones. Update the checklist as each milestone and its tests are completed.

- [ ] Milestone 1 — Item class hierarchy
- [ ] Milestone 2 — Generic inventory
- [ ] Milestone 3 — Recently viewed items
- [ ] Milestone 4 — Express order processing
- [ ] Milestone 5 — Sorting and filtering
- [ ] Milestone 6 — Customer wishlist

## Requirements

- Java Development Kit (JDK) 21 or later.
- Any Java IDE or editor that supports the installed JDK.

