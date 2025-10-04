# Proxy Design Pattern

## Overview

The **Proxy Pattern** is a structural design pattern that provides a placeholder or surrogate object to control access to another object, known as the **real subject**. It acts as an intermediary, adding a level of indirection between the client and the actual object without changing the object's interface.

## Purpose

The Proxy Pattern allows you to:
- Control and restrict access to objects
- Add additional functionality (logging, caching, security checks)
- Defer expensive operations until they're actually needed
- Represent remote objects locally
- Manage resource-intensive objects efficiently

## Architecture

### Key Participants

1. **Subject (Interface)** - Defines the common interface shared by both RealSubject and Proxy
2. **RealSubject** - The actual object that performs the real work
3. **Proxy** - Controls access to the RealSubject and may add extra functionality
4. **Client** - Interacts with the Subject interface, remaining unaware of whether it's communicating with a Proxy or RealSubject

### Structure

```
Client → Subject Interface ← Proxy → RealSubject
```

The client communicates through the Subject interface, while the Proxy manages when and how the RealSubject is accessed.

## Common Use Cases

### 1. Virtual Proxy (Lazy Loading)
Delays the creation of expensive objects until they're actually needed. Perfect for:
- Loading large images or media files on demand
- Initializing heavy database connections
- Deferring resource-intensive computations

### 2. Protection Proxy (Access Control)
Adds security layers to control access based on permissions. Useful for:
- Authorization checks before method execution
- Role-based access control
- Restricting operations to authorized users only

### 3. Remote Proxy
Provides a local representative for an object in a different address space. Common in:
- Remote Method Invocation (RMI)
- Distributed systems
- Microservices communication

### 4. Caching Proxy
Stores results of expensive operations to improve performance. Ideal for:
- Database query results
- API call responses
- Computational results that don't change frequently

### 5. Logging Proxy
Intercepts method calls to add logging functionality without modifying the original object.

### 6. Smart Reference Proxy
Performs additional actions when an object is accessed, such as reference counting or loading persistent objects.

## How It Works

### Workflow

1. **Client Request** - The client makes a request through the Subject interface
2. **Proxy Intercepts** - The Proxy receives the request first
3. **Additional Logic** - The Proxy may perform preprocessing (validation, logging, caching checks)
4. **Delegation** - The Proxy forwards the request to the RealSubject (if needed)
5. **Response Handling** - The Proxy may post-process the response before returning it to the client

### Virtual Proxy Example Flow

When implementing lazy loading:
- The Proxy is created immediately (lightweight)
- The RealSubject is only instantiated when actually needed
- Subsequent calls may reuse the already-created RealSubject
- The client remains unaware of this optimization

## Advantages

✅ **Controlled Access** - Manage how and when the real object is accessed  
✅ **Performance Optimization** - Lazy initialization reduces memory footprint  
✅ **Security Enhancement** - Add authentication and authorization layers  
✅ **Separation of Concerns** - Keep additional functionality separate from business logic  
✅ **Transparency** - Client code doesn't need to know about the proxy  
✅ **Open/Closed Principle** - Add new proxies without modifying existing code

## Disadvantages

⚠️ **Increased Complexity** - Adds another layer to the architecture  
⚠️ **Potential Latency** - Extra indirection may introduce minor overhead  
⚠️ **Maintenance** - More classes to manage and maintain

## When to Use

Consider the Proxy Pattern when you need to:
- Defer expensive object creation until necessary
- Control access to sensitive objects or operations
- Add functionality to objects without modifying their code
- Represent remote objects in local contexts
- Implement caching for performance optimization
- Add logging or monitoring transparently

## When NOT to Use

Avoid the Proxy Pattern when:
- The overhead outweighs the benefits
- Direct access to the real object is simpler and sufficient
- The additional complexity is unjustified for your use case

## Real-World Applications

- **ORM Frameworks** - Hibernate uses proxies for lazy loading of entities
- **Web Services** - SOAP and REST clients often use proxies for remote services
- **Image Viewers** - Load high-resolution images only when displayed
- **Security Systems** - Protect sensitive resources with authorization checks
- **Logging Frameworks** - Intercept method calls for audit trails

## Key Takeaways

🔑 Both Proxy and RealSubject implement the same interface  
🔑 Client is unaware whether it's interacting with a Proxy or RealSubject  
🔑 Proxy controls creation, access, and lifecycle of the RealSubject  
🔑 Perfect for lazy initialization, security, caching, logging, and remote access  
🔑 Maintains the Open/Closed Principle by allowing extensions without modifications

## Related Patterns

- **Decorator** - Similar structure but focuses on adding responsibilities rather than controlling access
- **Adapter** - Changes interface, while Proxy maintains the same interface
- **Facade** - Simplifies complex subsystems, while Proxy controls access to a single object

---

*The Proxy Pattern is a powerful tool for managing object access and adding cross-cutting concerns without polluting your core business logic.*