# Builder Design Pattern

## Overview
The **Builder Pattern** is a creational design pattern used to construct **complex objects step by step**. It separates the construction of an object from its representation, allowing the same construction process to create different representations with clean, readable code.

---

## What is Builder Pattern?

<div style="background: #e7f3ff; padding: 20px; border-radius: 8px; margin: 20px 0;">

The Builder Pattern is ideal when:
- An object has **many optional parameters**
- You want to **avoid telescoping constructors** (constructors with many parameters)
- Object construction requires **multiple steps**
- You need to create **different representations** of the same object
- You want **immutable objects** with flexible initialization

**Key Concept:** Build complex objects step by step using a fluent, chainable API.

</div>

---

## The Problem: Telescoping Constructors

### ❌ Without Builder Pattern:

```
// Nightmare constructor with many parameters
House house = new House("Concrete", "Brick", "Concrete Roof", true, 
                       3, 2, true, false, "Modern", "Large");

// Which parameter is what? 🤔
// Hard to read, error-prone, inflexible
```

### ✅ With Builder Pattern:

```
House house = new House.HouseBuilder()
    .setFoundation("Concrete")
    .setStructure("Brick")
    .setRoof("Concrete Roof")
    .setFurnished(true)
    .build();

// Clear, readable, flexible! 🎉
```

---

## Key Components

<div style="background: #f6f8fa; padding: 20px; border-radius: 8px; margin: 20px 0;">

1. **Product** → The complex object being built (e.g., `House`)
2. **Builder** → Abstract interface defining methods for creating parts of the product
3. **ConcreteBuilder** → Implements the Builder interface and constructs the product
4. **Director** (optional) → Controls the building steps and sequences
5. **Client** → Uses the Builder to create objects

</div>

---

## Pattern Structure

### Component Hierarchy

```
House (Product)
    └── HouseBuilder (Builder)
            ├── setFoundation()
            ├── setStructure()
            ├── setRoof()
            ├── setFurnished()
            └── build() → returns House

Client
    └── Uses HouseBuilder to construct House
```

---

## Implementation Example: House Builder

This example demonstrates building a `House` object with multiple optional components.

### Key Features:
- **Private constructor** - Forces use of Builder
- **Fluent interface** - Methods return `this` for chaining
- **Flexibility** - Build houses with different configurations
- **Immutability** - Product is immutable after construction

---

## How It Works

<div style="background: #e8f5e9; padding: 15px; border-left: 4px solid #4caf50; margin: 15px 0;">

### Step-by-Step Process:

1. **Client** creates a Builder instance
2. **Client** calls builder methods to set properties (chainable)
3. **Builder** accumulates the configuration
4. **Client** calls `build()` to construct the final object
5. **Product** is created using the builder's configuration
6. **Product** is returned as an immutable object

</div>

---

## Advantages

<div style="margin: 15px 0;">

✅ **Readable Code** - Clear, self-documenting method calls

✅ **Flexible Construction** - Set only the parameters you need

✅ **Immutability** - Products can be made immutable

✅ **No Telescoping Constructors** - Avoid complex constructors with many parameters

✅ **Different Representations** - Same builder can create different product variations

✅ **Step-by-Step Construction** - Build objects incrementally

✅ **Validation** - Validate object state before construction in `build()` method

</div>

---

## Disadvantages

<div style="background: #fff3cd; padding: 15px; border-left: 4px solid #ffc107; margin: 15px 0;">

⚠️ **More Code** - Requires creating a separate Builder class

⚠️ **Complexity** - Overkill for simple objects with few parameters

⚠️ **Memory Overhead** - Builder object exists temporarily during construction

</div>

---

## When to Use Builder Pattern?

Use Builder Pattern when:

- Object has **4+ constructor parameters** (especially optional ones)
- Object construction requires **multiple steps**
- You want to create **immutable objects** with flexible initialization
- Constructor parameters would be **confusing** or error-prone
- You need **different representations** of the same object
- Object validation is needed before construction

### Don't Use When:
- Object is simple with few parameters
- All parameters are required
- Constructor is sufficient and clear

---

## Real-World Use Cases

<div style="background: #f6f8fa; padding: 20px; border-radius: 8px; margin: 20px 0;">

### 🏗️ Construction Objects
Building complex configurations
- House, Car, Computer
- Different components, optional features

### 📄 Document Builders
Creating structured documents
- PDFBuilder, HTMLBuilder
- Headers, body, footers, styling

### 🍔 Food Orders
Customizable menu items
- Pizza, Burger, Sandwich
- Multiple toppings, sizes, extras

### 🔧 Configuration Objects
Application settings
- DatabaseConfig, ServerConfig
- Connection pools, timeouts, credentials

### 📊 Query Builders
Database queries
- SQL queries, API requests
- Filters, sorting, pagination

### 🎮 Game Characters
Complex character creation
- Character stats, equipment, skills
- Different classes, races, abilities

