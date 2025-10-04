# Bridge Pattern

## Overview
The **Bridge Pattern** is a structural design pattern that **decouples abstraction from its implementation**, allowing both to evolve independently. It separates **"what to do"** (abstraction) from **"how to do it"** (implementation).

## Real-Life Analogy
Think of **remote controls and TVs**:
- You have different **remote controls** (abstractions) that can work with various **TV brands** (implementations)
- The **Remote** defines high-level operations like power on/off and channel selection
- Each **TV brand** implements the low-level details of how these operations actually work
- You can add new remote types without changing TV code, and new TV brands without modifying remotes

This separation is the essence of the Bridge Pattern.

## Structure
The pattern consists of four key components:

1. **Abstraction** - High-level control interface (e.g., RemoteControl)
2. **Refined Abstraction** - Extended version of abstraction (e.g., AdvancedRemote)
3. **Implementor** - Low-level interface defining operations (e.g., TV interface)
4. **Concrete Implementor** - Specific implementation (e.g., SonyTV, SamsungTV)

## How It Works
```
Client → Abstraction → Implementor
              ↓              ↓
    RefinedAbstraction  ConcreteImplementor
```

The abstraction contains a reference to the implementor and delegates the actual work to it. This composition-based approach provides flexibility that inheritance cannot achieve.

## When to Use the Bridge Pattern

### ✅ Use When:
- You need to **decouple abstraction from implementation** so both can vary independently
- Both abstraction and implementation should be **extensible through subclassing**
- Changes in implementation shouldn't affect client code
- You want to avoid a **permanent binding** between abstraction and implementation
- You need to **share implementation** among multiple objects while hiding details from clients
- You have a **proliferation of classes** from trying to extend in two independent dimensions

### ❌ Avoid When:
- Your abstraction and implementation don't need to vary independently
- You have a simple hierarchy with no need for multiple implementations
- The added complexity doesn't provide clear benefits

## Benefits
- **Decoupling** - Separates interface from implementation
- **Improved Extensibility** - Extend abstraction and implementation hierarchies independently
- **Hiding Implementation Details** - Implementation details are hidden from clients
- **Reduced Coupling** - Client code only knows about the abstraction
- **Single Responsibility Principle** - Separate high-level logic from platform details
- **Open/Closed Principle** - Add new abstractions and implementations without changing existing code

## Real-World Examples

### 1. GUI Frameworks
- **Abstraction**: Window, Button, TextField
- **Implementation**: Windows API, macOS API, Linux API

### 2. Database Drivers
- **Abstraction**: Database connection interface
- **Implementation**: MySQL driver, PostgreSQL driver, Oracle driver

### 3. Graphics Systems
- **Abstraction**: Shape (Circle, Square, Triangle)
- **Implementation**: Rendering APIs (OpenGL, DirectX, Vulkan)

### 4. Messaging Systems
- **Abstraction**: Message sender
- **Implementation**: Email, SMS, Push Notification

### 5. Payment Processing
- **Abstraction**: Payment processor
- **Implementation**: Credit card, PayPal, Cryptocurrency

## Bridge vs Adapter Pattern

| Aspect | Bridge Pattern | Adapter Pattern |
|--------|---------------|-----------------|
| **Intent** | Design abstractions and implementations to vary independently | Make incompatible interfaces work together |
| **When Applied** | During design phase | After design (often to fix compatibility) |
| **Structure** | Planned and intentional separation | Wraps existing incompatible interface |
| **Flexibility** | High - both sides can evolve | Limited to making interfaces compatible |

## Key Takeaways
- **Bridge = Composition over Inheritance** - Use object composition instead of multiple inheritance
- **Two Dimensions of Change** - Allows independent variation of abstraction and implementation
- **Flexibility** - Add new abstractions or implementations without affecting each other
- **Avoid Class Explosion** - Prevents exponential growth of subclasses when extending in multiple dimensions

## Summary
The Bridge Pattern is about **building flexibility into your design from the start**. It recognizes that abstraction and implementation are two separate concerns that can evolve independently. By using composition instead of inheritance, you create a bridge between these concerns that keeps your codebase maintainable and extensible as requirements change.

Think of it as building a bridge between two islands (abstraction and implementation) that can each grow and change without affecting the other.