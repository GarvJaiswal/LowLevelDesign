# Library Management System

A Java-based Library Management System project focused on practicing object-oriented programming, interfaces, inheritance, polymorphism, constructors, encapsulation, static/final members, and Java Collections.

The system models library users and books, maintains a book catalog, supports book searches, and demonstrates the borrowing and return workflow.

> **Project status:** This README describes the planned milestones. Keep the progress checkboxes updated as each feature is implemented and tested.

## Table of Contents

- [Project Objectives](#project-objectives)
- [Core Requirements](#core-requirements)
- [OOP and Java Concepts](#oop-and-java-concepts)
- [Domain Model](#domain-model)
- [Milestone A — User Management](#milestone-a--user-management)
- [Milestone B — Lending Books](#milestone-b--lending-books)
- [Milestone C — Library Management System](#milestone-c--library-management-system)
- [Suggested Project Structure](#suggested-project-structure)
- [Getting Started](#getting-started)
- [Testing Checklist](#testing-checklist)
- [Future Enhancements](#future-enhancements)

## Project Objectives

Build a small library management application that demonstrates how Java's object-oriented features and collection types can be combined to model a real-world system.

The application should support:

- Different library item types, including books, magazines, and journals.
- Different user types, including members and librarians.
- Catalog operations performed by librarians.
- Borrowing and returning of lendable items by eligible members.
- A borrowing limit for members.
- Tracking of registered users and their unique IDs.
- Searching for books by title, author, and book type.

## Core Requirements

### Library items

The overall product requirements describe three kinds of library items:

| Item type | Description |
| --- | --- |
| Book | Can be lent to eligible members. Includes textbooks and novels. |
| Magazine | A library item; lending rules can depend on library policy. |
| Journal | A library item; lending rules can depend on library policy. |

Some items may be available for borrowing, while others may be restricted to in-library reading. The `Lendable` interface provides a common contract for items that can be borrowed.

### Users

| User type | Responsibilities |
| --- | --- |
| Member | Borrows and returns lendable items, subject to the borrowing limit. |
| Librarian | Manages the library catalog by adding and removing items. |

Every user has a unique ID. The system also tracks the total number of users created.

### Books

The broader requirements describe Fiction, Non-Fiction, and Academic categories. The implementation milestones begin with two concrete book types:

- `TextBook` — has a subject and edition.
- `NovelBook` — has a genre.

## OOP and Java Concepts

This project provides practice with:

- **Encapsulation:** Keep fields private and expose controlled access through methods.
- **Abstraction:** Use abstract `User` and `Book` classes to define shared contracts.
- **Inheritance:** Derive `Member` and `Librarian` from `User`, and concrete book types from `Book`.
- **Polymorphism:** Call overridden methods through parent-class or interface references.
- **Interfaces:** Use `Lendable` to represent the borrowing contract.
- **Constructor overloading:** Implement default, parameterized, and copy constructors where required.
- **`static`:** Maintain shared user-count state and generate IDs at class level.
- **`final`:** Define constants such as the member borrowing limit.
- **Method overloading:** Provide multiple `searchBooks` methods with different parameters.
- **Collections:** Use `List` / `ArrayList` to manage books and registered users.

## Domain Model

The main classes and interface are:

```text
                    User (abstract)
                    /             \
                Member          Librarian

                 Book (abstract, implements Lendable)
                    /                         \
                TextBook                    NovelBook

                LibraryManagementSystem
                - List<User> registeredUsers
                - List<Book> bookInventory
```

### Main responsibilities

| Class / Interface | Responsibility |
| --- | --- |
| `User` | Shared user fields, constructors, unique ID generation, total-user counter, and abstract user operations. |
| `Member` | Tracks borrowed-book count and enforces the borrowing limit. |
| `Librarian` | Represents a librarian and exposes catalog-management operations. |
| `Lendable` | Defines `lend`, `returnItem`, and `isAvailable` operations. |
| `Book` | Shared book information and lending behavior. |
| `TextBook` | Adds subject and edition information and displays textbook details. |
| `NovelBook` | Adds genre information and displays novel details. |
| `LibraryManagementSystem` | Coordinates users, books, searching, lending, returns, and display operations. |

## Milestone A — User Management

**Goal:** Practice abstract classes, encapsulation, inheritance, constructors, polymorphism, `static`, and `final`.

### Task 1: Create the base `User` class

- [ ] Create an abstract `User` class.
- [ ] Add private fields: `userId`, `name`, and `contactInfo`.
- [ ] Provide getters and setters for `name` and `contactInfo`.
- [ ] Keep the fields private and expose access through methods.

### Task 2: Add constructors

- [ ] Add a default constructor that initializes `userId` using `generateUniqueId()`.
- [ ] Add a parameterized constructor that initializes `name` and `contactInfo`.
- [ ] Add a copy constructor that copies the relevant fields from another `User` while assigning the new instance its own ID.
- [ ] Test all constructor paths.

### Task 3: Make `User` abstract

Declare the following abstract methods:

```java
public abstract void displayDashboard();
public abstract boolean canBorrowBooks();
```

- [ ] Implement the abstract class and methods.
- [ ] Demonstrate polymorphism using `User` references to `Member` and `Librarian` objects.

### Task 4: Create `Member`

- [ ] Extend `User` with a concrete `Member` class.
- [ ] Add private `borrowedBooksCount`.
- [ ] Define `MAX_BORROW_LIMIT = 5` as a constant.
- [ ] Override `displayDashboard()` to display the member dashboard and current borrowed-book count.
- [ ] Override `canBorrowBooks()` to return `true` only while the member is below the borrowing limit.
- [ ] Add constructors and methods to increment and decrement the borrowed-book count.

### Task 5: Create `Librarian`

- [ ] Extend `User` with a concrete `Librarian` class.
- [ ] Add private `employeeNumber`.
- [ ] Override `displayDashboard()` to display the librarian dashboard and employee number.
- [ ] Override `canBorrowBooks()` according to the milestone requirement (always returns `true`).
- [ ] Add `addNewBook(Book book)` and `removeBook(Book book)` methods. Their catalog logic may initially be left as TODO comments and later delegated to `LibraryManagementSystem`.

### Task 6: Demonstrate `static` and `final`

- [ ] Add a static `totalUsers` counter and `getTotalUsers()` method.
- [ ] Add a static `generateUniqueId()` method.
- [ ] Ensure every constructor path increments the user count exactly once.
- [ ] Verify that copied users receive a new unique ID rather than reusing the source user's ID.
- [ ] Use `final` for constants such as `MAX_BORROW_LIMIT`.

**Learning resources:**

- [Java `static` keyword — Scaler](https://www.scaler.com/topics/static-keyword-in-java/)
- [Java `final` keyword — Scaler](https://www.scaler.com/topics/java/final-keyword-in-java/)

## Milestone B — Lending Books

**Goal:** Introduce interfaces, abstract classes, constructor overloading, and inheritance for lendable books.

### Task 1: Create the `Lendable` interface

- [ ] Define the interface with these methods:

```java
boolean lend(User user);
void returnItem(User user);
boolean isAvailable();
```

- [ ] Create a small test implementation to demonstrate borrowing through a `Lendable` reference.

### Task 2: Implement the abstract `Book` class

- [ ] Create an abstract `Book` class that implements `Lendable`.
- [ ] Add private fields: `isbn`, `title`, `author`, and `isAvailable`.
- [ ] Implement `lend(User user)` so a book is lent only when it is available and the user is eligible to borrow.
- [ ] Implement `returnItem(User user)` and `isAvailable()`.
- [ ] Declare the abstract method `displayBookDetails()`.

### Task 3: Add `Book` constructors

- [ ] Add a default constructor that initializes availability to `true`.
- [ ] Add a parameterized constructor for `isbn`, `title`, and `author`.
- [ ] Add a copy constructor and test the copied book's fields and availability behavior.

### Task 4: Create `TextBook`

- [ ] Extend `Book` with `TextBook`.
- [ ] Add `subject` and `edition` fields.
- [ ] Add a parameterized constructor that initializes inherited and subclass fields.
- [ ] Override `displayBookDetails()`.
- [ ] Create and test a `TextBook` instance.

### Task 5: Create `NovelBook`

- [ ] Extend `Book` with `NovelBook`.
- [ ] Add a `genre` field.
- [ ] Add a parameterized constructor that initializes inherited and subclass fields.
- [ ] Override `displayBookDetails()`.
- [ ] Create and test a `NovelBook` instance.

## Milestone C — Library Management System

**Goal:** Integrate books and users into a working system using Java Collections and method overloading.

### Task 1: Set up collections

- [ ] Create `LibraryManagementSystem`.
- [ ] Add `List<User> registeredUsers = new ArrayList<>()`.
- [ ] Add `List<Book> bookInventory = new ArrayList<>()`.
- [ ] Implement `registerUser(User user)`.
- [ ] Implement `addBook(Book book)`.
- [ ] Test registration and catalog insertion with multiple concrete types.

### Task 2: Implement book searching

- [ ] Implement `searchBooks(String criteria)` to search by title or author.
- [ ] Overload it with `searchBooks(String criteria, String type)` to restrict results to a type such as `TextBook` or `NovelBook`.
- [ ] Test searches with matching and non-matching criteria.

### Task 3: Integrate books and users

- [ ] Create instances of `TextBook` and `NovelBook`.
- [ ] Add the books to the library using `addBook`.
- [ ] Create `Member` and `Librarian` instances.
- [ ] Register users using `registerUser`.
- [ ] Print the inventory and registered users to verify the collections.

### Task 4: Implement lending

- [ ] Implement `lendBook(Member member, Book book)`.
- [ ] Delegate the lending decision to `book.lend(member)`.
- [ ] Increment the member's borrowed-book count only when lending succeeds.
- [ ] Handle attempts to borrow an unavailable book.
- [ ] Handle attempts to exceed the member's borrowing limit.

### Task 5: Implement returns

- [ ] Implement `returnBook(Member member, Book book)`.
- [ ] Delegate the return operation to `book.returnItem(member)`.
- [ ] Decrement the member's borrowed-book count only when a valid return succeeds.
- [ ] Verify that a returned book becomes available for another member.

### Task 6: Display and test system data

- [ ] Implement `displayAllBooks()` using `displayBookDetails()`.
- [ ] Implement `displayRegisteredUsers()` using `displayDashboard()`.
- [ ] Test searching by title, author, and book type.
- [ ] Demonstrate successful and unsuccessful lending and return scenarios.

### Starter API

The following is the suggested public shape of the system. Complete the method bodies as you implement each task.

```java
class LibraryManagementSystem {
    private List<User> registeredUsers = new ArrayList<>();
    private List<Book> bookInventory = new ArrayList<>();

    public void registerUser(User user) {
        registeredUsers.add(user);
    }

    public void addBook(Book book) {
        bookInventory.add(book);
    }

    public boolean lendBook(Member member, Book book) {
        // Delegate to book.lend(member).
        // Increment the borrow count only when lending succeeds.
        // Return whether the operation succeeded.
        return false;
    }

    public void returnBook(Member member, Book book) {
        // Return the book and update the member's borrow count.
    }

    public List<Book> searchBooks(String criteria) {
        // Search by title or author.
        return new ArrayList<>();
    }

    public List<Book> searchBooks(String criteria, String type) {
        // Search by title/author and restrict by book type.
        return new ArrayList<>();
    }

    public void displayAllBooks() {
        // Call displayBookDetails() on each book.
    }

    public void displayRegisteredUsers() {
        // Call displayDashboard() on each user.
    }
}
```

## Suggested Project Structure

Adapt this structure to match the package names and layout used in your IDE.

```text
src/
└── main/
    └── java/
        └── librarymanagementsystem/
            ├── LibraryManagementSystem.java
            ├── client/
            │   └── LibraryClient.java
            ├── users/
            │   ├── User.java
            │   ├── Member.java
            │   └── Librarian.java
            ├── items/
            │   ├── Lendable.java
            │   └── Book.java
            └── books/
                ├── TextBook.java
                └── NovelBook.java
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed.
- An IDE such as IntelliJ IDEA, Eclipse, or VS Code, or a terminal-based Java workflow.

### Run the project

1. Clone or download this repository.
2. Open the project in your Java IDE.
3. Make sure the project SDK is configured to use an installed JDK.
4. Run the client or test class containing the `main` method.
5. Follow the sample operations in the client to register users, add books, search, lend, and return books.

No build tool or database is assumed by this README. Add Maven or Gradle commands here if the project is configured with one.

## Testing Checklist

Use these scenarios to verify the behavior as the milestones are completed:

- [ ] Create users through the default, parameterized, and copy constructors.
- [ ] Verify user IDs are unique and the total-user counter is correct.
- [ ] Verify members can borrow while below the limit of five books.
- [ ] Verify members cannot borrow after reaching the limit.
- [ ] Verify librarians and members display their own dashboards through `User` references.
- [ ] Lend an available book successfully.
- [ ] Reject lending when a book is already unavailable.
- [ ] Return a borrowed book and verify that it becomes available.
- [ ] Verify the member's borrowed-book count changes only after successful lending or return.
- [ ] Search by a book's title and author.
- [ ] Search by concrete book type (`TextBook` or `NovelBook`).
- [ ] Display every book and registered user.

## Future Enhancements

The broader product requirements mention capabilities that are not fully specified in the current milestone tasks. They can be added after the core implementation:

- [ ] Add `Magazine` and `Journal` item classes.
- [ ] Model which item types are lendable and which are restricted to in-library reading.
- [ ] Add book categories such as Fiction, Non-Fiction, and Academic.
- [ ] Add due dates, overdue-loan tracking, and late-fee calculation.
- [ ] Track active loans explicitly, including which member borrowed each item.
- [ ] Implement librarian catalog operations through the central library system.
- [ ] Add validation, exception handling, and automated unit tests.
- [ ] Consider persistent storage if the project later moves beyond an in-memory demonstration.

---

**Learning focus:** Build the system milestone by milestone. Prioritize understanding the OOP design and the borrowing workflow before adding the future enhancements.
