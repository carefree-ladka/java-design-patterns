# Singleton Design Pattern

## Overview
This repository contains implementations of the **Singleton Design Pattern** in Java. The Singleton Pattern is a creational design pattern that ensures a class has only one instance throughout the application lifecycle and provides a global point of access to that instance.

---

## What is Singleton Pattern?

The Singleton Pattern guarantees that:
- A class has **only one instance**
- Provides a **global point of access** to that instance

---

## Common Use Cases

<div style="background: #f6f8fa; padding: 20px; border-radius: 8px; margin: 20px 0;">

- 🔧 **Configuration managers** - Managing application-wide settings
- 📝 **Logger classes** - Centralized logging mechanism
- 💾 **Cache managers** - Shared cache across the application
- 🔄 **Thread pools** - Managing a pool of reusable threads
- 🗄️ **Database connection pools** - Shared database connections

</div>

---

## Key Characteristics

1. **Private Constructor** → Prevents other classes from instantiating the class directly
2. **Static Instance Variable** → Holds the single instance of the class
3. **Public Static Method** → Provides controlled access to the instance

---

## Implementation Approaches

### 1. Eager Initialization

**Description:** Instance is created at the time of class loading.

<div style="margin: 15px 0;">

#### ✅ Pros:
- Simple implementation
- Thread-safe by default

#### ❌ Cons:
- Instance is created even if not needed
- No lazy loading capability

</div>

---

### 2. Lazy Initialization

**Description:** Instance is created only when needed (on first access).

<div style="background: #fff3cd; padding: 15px; border-left: 4px solid #ffc107; margin: 15px 0;">

⚠️ **Warning:** Not thread-safe. If two threads call `getInstance()` simultaneously, multiple instances can be created.

</div>

---

### 3. Thread-Safe Singleton (Synchronized Method)

**Description:** Uses `synchronized` keyword to ensure thread safety.

<div style="margin: 15px 0;">

#### ✅ Pros:
- Thread-safe implementation

#### ❌ Cons:
- Synchronization overhead on every call
- Performance impact due to locking

</div>

---

### 4. Double-Checked Locking

**Description:** Efficient thread-safe implementation with minimal synchronization overhead.

<div style="margin: 15px 0;">

#### ✅ Pros:
- Thread-safe and efficient
- Synchronization only on first creation
- Uses `volatile` keyword to prevent instruction reordering issues

#### Key Points:
- First check without synchronization for performance
- Second check inside synchronized block for safety
- `volatile` ensures visibility across threads

</div>

---

### 5. Bill Pugh Singleton (Recommended)

**Description:** Uses inner static helper class for lazy loading without synchronization.

<div style="background: #d4edda; padding: 15px; border-left: 4px solid #28a745; margin: 15px 0;">

✅ **Best Practice:** This is the widely recommended approach for implementing Singleton in Java.

#### Advantages:
- Thread-safe without synchronization
- Lazy initialization
- No performance overhead
- Simple and clean implementation
- Leverages Java's class loading mechanism

</div>

---

## Testing

All implementations include test cases that verify:
- Only one instance is created
- Multiple calls to `getInstance()` return the same instance
- Instance references are identical (`e1 == e2` returns `true`)

### Expected Test Results

All singleton implementations should return `true` when comparing instance references, confirming that only one instance exists.

---

## Comparison Table

| Approach | Thread-Safe | Lazy Loading | Performance | Complexity |
|----------|-------------|--------------|-------------|------------|
| Eager Initialization | ✅ Yes | ❌ No | High | Low |
| Lazy Initialization | ❌ No | ✅ Yes | High | Low |
| Synchronized Method | ✅ Yes | ✅ Yes | Low | Low |
| Double-Checked Locking | ✅ Yes | ✅ Yes | High | Medium |
| Bill Pugh (Recommended) | ✅ Yes | ✅ Yes | High | Low |

---

## When to Use Singleton?

Use Singleton when:
- You need exactly one instance of a class
- The instance needs to be accessible globally
- You want to control instance creation and lifecycle

**Avoid overusing Singleton** as it can:
- Make unit testing difficult
- Hide dependencies
- Create tight coupling
- Act as a global state (anti-pattern in some cases)

---

## Best Practices

1. **Use Bill Pugh approach** for most scenarios
2. **Make constructor private** to prevent instantiation
3. **Consider using `enum`** for serialization-safe singleton
4. **Be cautious with reflection** which can break singleton pattern
5. **Consider dependency injection** as an alternative in modern applications

---

## License

This implementation is provided for educational purposes.