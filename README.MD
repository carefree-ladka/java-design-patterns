# Design Patterns in Java

## Overview
Design patterns are **reusable solutions to common problems in software design**. They are not code you can copy-paste but rather templates or best practices for solving recurring design issues in object-oriented programming.

---

## What are Design Patterns?

<div style="background: #e7f3ff; padding: 20px; border-radius: 8px; margin: 20px 0;">

Design patterns provide:
- **Proven solutions** to common software design problems
- **Standard vocabulary** for developers to communicate effectively
- **Best practices** accumulated from years of software development experience
- **Templates** that can be adapted to specific situations

**Important:** Patterns are guidelines, not strict rules. They should be adapted to fit your specific context.

</div>

---

## Benefits of Using Design Patterns

<div style="margin: 20px 0;">

✅ **Improved Readability** - Code structure is more recognizable and understandable

✅ **Better Maintainability** - Easier to modify and extend code over time

✅ **Code Reuse** - Promotes reusable solutions across projects

✅ **Reduced Coupling** - Decreases dependencies between components

✅ **Increased Flexibility** - Makes code more adaptable to change

✅ **Common Vocabulary** - Facilitates communication between developers

✅ **Faster Development** - Solve problems using proven approaches

✅ **Quality Assurance** - Battle-tested solutions reduce bugs

</div>

---

## Categories of Design Patterns

Design patterns are organized into three main categories based on their purpose:

<div style="background: #f6f8fa; padding: 20px; border-radius: 8px; margin: 20px 0;">

### 📦 Creational Patterns
Focus on **object creation mechanisms**

### 🏗️ Structural Patterns
Focus on **class and object composition**

### 🔄 Behavioral Patterns
Focus on **communication between objects**

</div>

---

## 📦 Creational Patterns

<div style="background: #e8f5e9; padding: 20px; border-radius: 8px; margin: 20px 0;">

Creational patterns deal with **object creation mechanisms**, aiming to create objects in a manner suitable to the situation. They help make a system independent of how its objects are created, composed, and represented.

</div>

### Pattern Catalog

| Pattern | Purpose | Java Example | When to Use |
|---------|---------|--------------|-------------|
| **Singleton** | Ensure only one instance of a class exists | `Runtime.getRuntime()` | Logger, Config Manager |
| **Factory Method** | Define interface for creating objects, let subclasses decide | `Calendar.getInstance()` | Unknown object types at compile time |
| **Abstract Factory** | Create families of related objects | GUI library: `WindowsFactory`, `MacFactory` | Product families that work together |
| **Builder** | Build complex objects step by step | `StringBuilder`, `DocumentBuilder` | Objects with many optional parameters |
| **Prototype** | Create objects by copying existing ones | `Object.clone()` | When object creation is expensive |

### Key Characteristics:
- Abstract instantiation process
- Make system independent of object creation
- Hide complexity of creating objects
- Provide flexibility in what gets created

---

## 🏗️ Structural Patterns

<div style="background: #fff9e6; padding: 20px; border-radius: 8px; margin: 20px 0;">

Structural patterns explain how to assemble **objects and classes into larger structures** while keeping these structures flexible and efficient. They focus on simplifying relationships between entities.

</div>

### Pattern Catalog

| Pattern | Purpose | Java Example | When to Use |
|---------|---------|--------------|-------------|
| **Adapter** | Convert one interface to another | `Arrays.asList()` | Incompatible interfaces |
| **Bridge** | Separate abstraction from implementation | JDBC drivers | Avoid permanent binding |
| **Composite** | Treat individual objects and compositions uniformly | `javax.swing.JComponent` | Tree structures |
| **Decorator** | Add responsibilities dynamically | `BufferedReader`, `FilterInputStream` | Add features without subclassing |
| **Facade** | Provide simplified interface to subsystem | `javax.faces.context.FacesContext` | Complex subsystems |
| **Flyweight** | Share objects to save memory | `String` pool, `Integer.valueOf()` | Many similar objects |
| **Proxy** | Provide placeholder for another object | `java.lang.reflect.Proxy` | Control access, lazy loading |

