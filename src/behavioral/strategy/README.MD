# Strategy Design Pattern

## Overview

The **Strategy Pattern** is a behavioral design pattern that defines a family of algorithms, encapsulates each one in a separate class, and makes them interchangeable. It allows the algorithm to vary independently from the clients that use it, enabling runtime selection of behavior without modifying the client code.

## Purpose

The Strategy Pattern enables you to:
- Define multiple algorithms for performing the same task
- Encapsulate each algorithm in its own class
- Make algorithms interchangeable at runtime
- Eliminate complex conditional statements (if-else, switch)
- Add new algorithms without modifying existing code
- Separate algorithm implementation from the code that uses it

## Real-Life Analogies

### Payment System
When shopping online, you can choose different payment methods - **Credit Card, PayPal, UPI, Cash on Delivery**. The payment strategy changes based on your preference, but the checkout process remains the same.

### Navigation App
A navigation app offers different routing strategies - **fastest route, shortest route, avoid tolls, scenic route**. You select your preferred strategy, and the app calculates the route accordingly.

### Compression Software
File compression tools support multiple compression algorithms - **ZIP, RAR, 7z, GZIP**. Users choose the compression strategy based on their needs (speed vs. size).

### Sorting Algorithms
A data processing system can use different sorting strategies - **QuickSort, MergeSort, BubbleSort, HeapSort** - depending on the data characteristics and performance requirements.

## Architecture

### Key Participants

1. **Strategy (Interface)** - Defines a common interface for all supported algorithms
2. **ConcreteStrategy** - Implements specific algorithms conforming to the Strategy interface
3. **Context** - Maintains a reference to a Strategy object and delegates algorithm execution to it
4. **Client** - Creates and configures the Context with the desired Strategy

### Structure

```
Client → Context (holds Strategy reference)
              ↓
         Strategy Interface
              ↓
    ┌─────────┼─────────┐
    ↓         ↓         ↓
Strategy A  Strategy B  Strategy C
```

The Context delegates work to the Strategy interface, remaining unaware of which concrete strategy is being used.

## How It Works

### Core Mechanism

1. **Strategy Definition**: Define a common interface for all algorithms
2. **Algorithm Encapsulation**: Implement each algorithm as a separate class
3. **Context Configuration**: Client creates a Context and sets the desired strategy
4. **Delegation**: Context delegates algorithm execution to the strategy object
5. **Runtime Flexibility**: Strategy can be changed at any time without modifying Context

### Workflow

1. **Setup**: Client selects appropriate strategy based on requirements
2. **Injection**: Client injects the strategy into the Context (via constructor or setter)
3. **Execution**: Context calls strategy methods when algorithm execution is needed
4. **Processing**: Strategy performs its specific algorithm implementation
5. **Switching**: Client can change strategy at runtime for different behavior

## Common Use Cases

### 1. Payment Processing
Support multiple payment methods (credit card, debit card, digital wallets, cryptocurrency) with the same checkout interface.

### 2. Sorting and Searching
Implement different sorting algorithms (QuickSort, MergeSort, TimSort) and let the system choose based on data characteristics.

### 3. Validation Strategies
Apply different validation rules (email validation, phone validation, credit card validation) using pluggable validators.

### 4. Compression and Encryption
Provide multiple compression (ZIP, GZIP) or encryption (AES, RSA, Blowfish) algorithms that can be swapped based on requirements.

### 5. Pricing Strategies
Calculate prices using different strategies (regular price, discount, seasonal offers, member pricing).

### 6. File Export Formats
Export data to different formats (CSV, JSON, XML, PDF) using interchangeable export strategies.

### 7. Logging Strategies
Write logs to different destinations (console, file, database, cloud) based on environment or configuration.

### 8. Authentication Methods
Support multiple authentication strategies (basic auth, OAuth, JWT, SAML) in the same application.

## Advantages

✅ **Eliminates Conditionals** - Replaces complex if-else or switch statements with clean polymorphism  
✅ **Open/Closed Principle** - Add new strategies without modifying existing code  
✅ **Runtime Flexibility** - Change algorithms dynamically at runtime  
✅ **Encapsulation** - Each algorithm is isolated in its own class  
✅ **Testability** - Strategies can be tested independently  
✅ **Code Reusability** - Strategies can be reused across different contexts  
✅ **Single Responsibility** - Each strategy class has one reason to change

## Disadvantages

⚠️ **Increased Classes** - More classes in the system (one per strategy)  
⚠️ **Client Awareness** - Clients must be aware of different strategies to choose appropriately  
⚠️ **Communication Overhead** - Context and Strategy must share data, which can be complex  
⚠️ **Overkill for Simple Cases** - May be unnecessary if you only have two algorithms  
⚠️ **Strategy Selection** - Client needs logic to select the appropriate strategy

## When to Use

