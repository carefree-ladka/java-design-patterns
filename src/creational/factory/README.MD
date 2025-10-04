# Factory Design Pattern

## Overview
The **Factory Design Pattern** is a creational design pattern that provides an interface for creating objects but allows subclasses to decide which class to instantiate. It promotes loose coupling by eliminating the need to bind application-specific classes into your code.

---

## What is Factory Pattern?

The Factory Pattern helps to:
- **Decouple object creation** from usage
- Follow the **Open/Closed Principle** (open for extension, closed for modification)
- Centralize object creation logic
- Hide complex instantiation logic from clients

---

## Key Concepts

<div style="background: #f6f8fa; padding: 20px; border-radius: 8px; margin: 20px 0;">

1. **Product** → The interface or abstract class for objects to be created
2. **ConcreteProduct** → Actual implementations of the Product interface
3. **Factory** → Interface or abstract class declaring creation method(s)
4. **ConcreteFactory** → Implements the factory and creates specific products

</div>

---

## Implementation Structure

### Component Hierarchy

```
Shape (Interface)
    ├── Circle
    ├── Rectangle
    └── Square

ShapeFactory
    └── getShape(String type)
```

---

## Example: Shape Factory

This example demonstrates creating different types of shapes using the Factory Pattern.

### Step 1: Product Interface
Defines the contract that all concrete products must follow.

### Step 2: Concrete Products
Individual shape classes (Circle, Rectangle, Square) that implement the Shape interface.

### Step 3: Factory Class
`ShapeFactory` contains the logic to create and return appropriate shape objects based on input.

### Step 4: Client Code
The client uses the factory to get shape objects without knowing the instantiation details.

---

## How It Works

<div style="background: #e7f3ff; padding: 15px; border-left: 4px solid #2196F3; margin: 15px 0;">

1. Client requests a shape from the factory (e.g., "circle")
2. Factory determines which concrete class to instantiate
3. Factory creates and returns the appropriate object
4. Client uses the object through the Shape interface

</div>

---

## Advantages

<div style="margin: 15px 0;">

✅ **Encapsulation** - Object creation logic is centralized in one place

✅ **Loose Coupling** - Client code doesn't depend on concrete classes

✅ **Easy Extension** - New products can be added without modifying existing code

✅ **Single Responsibility** - Creation logic is separated from business logic

✅ **Testability** - Easier to mock and test components independently

</div>

---

## When to Use Factory Pattern?

Use Factory Pattern when:
- The exact type of object isn't known until runtime
- Object creation involves complex logic
- You want to centralize object creation
- You need to follow the Open/Closed Principle
- Multiple related products need to be created

---

## Factory Pattern Variants

### 1. Simple Factory
<div style="background: #fff9e6; padding: 15px; margin: 15px 0; border-radius: 6px;">

**Description:** A single factory method returns one of multiple concrete classes based on input.

**Use Case:** When you have a simple set of related objects to create.

**Example:** Our ShapeFactory implementation above.

</div>

### 2. Factory Method
<div style="background: #e8f5e9; padding: 15px; margin: 15px 0; border-radius: 6px;">

**Description:** Subclasses decide which object to instantiate. Each subclass has its own `create()` method.

**Use Case:** When subclasses need to determine the type of object to create.

**Example:** Different shape factories (CircleFactory, RectangleFactory) each creating their specific shape.

</div>

### 3. Abstract Factory
<div style="background: #f3e5f5; padding: 15px; margin: 15px 0; border-radius: 6px;">

**Description:** Factory of factories. Creates families of related objects without specifying their concrete classes.

**Use Case:** When you need to create families of related products.

**Example:** UIFactory creating related UI components (Button, TextField, Checkbox) for different themes (Light, Dark).

</div>

---

## Real-World Use Cases

<div style="background: #f6f8fa; padding: 20px; border-radius: 8px; margin: 20px 0;">

- 🗄️ **Database Connections** - Creating different database connection objects (MySQL, PostgreSQL, MongoDB)
- 📄 **Document Processing** - Creating different document types (PDF, Word, Excel)
- 🎨 **UI Frameworks** - Creating platform-specific UI components (Android, iOS, Web)
- 🚗 **Vehicle Manufacturing** - Creating different vehicle types (Car, Truck, Motorcycle)
- 💳 **Payment Processing** - Creating different payment method handlers (Credit Card, PayPal, Crypto)
- 📧 **Notification Systems** - Creating different notification channels (Email, SMS, Push)

</div>

---

## Comparison with Other Patterns

| Pattern | Purpose | Use Case |
|---------|---------|----------|
| **Factory** | Creates single objects | Simple object creation with variations |
| **Abstract Factory** | Creates families of objects | Related objects that work together |
| **Builder** | Constructs complex objects step-by-step | Objects with many optional parameters |
| **Prototype** | Creates objects by cloning | When object creation is expensive |

---

## Best Practices

1. **Use meaningful names** for factory methods (e.g., `createShape()` instead of `get()`)
2. **Return interfaces** rather than concrete classes
3. **Validate input** before creating objects
4. **Handle null cases** gracefully
5. **Consider using enums** instead of strings for type parameters
6. **Document** which products the factory can create
7. **Keep factories simple** - complex logic might indicate need for Builder pattern

---

## Testing

The factory pattern makes testing easier:
- Mock factories can return test doubles
- Different implementations can be swapped easily
- Client code doesn't need to know about concrete classes

---

## Common Pitfalls

<div style="background: #ffebee; padding: 15px; border-left: 4px solid #f44336; margin: 15px 0;">

⚠️ **Avoid:**
- Creating a "God Factory" that knows about too many products
- Using strings for type parameters (use enums instead)
- Adding too much business logic in the factory
- Breaking the Single Responsibility Principle

</div>

---

## License

This implementation is provided for educational purposes.