### Key Characteristics:
- Compose objects to form larger structures
- Simplify structure through abstraction
- Focus on relationships between entities
- Provide flexibility in structure

---

## 🔄 Behavioral Patterns

<div style="background: #f3e5f5; padding: 20px; border-radius: 8px; margin: 20px 0;">

Behavioral patterns focus on **communication between objects**, how they interact and distribute responsibility. They characterize complex control flow that's difficult to follow at runtime.

</div>

### Pattern Catalog

| Pattern | Purpose | Java Example | When to Use |
|---------|---------|--------------|-------------|
| **Observer** | Notify dependent objects automatically | `java.util.Observer`, Event Listeners | One-to-many dependencies |
| **Strategy** | Encapsulate interchangeable algorithms | `Comparator`, `LayoutManager` | Multiple algorithms for one task |
| **Command** | Encapsulate request as object | `Runnable`, `ActionListener` | Queue, log, or undo operations |
| **Chain of Responsibility** | Pass requests along chain of handlers | Servlet filters, Exception handling | Multiple handlers for requests |
| **Mediator** | Reduce coupling between components | `java.util.concurrent.Executor` | Complex communications |
| **Iterator** | Access elements without exposing structure | `Iterator`, `ListIterator` | Traverse collections |
| **State** | Change behavior when state changes | `Thread.State` | Object behavior depends on state |
| **Template Method** | Define algorithm skeleton | `AbstractList`, `HttpServlet` | Invariant algorithm structure |
| **Visitor** | Separate algorithms from object structure | `FileVisitor` | Operations on object structure |
| **Memento** | Capture and restore object state | Serialization | Undo functionality |
| **Interpreter** | Define grammar and interpret sentences | `Pattern`, regex | Language processing |

### Key Characteristics:
- Define communication protocols
- Assign responsibilities
- Control complex flows
- Decouple sender and receiver

---

## Pattern Relationships

<div style="background: #e7f3ff; padding: 20px; border-radius: 8px; margin: 20px 0;">

### Patterns Often Work Together:

- **Abstract Factory** + **Factory Method** - Factories use factory methods to create products
- **Builder** + **Composite** - Builders construct complex composite structures
- **Prototype** + **Abstract Factory** - Factories can use prototypes to create objects
- **Singleton** + **Factory** - Factories are often implemented as singletons
- **Decorator** + **Strategy** - Decorators can use strategies for variations
- **Observer** + **Mediator** - Mediators can notify observers
- **Chain of Responsibility** + **Command** - Commands can be passed along chains

</div>

---

## Java-Specific Considerations

<div style="background: #f0f4ff; padding: 20px; border-radius: 8px; margin: 20px 0;">

### Best Practices for Java:

1. **Use Interfaces and Abstract Classes**
    - Leverage Java's interface and inheritance capabilities
    - Define contracts for patterns

2. **Enum for Singleton**
    - Thread-safe, simple, serialization-proof
   ```java
   public enum Singleton {
       INSTANCE;
       public void doSomething() { }
   }
   ```

3. **Leverage Java SDK Patterns**
    - Many patterns are already implemented
    - Learn to recognize and reuse them
    - Don't reinvent the wheel

4. **Use Generics**
    - Make patterns type-safe
    - Increase reusability

5. **Consider Functional Interfaces**
    - Strategy pattern with lambda expressions
    - Command pattern with method references

6. **Annotations for Patterns**
    - Document pattern usage with custom annotations
    - Makes patterns explicit in code

</div>

---

## Patterns in Java Standard Library

<div style="background: #f6f8fa; padding: 20px; border-radius: 8px; margin: 20px 0;">

### Common Java API Examples:

#### Creational:
- `Calendar.getInstance()` - Factory Method
- `Runtime.getRuntime()` - Singleton
- `StringBuilder` - Builder
- `Object.clone()` - Prototype

#### Structural:
- `Collections.unmodifiableList()` - Decorator
- `Arrays.asList()` - Adapter
- `String` interning - Flyweight
- `java.lang.reflect.Proxy` - Proxy

#### Behavioral:
- `Iterator` - Iterator
- `Comparator` - Strategy
- `Observable/Observer` - Observer
- `Runnable` - Command
- `InputStream.read()` - Template Method

</div>

---

## When to Use Design Patterns

<div style="background: #e8f5e9; padding: 15px; border-left: 4px solid #4caf50; margin: 15px 0;">

### ✅ Use patterns when:
- Problem matches pattern's intent
- Benefits outweigh added complexity
- Team understands the pattern
- Code will benefit from flexibility
- Similar problems occur frequently

</div>

<div style="background: #ffebee; padding: 15px; border-left: 4px solid #f44336; margin: 15px 0;">

### ❌ Avoid patterns when:
- Over-engineering simple problems
- Pattern doesn't fit the problem
- Adding unnecessary complexity
- Forcing patterns where they don't belong
- Team is unfamiliar with pattern

</div>

---

## Common Anti-Patterns to Avoid

<div style="background: #fff3cd; padding: 15px; border-left: 4px solid #ffc107; margin: 15px 0;">

⚠️ **Pattern Overload**: Using too many patterns unnecessarily

⚠️ **Golden Hammer**: Applying same pattern to every problem

⚠️ **Copy-Paste Programming**: Not understanding pattern before using

⚠️ **Premature Optimization**: Adding patterns before needed

⚠️ **God Object**: Single class doing too much

⚠️ **Spaghetti Code**: Lack of structure and organization

</div>

---

## Learning Path

### For Beginners:
1. Start with **Creational patterns** (Singleton, Factory, Builder)
2. Move to **Structural patterns** (Adapter, Decorator, Facade)
3. Study **Behavioral patterns** (Observer, Strategy, Command)

### For Intermediate:
1. Understand pattern relationships
2. Recognize patterns in existing code
3. Practice refactoring to patterns

### For Advanced:
1. Combine multiple patterns
2. Create pattern variations
3. Know when NOT to use patterns

---

## Quick Reference Guide

<div style="background: #f0f4ff; padding: 20px; border-radius: 8px; margin: 20px 0;">

### Need to...?

**Create objects flexibly?** → Creational Patterns
- Single instance: Singleton
- Family of objects: Abstract Factory
- Complex objects: Builder
- Type-based creation: Factory Method

**Organize structure?** → Structural Patterns
- Incompatible interfaces: Adapter
- Add features: Decorator
- Simplify complexity: Facade
- Share objects: Flyweight

**Manage behavior?** → Behavioral Patterns
- Notify changes: Observer
- Switch algorithms: Strategy
- Pass requests: Chain of Responsibility
- Encapsulate requests: Command

</div>

---

## Resources for Further Learning

- **Books**: "Design Patterns" (Gang of Four), "Head First Design Patterns"
- **Online**: Refactoring.Guru, SourceMaking, Java Design Patterns GitHub
- **Practice**: LeetCode, HackerRank, implement patterns in personal projects
- **Code Review**: Study open-source projects using patterns

---

## Summary

<div style="background: #f0f4ff; padding: 20px; border-radius: 8px; margin: 20px 0; border: 2px solid #5c7cfa;">

### Key Takeaways:

🎯 **23 Classic Patterns** organized into 3 categories

📚 **Proven Solutions** to recurring software design problems

🔧 **Not Code** but templates and best practices

💡 **Improve Communication** through common vocabulary

⚖️ **Balance** between using patterns and over-engineering

🚀 **Foundation** for writing maintainable, scalable code

</div>

---

## License

This documentation is provided for educational purposes.