Consider the Strategy Pattern when:
- You have multiple related classes that differ only in their behavior
- You need different variants of an algorithm
- An algorithm uses data that clients shouldn't know about
- A class defines many behaviors with multiple conditional statements
- You want to avoid exposing complex, algorithm-specific data structures
- You need to switch between different algorithms at runtime

## When NOT to Use

Avoid the Strategy Pattern when:
- You have only one or two algorithms (simpler approaches suffice)
- Algorithms never change and don't need runtime selection
- The overhead of strategy selection is greater than the benefit
- Algorithms are simple enough to be implemented inline

## Real-World Applications

### Java Collections Framework
The `Comparator` interface is a strategy for comparing objects. You can provide different comparison strategies to sorting methods.

### Spring Framework
Spring's transaction management uses Strategy pattern - you can choose different transaction strategies (REQUIRED, REQUIRES_NEW, NESTED).

### Android Development
`RecyclerView.LayoutManager` is a strategy that determines how items are laid out (LinearLayout, GridLayout, StaggeredGridLayout).

### Game Development
AI behavior strategies (aggressive, defensive, patrol, flee) can be swapped based on game state or difficulty level.

### E-commerce Platforms
Shipping calculation strategies (standard, express, same-day, international) based on customer selection and location.

### Tax Calculation Systems
Different tax calculation strategies based on country, state, or tax type (VAT, GST, sales tax).

## Implementation Variations

### Strategy with Factory
Combine Strategy with Factory pattern to encapsulate strategy creation logic.

### Strategy with Null Object
Use a default "do-nothing" strategy to avoid null checks in the Context.

### Functional Strategies (Java 8+)
Use lambda expressions or method references instead of creating separate strategy classes for simple algorithms.

### Strategy with Template Method
Combine both patterns where Strategy defines the overall structure and Template Method handles common parts.

## Best Practices

### Keep Strategies Lightweight
Focus each strategy on a single algorithm. Avoid creating strategies that do too much.

### Use Dependency Injection
Inject strategies via constructors or setters rather than creating them inside the Context.

### Consider Strategy Factories
When you have many strategies, use a factory to create and manage them centrally.

### Document Strategy Differences
Clearly document what each strategy does and when it should be used to help clients make informed choices.

### Handle Strategy Absence
Provide a default strategy or throw meaningful exceptions when no strategy is set.

### Share Common Code
If strategies share common behavior, consider using a base abstract class instead of just an interface.

## Strategy vs. Similar Patterns

### Strategy vs. State
- **Strategy**: Focuses on interchangeable algorithms; client chooses strategy
- **State**: Focuses on object behavior based on internal state; state changes automatically
- Strategy is about "how"; State is about "when"

### Strategy vs. Command
- **Strategy**: Different ways to perform an operation
- **Command**: Encapsulates a request as an object
- Strategy focuses on algorithms; Command focuses on actions

### Strategy vs. Template Method
- **Strategy**: Uses composition and delegation
- **Template Method**: Uses inheritance
- Strategy provides runtime flexibility; Template Method defines compile-time structure

### Strategy vs. Bridge
- **Strategy**: Changes algorithm behavior
- **Bridge**: Separates abstraction from implementation
- Strategy focuses on behavior variation; Bridge focuses on structural decoupling

## Code Smell: When You Need Strategy

### Before Strategy (Code Smell)
```
Large if-else or switch statements
Duplicate code across conditions
Hard to add new behaviors
Tight coupling between behavior and client
```

### After Strategy (Clean Code)
```
Polymorphic strategy objects
No conditionals for behavior selection
Easy to add new strategies
Loose coupling through interfaces
```

## Key Takeaways

🔑 Defines family of interchangeable algorithms encapsulated in separate classes  
🔑 Eliminates messy if-else chains and switch statements  
🔑 Enables runtime algorithm selection and switching  
🔑 Context delegates work to Strategy without knowing concrete implementation  
🔑 New strategies can be added without modifying existing code  
🔑 Each strategy is independently testable and maintainable  
🔑 Client must choose appropriate strategy but Context remains decoupled  
🔑 Perfect for scenarios with multiple ways to accomplish the same task

## Design Principles Supported

- **Open/Closed Principle**: Open for extension (new strategies) without modification
- **Single Responsibility Principle**: Each strategy handles one algorithm
- **Dependency Inversion Principle**: Context depends on Strategy abstraction, not concrete implementations
- **Composition over Inheritance**: Uses object composition instead of class inheritance
- **Favor Polymorphism over Conditionals**: Replaces if-else with polymorphic method calls

## Modern Java Implementation

### Using Lambda Expressions (Java 8+)
For simple strategies, functional interfaces and lambdas provide concise implementation without creating separate classes.

### Using Enums with Strategies
Combine enum constants with strategy implementations for type-safe, limited strategy sets.

### Using Method References
Pass method references as strategies for maximum conciseness when methods already exist.

---

*The Strategy Pattern is essential for building flexible, maintainable systems where algorithms need to be interchangeable and extensible without complex conditional logic