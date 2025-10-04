# Composite Pattern

## Overview
The **Composite Pattern** is a structural design pattern that allows you to compose objects into **tree structures** to represent part-whole hierarchies. It lets clients treat **individual objects** and **compositions of objects** uniformly.

In simpler terms: it allows you to work with both single items and groups of items in the same way.

## Real-Life Analogy
Think of a **company organization chart**:
- **Individual Contributors** (developers, designers) are leaf nodes - they don't manage anyone
- **Managers** are also employees, but they have subordinates under them
- **Senior Managers** manage other managers, who in turn manage individual contributors

The key insight: whether you're dealing with a single employee or an entire department, you can perform operations like "show details" or "calculate salary" in the same way. The pattern handles the complexity of traversing the hierarchy.

## Structure
The pattern consists of three key components:

1. **Component** - Common interface for both simple and complex objects
2. **Leaf** - Represents end objects with no children (e.g., Developer, Designer)
3. **Composite** - Contains children, which can be either Leaf or other Composites (e.g., Manager)

```
         Component
          /      \
       Leaf    Composite
                   |
                Children[]
```

## How It Works
- The **Component** interface defines operations common to both simple and complex objects
- **Leaf** objects implement the Component interface but have no children
- **Composite** objects implement the Component interface and maintain a collection of child Components
- When you call an operation on a Composite, it typically delegates to all its children (recursive behavior)
- Clients interact with all objects through the Component interface, treating them uniformly

## When to Use the Composite Pattern

### ✅ Use When:
- You need to represent **part-whole hierarchies** of objects
- You want clients to **treat individual objects and compositions uniformly**
- Your data forms a **tree structure** naturally
- You need to perform operations recursively on tree structures
- You want to ignore the difference between compositions of objects and individual objects

### ❌ Avoid When:
- Your object structure is not hierarchical
- You have vastly different operations for different object types
- The tree structure is very simple and doesn't justify the added complexity
- Performance is critical and the recursive nature causes issues

## Benefits
- **Uniformity** - Treat individual objects and compositions the same way
- **Simplifies Client Code** - Clients don't need to know if they're dealing with a leaf or composite
- **Easier to Add New Components** - New leaf or composite types can be added without changing existing code
- **Natural Representation** - Intuitively represents hierarchical structures
- **Flexibility** - Easy to build complex trees from simple components
- **Open/Closed Principle** - Can introduce new element types without breaking existing code

## Drawbacks
- **Overly General Design** - Can make it harder to restrict what components can be added
- **Type Safety** - May be difficult to restrict components of a composite to specific types
- **Complexity** - Adds complexity when the hierarchy is simple

## Real-World Examples

### 1. File System
- **Component**: FileSystemItem
- **Leaf**: File
- **Composite**: Folder (contains files and other folders)

Operations like "calculate size" or "display" work uniformly on both files and folders.

### 2. Graphic Drawing Systems
- **Component**: Graphic
- **Leaf**: Line, Circle, Rectangle
- **Composite**: CompositeGraphic (group of shapes)

You can draw individual shapes or groups of shapes using the same interface.

### 3. GUI Components
- **Component**: UIComponent
- **Leaf**: Button, TextField, Label
- **Composite**: Panel, Window (contains other UI components)

You can render individual widgets or entire panels of widgets uniformly.

### 4. Menu Systems
- **Component**: MenuComponent
- **Leaf**: MenuItem
- **Composite**: Menu (contains menu items and submenus)

### 5. Mathematical Expressions
- **Component**: Expression
- **Leaf**: Number
- **Composite**: Operation (addition, multiplication, etc.)

Example: `(5 + 3) * 2` is a composite of numbers and operations.

### 6. Company Organization
- **Component**: Employee
- **Leaf**: Individual Contributor
- **Composite**: Manager (manages other employees)

### 7. XML/HTML DOM
- **Component**: Node
- **Leaf**: TextNode
- **Composite**: Element (contains other nodes)

## Key Characteristics

### Recursive Composition
The power of the Composite Pattern lies in its recursive nature:
- A Composite can contain Leaves
- A Composite can contain other Composites
- Operations propagate down the tree structure automatically

### Transparent vs Safe Composite
**Transparent Composite**:
- Child management methods (add, remove) are in the Component interface
- Uniform interface but leaf nodes have meaningless operations

**Safe Composite**:
- Child management methods only in Composite class
- Type-safe but clients must distinguish between leaves and composites

## Design Considerations

### When Designing Your Hierarchy:
1. **Define the Component interface** carefully - what operations make sense for all nodes?
2. **Consider child management** - where should add/remove methods live?
3. **Handle parent references** - should children know their parents?
4. **Ordering of children** - does the order matter?
5. **Caching** - should composites cache results of operations?

### Common Operations:
- Add/Remove child components
- Get child components
- Execute operations recursively
- Find/search within the tree
- Iterate over children

## Composite vs Decorator Pattern

| Aspect | Composite Pattern | Decorator Pattern |
|--------|------------------|-------------------|
| **Purpose** | Represent part-whole hierarchies | Add responsibilities to objects dynamically |
| **Structure** | Tree structure with multiple children | Typically wraps a single object |
| **Relationship** | Has-a (aggregation) | Is-a (inheritance) + Has-a |
| **Focus** | Managing groups of objects | Enhancing individual objects |

## Summary
The Composite Pattern is your go-to solution when dealing with **tree structures** where you want to treat individual objects and compositions uniformly. It shines in scenarios like file systems, UI component hierarchies, and organizational structures.

**Core Principle**: Whether you're working with a single leaf or an entire tree, the interface remains the same. The pattern handles the complexity of recursive operations, making your client code simpler and more maintainable.

Think of it as Russian nesting dolls (Matryoshka) - each doll can contain smaller dolls, but you interact with all of them the same way, regardless of whether they contain others or not.