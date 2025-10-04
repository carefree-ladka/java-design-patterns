---
title: 'Visitor Pattern'
description: 'A behavioral design pattern that lets you add new operations to objects without modifying their classes'
category: 'Design Patterns'
tags: ['behavioral', 'design-pattern', 'double-dispatch', 'polymorphism', 'separation-of-concerns']
---

# Visitor Pattern

## 📋 Overview

The **Visitor Pattern** is a behavioral design pattern that lets you add new operations to a group of objects **without modifying their classes**. It separates algorithms from the object structure on which they operate, making it easy to add new operations while keeping the objects unchanged.

<Alert>
  <AlertDescription>
    💡 **Key Insight**: Think of a tax inspector visiting different businesses. Each business stays the same, but the inspector applies different rules depending on the type of business. The businesses don't change - only the visitor's behavior does!
  </AlertDescription>
</Alert>

## 🎯 Intent

* Add new operations to existing object structures without modifying them
* Separate algorithms from the objects on which they operate
* Enable double dispatch to achieve operation polymorphism
* Follow the Open/Closed Principle for operations
* Collect related operations in a single class (the Visitor)

## 🔑 Key Concepts

### The Tax Inspector Analogy

Think of the Visitor Pattern like a **Tax Inspector Visiting Businesses**:

- Different businesses exist (Restaurant, Shop, Factory)
- A tax inspector visits each one
- The inspector applies different rules based on business type
- Businesses don't change their structure
- New inspectors (health, safety) can visit without changing businesses

## ✨ Core Components

<div className="grid grid-cols-1 md:grid-cols-2 gap-4 my-6">
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">1. Visitor Interface</h3>
    <p>Declares visit methods for each element type</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">2. Concrete Visitor</h3>
    <p>Implements operations to perform on each element type</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">3. Element Interface</h3>
    <p>Declares accept method that takes a visitor</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">4. Concrete Elements</h3>
    <p>Objects that can be "visited" by implementing accept</p>
  </div>
</div>

## 🎯 When to Use

### Ideal Scenarios

* **Multiple Operations**: Need to perform many unrelated operations on object structure
* **Stable Object Structure**: Object types rarely change, but operations change frequently
* **Clean Separation**: Want to separate operations from object classes
* **AST Traversal**: Working with tree structures (compilers, parsers)
* **Reporting/Export**: Need to generate different outputs from same data structure

### Problem Indicators

* Adding new operations requires modifying many classes
* Unrelated operations scattered across object classes
* Classes are cluttered with many different algorithms
* Need to perform operations on heterogeneous collections
* Want to avoid polluting domain classes with utility operations

## ✅ Benefits

### Advantages

* **Easy to Add Operations**: Create new visitor without changing elements
* **Open/Closed Principle**: Open for new operations, closed for modification
* **Single Responsibility**: Operations grouped in visitor classes
* **Related Operations Together**: All logic for one operation in one place
* **Double Dispatch**: Enables operation selection based on both visitor and element type
* **Clean Object Structure**: Keeps element classes focused on core behavior

### Trade-offs

* **Hard to Add Elements**: New element types require changes to all visitors
* **Breaks Encapsulation**: Visitors need access to element internals
* **Complexity**: More complex than simple polymorphism
* **Circular Dependencies**: Elements and visitors depend on each other
* **Not Always Intuitive**: Double dispatch can be confusing

## 🌍 Real-World Examples

### Compiler/Interpreter - AST Traversal

* Abstract Syntax Tree (AST) with various node types
* Visitors: Code generator, optimizer, type checker, pretty printer
* Node structure rarely changes
* Operations added frequently

### UI Component Trees

* Component hierarchy (Button, Panel, TextBox)
* Visitors: Renderer, accessibility checker, event handler, serializer
* UI components stay stable
* New operations needed for different purposes

### Document Processors

