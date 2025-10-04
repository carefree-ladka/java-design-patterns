# Flyweight Design Pattern

## Overview

The **Flyweight Pattern** is a structural design pattern that minimizes memory usage by sharing as much data as possible with similar objects. It achieves memory optimization by storing common state externally and sharing it among multiple objects, rather than storing redundant data in each object.

## Purpose

The Flyweight Pattern enables you to:
- Reduce memory consumption when dealing with large numbers of similar objects
- Share common data (intrinsic state) among multiple objects
- Support large numbers of fine-grained objects efficiently
- Separate object state into intrinsic (shared) and extrinsic (unique) components
- Improve application performance by reducing object creation overhead

## Core Concepts

### Intrinsic State (Shared)
- **Internal to the flyweight**
- Independent of context
- Stored in the flyweight object
- Immutable and shareable
- Examples: character font, tree texture, particle color

### Extrinsic State (Unique)
- **External to the flyweight**
- Depends on context
- Passed to flyweight methods
- Varies with each usage
- Examples: character position, tree location, particle coordinates

## Architecture

### Key Participants

1. **Flyweight** - Declares an interface through which flyweights can receive and act on extrinsic state
2. **ConcreteFlyweight** - Implements the Flyweight interface and stores intrinsic state (shared data)
3. **FlyweightFactory** - Creates and manages flyweight objects, ensures flyweights are shared properly
4. **Client** - Maintains references to flyweights and computes/stores extrinsic state

### Structure

```
Client → FlyweightFactory → ConcreteFlyweight (stores intrinsic state)
      ↓                    
   (stores extrinsic state)
```

The factory ensures that flyweights are shared, returning existing instances when possible.

## How It Works

### Core Mechanism

1. **State Separation**: Identify intrinsic (shareable) and extrinsic (unique) state
2. **Object Pooling**: Factory maintains a pool of flyweight objects
3. **Sharing**: Multiple clients share the same flyweight instances
4. **Context Passing**: Clients pass extrinsic state to flyweight methods when needed

### Workflow

1. **Client Request** - Client requests a flyweight from the factory
2. **Factory Check** - Factory checks if a flyweight with that intrinsic state exists
3. **Reuse or Create** - If exists, return existing instance; otherwise, create new one
4. **Operation** - Client invokes flyweight methods, passing extrinsic state
5. **Shared Processing** - Flyweight uses both intrinsic (stored) and extrinsic (passed) state

## Common Use Cases

### 1. Text Editors
Represent characters in a document where:
- **Intrinsic**: Font, style, size (shared among same characters)
- **Extrinsic**: Position, color in specific context

### 2. Game Development
Manage thousands of game objects:
- **Intrinsic**: Textures, meshes, animations (shared)
- **Extrinsic**: Position, velocity, health (unique per object)

### 3. Graphics Rendering
Render shapes and particles efficiently:
- **Intrinsic**: Shape type, texture, base color
- **Extrinsic**: Screen coordinates, rotation, scale

### 4. Forest Simulation
Render thousands of trees:
- **Intrinsic**: Tree type, mesh, texture (few types shared)
- **Extrinsic**: Position, age, height (unique per tree)

### 5. String Interning
Java String pool implementation:
- **Intrinsic**: String content (shared)
- **Extrinsic**: References from different parts of the code

### 6. Caching Systems
Cache frequently accessed data:
- **Intrinsic**: Cached data content
- **Extrinsic**: Access context, timestamps

## Advantages

✅ **Memory Efficiency** - Dramatically reduces memory footprint for large object counts  
✅ **Performance Improvement** - Fewer objects mean less garbage collection overhead  
✅ **Scalability** - Enables applications to handle massive numbers of objects  
✅ **Resource Sharing** - Multiple contexts benefit from shared resources  
✅ **Centralized Management** - Factory controls object lifecycle and sharing  
✅ **Reduced Object Creation** - Minimizes expensive object instantiation

## Disadvantages

⚠️ **Complexity** - Code becomes more complex with state separation  
⚠️ **Runtime Overhead** - Computing extrinsic state and passing it adds processing cost  
⚠️ **Thread Safety** - Shared objects require careful synchronization in multi-threaded environments  
⚠️ **Applicability Limited** - Only beneficial when many similar objects exist  
⚠️ **Testing Difficulty** - Shared state can make debugging more challenging  
⚠️ **Design Constraints** - Forces careful consideration of state separation

## Memory Savings Example

### Without Flyweight
- 1 million trees, each storing texture data (1MB per tree)
- Total memory: 1,000,000 MB = ~1 TB