</div>

---

## Java Standard Library Examples

<div style="background: #e7f3ff; padding: 15px; border-radius: 6px; margin: 15px 0;">

The Builder Pattern is used extensively in Java:

- **StringBuilder** - Building strings incrementally
- **Stream.Builder** - Constructing streams
- **Calendar.Builder** - Creating calendar instances
- **Locale.Builder** - Building locale objects
- **ProcessBuilder** - Constructing system processes
- **UriBuilder** - Building URIs

</div>

---

## Builder Pattern Variants

### 1. Static Inner Builder Class (Recommended)
<div style="background: #e8f5e9; padding: 15px; margin: 15px 0; border-radius: 6px;">

**Description:** Builder is a static inner class of the product.

**Advantages:**
- Tight coupling between product and builder
- No separate file needed
- Clean encapsulation

**Example:** Our `House.HouseBuilder` implementation above.

</div>

### 2. Separate Builder Class
<div style="background: #fff9e6; padding: 15px; margin: 15px 0; border-radius: 6px;">

**Description:** Builder is a separate standalone class.

**Advantages:**
- Better separation of concerns
- Easier to have multiple builders for same product
- Can be in different package

**Use Case:** When you need multiple builder variations.

</div>

### 3. Builder with Director
<div style="background: #f3e5f5; padding: 15px; margin: 15px 0; border-radius: 6px;">

**Description:** Director class controls the building sequence.

**Advantages:**
- Encapsulates complex building sequences
- Reusable construction logic
- Standard configurations

**Example:**
```java
class HouseDirector {
    public House buildLuxuryHouse(HouseBuilder builder) {
        return builder
            .setFoundation("Reinforced Concrete")
            .setStructure("Steel & Glass")
            .setRoof("Solar Panel Roof")
            .setFurnished(true)
            .build();
    }
}
```

</div>

---

## Implementation Best Practices

1. **Use method chaining** - Return `this` from builder methods
2. **Make products immutable** - No setters in the product class
3. **Validate in build()** - Check required fields before creating object
4. **Private product constructor** - Force use of builder
5. **Use descriptive method names** - `setFoundation()` not `foundation()`
6. **Consider default values** - For optional parameters
7. **Support null safety** - Handle null inputs gracefully
8. **Document required vs optional** - Make it clear which fields are mandatory

---

## Enhanced Builder Example

<div style="background: #f0f4ff; padding: 15px; border-radius: 6px; margin: 15px 0;">

### Adding Validation:

```java
public House build() {
    // Validate required fields
    if (foundation == null || structure == null) {
        throw new IllegalStateException(
            "Foundation and structure are required!");
    }
    
    // Set defaults for optional fields
    if (roof == null) {
        roof = "Standard Roof";
    }
    
    return new House(this);
}
```

</div>

---

## Builder vs Other Patterns

| Pattern | Purpose | Use Case |
|---------|---------|----------|
| **Builder** | Construct complex objects step by step | Many optional parameters |
| **Factory** | Create objects with simple instantiation | Type-based object creation |
| **Abstract Factory** | Create families of related objects | Product families |
| **Prototype** | Create objects by cloning | Expensive object creation |

---

## Common Pitfalls

<div style="background: #ffebee; padding: 15px; border-left: 4px solid #f44336; margin: 15px 0;">

### ❌ Avoid:

- **Not making products immutable** - Defeats one of the main benefits
- **Forgetting to validate** - Should validate in `build()` method
- **Overusing the pattern** - Don't use for simple objects
- **Not returning 'this'** - Breaks method chaining
- **Mutable builder after build()** - Builder should not be reused

</div>

---

## Testing Strategy

<div style="background: #e8f5e9; padding: 15px; border-radius: 6px; margin: 15px 0;">

### Unit Testing:
- Test builder with all parameters set
- Test builder with only required parameters
- Test builder with invalid states
- Verify immutability of product
- Test default values

### Edge Cases:
- Null values
- Empty strings
- Boundary values
- Required field validation
- Multiple build() calls

</div>

---

## Lombok Integration

<div style="background: #e7f3ff; padding: 15px; border-radius: 6px; margin: 15px 0;">

For Java projects using Lombok, you can generate builders automatically:

```java
@Builder
@Getter
public class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean furnished;
}
```

This generates a builder similar to our manual implementation!

</div>

---

## Summary

<div style="background: #f0f4ff; padding: 20px; border-radius: 8px; margin: 20px 0; border: 2px solid #5c7cfa;">

### Key Takeaways:

🎯 **Purpose**: Construct complex objects step by step with clean, readable code

🔗 **Structure**: Fluent interface with method chaining for flexibility

✨ **Benefit**: Avoids telescoping constructors and improves code readability

📦 **Use When**: Objects have many optional parameters or require step-by-step construction

⚙️ **Trade-off**: More code for better flexibility and maintainability

</div>

---

## License

This implementation is provided for educational purposes.