* Document structure (Paragraph, Image, Table)
* Visitors: PDF exporter, HTML converter, XML generator, word counter
* Document model remains consistent
* Multiple export formats needed

### File System Operations

* Files and directories
* Visitors: Size calculator, search, compression, backup
* File structure unchanging
* Various operations performed

### Shopping Cart Systems

* Product types (Book, Electronics, Clothing)
* Visitors: Tax calculator, shipping calculator, discount applier
* Product types stable
* Pricing rules change frequently

## 🔄 How It Works (Double Dispatch)

export const VisitorFlow = () => (
  <div className="bg-gray-50 p-6 rounded-lg my-6">
    <ol className="space-y-3">
      <li className="flex items-start">
        <span className="font-bold mr-3">1.</span>
        <span>Client calls <code className="bg-gray-200 px-1">element.accept(visitor)</code></span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">2.</span>
        <span><strong>Element</strong> calls <code className="bg-gray-200 px-1">visitor.visit(this)</code> (first dispatch)</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">3.</span>
        <span><strong>Visitor</strong> method is selected based on element's concrete type (second dispatch)</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">4.</span>
        <span><strong>Visitor</strong> performs operation specific to that element type</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">5.</span>
        <span>Visitor can access element's properties to perform operation</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">6.</span>
        <span>Process repeats for each element in the structure</span>
      </li>
    </ol>
  </div>
)

<VisitorFlow />

<Alert>
  <AlertDescription>
    🔍 **Double Dispatch Explained**: Regular polymorphism (single dispatch) selects a method based on the receiver's type. Double dispatch selects based on TWO types: the visitor type AND the element type. This is achieved through the accept/visit pattern.
  </AlertDescription>
</Alert>

## 🎨 Design Principles

### Followed Principles

* **Open/Closed Principle**: Open for new operations (visitors), closed for element modification
* **Single Responsibility**: Each visitor handles one specific operation
* **Separation of Concerns**: Algorithms separated from data structure
* **Don't Repeat Yourself**: Operation logic centralized in visitor

### Challenges

* **Dependency Inversion**: Elements depend on visitor interface
* **Encapsulation**: May require exposing element internals

## 🔄 Related Patterns

* **Composite Pattern**: Often used together - visitor traverses composite structures
* **Iterator Pattern**: Can be used to traverse elements before visiting
* **Strategy Pattern**: Visitor is like strategy but for multiple element types
* **Command Pattern**: Commands can be implemented as visitors

## 🆚 Visitor vs Similar Patterns

<div className="grid grid-cols-1 md:grid-cols-3 gap-6 my-6">
  <div className="border-2 border-blue-200 rounded-lg p-6 bg-blue-50">
    <h3 className="text-xl font-bold mb-4 text-blue-700">👤 Visitor</h3>
    <ul className="space-y-2 text-sm">
      <li><strong>Purpose:</strong> Add new operations easily</li>
      <li><strong>Flexibility:</strong> Hard to add new element types</li>
      <li><strong>Use Case:</strong> Stable structure, changing operations</li>
      <li><strong>Example:</strong> AST with multiple analysis passes</li>
    </ul>
  </div>
  <div className="border-2 border-purple-200 rounded-lg p-6 bg-purple-50">
    <h3 className="text-xl font-bold mb-4 text-purple-700">🎯 Strategy</h3>
    <ul className="space-y-2 text-sm">
      <li><strong>Purpose:</strong> Swap entire algorithms</li>
      <li><strong>Flexibility:</strong> Easy to add new strategies</li>
      <li><strong>Use Case:</strong> Single algorithm family</li>
      <li><strong>Example:</strong> Different sorting algorithms</li>
    </ul>
  </div>
  <div className="border-2 border-green-200 rounded-lg p-6 bg-green-50">
    <h3 className="text-xl font-bold mb-4 text-green-700">📋 Command</h3>
    <ul className="space-y-2 text-sm">
      <li><strong>Purpose:</strong> Encapsulate single request</li>
      <li><strong>Flexibility:</strong> Easy to add new commands</li>
      <li><strong>Use Case:</strong> Action queuing, undo/redo</li>
      <li><strong>Example:</strong> GUI button actions</li>
    </ul>
  </div>