### With Flyweight
- 10 tree types sharing textures (1MB × 10 = 10MB)
- 1 million position references (8 bytes × 1,000,000 = 8MB)
- Total memory: 18 MB (99.998% reduction!)

## When to Use

Consider the Flyweight Pattern when:
- Your application uses a large number of similar objects
- Storage costs are high due to object quantity
- Most object state can be made extrinsic
- Many groups of objects can share relatively few shared objects
- Application doesn't depend on object identity
- Memory optimization is a critical requirement

## When NOT to Use

Avoid the Flyweight Pattern when:
- You have few objects (overhead isn't justified)
- Most object state is extrinsic (little benefit from sharing)
- Object identity matters (flyweights are shared, not unique)
- The complexity outweighs the memory benefits
- State separation is unclear or forced

## Real-World Applications

### Java String Pool
Java automatically interns string literals, sharing identical strings across the application to save memory.

### Game Engines (Unity, Unreal)
Particle systems use flyweights to render thousands of particles efficiently by sharing textures and meshes.

### Web Browsers
DOM rendering engines use flyweights for text characters, sharing font and style information.

### Database Connection Pools
While not pure flyweights, connection pools share expensive database connections among multiple clients.

### GUI Frameworks
UI toolkits share common resources like fonts, colors, and icons across multiple widgets.

### Mobile Applications
Resource-constrained mobile apps use flyweights to manage memory efficiently for images and assets.

## Implementation Considerations

### Immutability is Key
Intrinsic state must be immutable to ensure safe sharing across multiple contexts.

### Factory Management
The factory is responsible for:
- Creating flyweights on demand
- Maintaining the flyweight pool
- Ensuring proper sharing (usually using a HashMap or similar structure)

### Thread Safety
When using flyweights in multi-threaded environments:
- Ensure flyweight factory is thread-safe
- Make intrinsic state immutable
- Be careful with mutable extrinsic state

### State Identification
Carefully analyze objects to determine:
- What can be shared (intrinsic)
- What must be unique (extrinsic)
- Trade-offs between memory and computational overhead

### Client Responsibility
Clients must:
- Store or compute extrinsic state
- Pass extrinsic state to flyweight methods
- Manage the context of flyweight usage

## Flyweight vs. Similar Patterns

### Flyweight vs. Singleton
- **Flyweight**: Multiple shared instances (one per unique intrinsic state)
- **Singleton**: Single global instance
- Flyweight has many shared instances; Singleton has exactly one

### Flyweight vs. Object Pool
- **Flyweight**: Shares immutable objects to save memory
- **Object Pool**: Reuses mutable objects to save creation cost
- Flyweight focuses on sharing; Pool focuses on reuse

### Flyweight vs. Prototype
- **Flyweight**: Shares existing objects
- **Prototype**: Creates new objects by cloning
- Flyweight shares; Prototype copies

## Performance Considerations

### Memory vs. CPU Trade-off
- **Memory Saved**: Reduced object storage
- **CPU Cost**: Computing and passing extrinsic state

### When It's Worth It
- Thousands or millions of objects
- Significant shared state
- Memory is the bottleneck

### When It's Not Worth It
- Few objects (hundreds or less)
- Minimal shared state
- CPU is already constrained

## Key Takeaways

🔑 Flyweight optimizes memory by sharing common data across objects  
🔑 Separates state into intrinsic (shared) and extrinsic (unique) components  
🔑 Factory manages object sharing and ensures proper reuse  
🔑 Intrinsic state must be immutable for safe sharing  
🔑 Most effective when dealing with large numbers of similar objects  
🔑 Trades computational overhead for memory efficiency  
🔑 Requires careful analysis to identify shareable state  
🔑 Critical for applications with strict memory constraints

## Design Principles Supported

- **Don't Repeat Yourself (DRY)**: Eliminates redundant data storage
- **Separation of Concerns**: Clearly separates shared and unique state
- **Resource Optimization**: Efficiently manages memory resources
- **Single Responsibility**: Flyweight handles shared state; client handles unique state

## Decision Checklist

Before implementing Flyweight, ask:
- ✓ Do I have many similar objects?
- ✓ Is memory a significant concern?
- ✓ Can I clearly separate intrinsic and extrinsic state?
- ✓ Is the intrinsic state immutable?
- ✓ Will the memory savings justify the added complexity?

If you answered yes to all questions, Flyweight is likely a good fit!

---

*The Flyweight Pattern is essential for building memory-efficient applications that handle large numbers of similar objects without compromising performance.*