</div>

<Alert>
  <AlertDescription>
    ⚡ **Key Differences**: Visitor = Easy to add operations, hard to add element types. Strategy = Easy to swap algorithms for single operation. Command = Encapsulates single action with context.
  </AlertDescription>
</Alert>

## 🎓 Best Practices

<Alert>
  <AlertDescription>
    <ul className="space-y-2 mt-2">
      <li>✓ Use when object structure is stable but operations change frequently</li>
      <li>✓ Name visitors descriptively based on their operation (DrawingVisitor, AreaVisitor)</li>
      <li>✓ Keep visitors focused on single operation or closely related operations</li>
      <li>✓ Consider return values from visit methods if needed</li>
      <li>✓ Use accept pattern consistently across all elements</li>
      <li>✓ Document element properties that visitors can access</li>
      <li>✓ Consider visitor base classes for shared functionality</li>
      <li>✓ Handle null/empty cases gracefully in visitors</li>
    </ul>
  </AlertDescription>
</Alert>

## 📊 Pattern Trade-off Analysis

<div className="grid grid-cols-1 md:grid-cols-2 gap-6 my-6">
  <div className="border-2 border-green-200 rounded-lg p-6 bg-green-50">
    <h3 className="text-xl font-bold mb-4 text-green-700">✅ When Visitor Shines</h3>
    <ul className="space-y-2">
      <li>• Object structure is stable</li>
      <li>• Many unrelated operations needed</li>
      <li>• Operations change more than structure</li>
      <li>• Want to group related operations</li>
      <li>• Working with tree/composite structures</li>
      <li>• Need different views of same data</li>
    </ul>
  </div>
  <div className="border-2 border-red-200 rounded-lg p-6 bg-red-50">
    <h3 className="text-xl font-bold mb-4 text-red-700">❌ When to Avoid</h3>
    <ul className="space-y-2">
      <li>• Object structure changes frequently</li>
      <li>• Only one or two operations needed</li>
      <li>• Simple polymorphism suffices</li>
      <li>• Strong encapsulation required</li>
      <li>• Team unfamiliar with pattern</li>
      <li>• Elements hide too much state</li>
    </ul>
  </div>
</div>

## 🎯 Common Use Cases

<div className="grid grid-cols-1 md:grid-cols-2 gap-4 my-6">
  <div className="border-l-4 border-blue-500 pl-4 bg-blue-50 p-4 rounded-r">
    <h4 className="font-bold mb-2">🔧 Compiler Design</h4>
    <p className="text-sm mb-2">AST nodes with multiple analysis passes</p>
    <p className="text-xs text-gray-600">Type checking, optimization, code generation</p>
  </div>
  <div className="border-l-4 border-green-500 pl-4 bg-green-50 p-4 rounded-r">
    <h4 className="font-bold mb-2">📄 Document Processing</h4>
    <p className="text-sm mb-2">Export to different formats</p>
    <p className="text-xs text-gray-600">PDF, HTML, XML, JSON exporters</p>
  </div>
  <div className="border-l-4 border-purple-500 pl-4 bg-purple-50 p-4 rounded-r">
    <h4 className="font-bold mb-2">🎨 Graphics Rendering</h4>
    <p className="text-sm mb-2">Render shapes in different ways</p>
    <p className="text-xs text-gray-600">Drawing, bounds calculation, hit testing</p>
  </div>
  <div className="border-l-4 border-orange-500 pl-4 bg-orange-50 p-4 rounded-r">
    <h4 className="font-bold mb-2">🛒 E-commerce</h4>
    <p className="text-sm mb-2">Calculate pricing for different products</p>
    <p className="text-xs text-gray-600">Tax, shipping, discounts, inventory</p>
  </div>
</div>

## 🔍 Understanding Double Dispatch

<div className="bg-gradient-to-r from-blue-50 to-purple-50 p-6 rounded-lg my-6 border-2 border-blue-200">
  <h3 className="text-lg font-bold mb-4">🎯 Why Double Dispatch Matters</h3>
  <div className="space-y-3 text-sm">
    <div>
      <strong>Problem:</strong> In most OOP languages, method calls are dispatched based on the receiver's type (single dispatch). This isn't enough when you need behavior based on TWO types.
    </div>
    <div>
      <strong>Solution:</strong> The Visitor pattern uses two method calls:
      <ol className="list-decimal ml-6 mt-2 space-y-1">
        <li><code>element.accept(visitor)</code> - dispatches on element type</li>
        <li><code>visitor.visit(element)</code> - dispatches on visitor type</li>
      </ol>
    </div>
    <div>
      <strong>Result:</strong> The correct operation is selected based on both the concrete element type AND the concrete visitor type!
    </div>
  </div>
</div>

## 💡 Real-World Example: AST Visitor

<div className="bg-gray-50 p-6 rounded-lg my-6">
  <h3 className="text-lg font-bold mb-4">🌳 Abstract Syntax Tree (AST) Traversal</h3>
  <div className="space-y-4">
    <div>
      <h4 className="font-semibold mb-2">Scenario: Mini Compiler</h4>
      <p className="text-sm">Expression tree: <code className="bg-gray-200 px-2 py-1 rounded">2 + 3 * 4</code></p>
    </div>
    <div>
      <h4 className="font-semibold mb-2">AST Nodes (Elements):</h4>
      <ul className="text-sm space-y-1 ml-4">
        <li>• NumberNode (leaf nodes: 2, 3, 4)</li>
        <li>• AddNode (represents +)</li>
        <li>• MultiplyNode (represents *)</li>
      </ul>
    </div>
    <div>
      <h4 className="font-semibold mb-2">Visitors (Operations):</h4>
      <ul className="text-sm space-y-1 ml-4">
        <li>• <strong>EvaluatorVisitor:</strong> Calculates result (14)</li>
        <li>• <strong>PrinterVisitor:</strong> Prints expression</li>
        <li>• <strong>OptimizerVisitor:</strong> Simplifies expression</li>
        <li>• <strong>TypeCheckerVisitor:</strong> Validates types</li>
      </ul>
    </div>
    <div className="bg-white p-4 rounded border">
      <p className="text-sm font-semibold mb-2">Benefits:</p>
      <ul className="text-sm space-y-1 ml-4">
        <li>✓ AST structure remains unchanged</li>
        <li>✓ Easy to add new passes (visitors)</li>
        <li>✓ Each visitor focused on one task</li>
        <li>✓ Same tree, multiple interpretations</li>
      </ul>
    </div>
  </div>
</div>

## 🚀 Advanced Techniques

### Visitor with Return Values

Visitors can return values by using generics or specific return types:

<div className="bg-gray-50 p-4 rounded-lg my-4 font-mono text-sm">
  interface Visitor&lt;T&gt; &#123;<br/>
  &nbsp;&nbsp;T visit(Circle circle);<br/>
  &nbsp;&nbsp;T visit(Rectangle rectangle);<br/>
  &#125;
</div>

### Composite + Visitor

Perfect combination for tree structures where visitors need to traverse hierarchies.

### Acyclic Visitor

Variant that eliminates circular dependencies between visitors and elements using more complex type system.

---

<Alert>
  <AlertDescription>
    **Remember**: The Visitor Pattern is about **separating operations from object structure**. Use it when you have a stable object structure but need to perform many different operations on it. Perfect for compilers, document processors, and any tree-traversal scenario!
  </AlertDescription>
</Alert>