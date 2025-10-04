---
title: 'Template Method Pattern'
description: 'A behavioral design pattern that defines the skeleton of an algorithm in a base class while allowing subclasses to override specific steps'
category: 'Design Patterns'
tags: ['behavioral', 'design-pattern', 'inheritance', 'algorithm', 'code-reuse']
---

# Template Method Pattern

## 📋 Overview

The **Template Method Pattern** is a behavioral design pattern that defines the **skeleton of an algorithm** in a base class, but allows **subclasses to override specific steps** without changing the overall structure. This pattern promotes code reuse and enforces a consistent algorithm structure across multiple implementations.

<Alert>
  <AlertDescription>
    💡 **Key Insight**: It's like a recipe - "Here's the cooking process. You can swap some ingredients, but the steps remain the same." Making tea vs coffee uses the same steps (boil water, brew, pour, add condiments), but brewing and condiments differ!
  </AlertDescription>
</Alert>

## 🎯 Intent

* Define the skeleton of an algorithm in a base class operation
* Let subclasses redefine certain steps without changing the algorithm's structure
* Enforce a particular sequence of operations
* Promote code reuse by moving common logic to a base class
* Implement the "Hollywood Principle" - "Don't call us, we'll call you"

## 🔑 Key Concepts

### The Recipe Analogy

Think of the Template Method Pattern like a **Cooking Recipe**:

- The recipe defines the steps in order (the template)
- Some steps are fixed (boil water, pour into cup)
- Some steps vary by dish (brewing method, condiments)
- The overall cooking process stays consistent
- Subclasses customize only what's needed

## ✨ Core Components

<div className="grid grid-cols-1 md:grid-cols-2 gap-4 my-6">
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">1. Abstract Class</h3>
    <p>Defines the template method and algorithm skeleton</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">2. Template Method</h3>
    <p>Final method that defines the sequence of steps (often marked 'final')</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">3. Concrete Steps</h3>
    <p>Fixed operations implemented in the base class</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">4. Abstract/Hook Methods</h3>
    <p>Steps that subclasses must or can override</p>
  </div>
</div>

## 🎯 When to Use

### Ideal Scenarios

* **Common Algorithm Structure**: Multiple classes share the same algorithm flow but differ in details
* **Code Duplication**: Common logic is repeated across multiple classes
* **Enforce Sequence**: Need to ensure operations execute in a specific order
* **Framework Development**: Creating extensible frameworks where users customize specific steps
* **Invariant Behavior**: Some parts of algorithm must remain unchanged

### Problem Indicators

* Multiple classes with similar algorithms but slight variations
* Duplicated code across subclasses that could be extracted
* Need to control the order of operations
* Want to prevent subclasses from changing algorithm structure
* Similar workflows with different implementations

## ✅ Benefits

### Advantages

* **Code Reuse**: Common algorithm logic centralized in base class
* **Consistency**: Algorithm structure enforced across all implementations
* **Easy Extension**: Add new variations by creating new subclasses
* **Single Responsibility**: Base class handles algorithm flow; subclasses handle specifics
* **Protected Variation**: Fixed parts protected from modification
* **Inversion of Control**: Framework calls subclass methods, not vice versa

### Trade-offs

* Requires inheritance (can be limiting)
* Can be harder to understand the full flow
* Violates Liskov Substitution if not designed carefully
* May lead to class explosion with many variations
* Template method can become complex with many steps

## 🌍 Real-World Examples

### Beverage Preparation

* Steps: Boil water → Brew → Pour → Add condiments
* Tea and Coffee follow same process
* Only brewing and condiments differ
* Structure remains consistent

### Java Framework Examples

* `AbstractList`, `AbstractSet`, `AbstractMap` in Collections Framework
* `HttpServlet` with `doGet()`, `doPost()`, `doPut()` methods
* Spring's `JdbcTemplate` for database operations
* JUnit's test lifecycle methods

### Game Development

* Game loop: Initialize → Start → Update → Render → Cleanup
* Fixed sequence of operations
* Each game customizes update and render
* Initialization and cleanup follow standard patterns

### Data Processing Pipelines

* ETL process: Extract → Transform → Load
* Same pipeline structure for different data sources
* Extraction and transformation vary by source
* Loading process standardized

### Document Generation

* Process: Create structure → Add content → Format → Export
* Different document types (PDF, Word, HTML)
* Same generation workflow
* Format-specific customization

## 🔄 How It Works

export const TemplateMethodFlow = () => (
  <div className="bg-gray-50 p-6 rounded-lg my-6">
    <ol className="space-y-3">
      <li className="flex items-start">
        <span className="font-bold mr-3">1.</span>
        <span><strong>Client</strong> calls the template method on a concrete subclass instance</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">2.</span>
        <span><strong>Template Method</strong> executes the algorithm skeleton in defined order</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">3.</span>
        <span><strong>Fixed steps</strong> implemented in base class execute unchanged</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">4.</span>
        <span><strong>Abstract methods</strong> delegate to subclass implementations</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">5.</span>
        <span><strong>Hook methods</strong> (optional) allow subclasses to extend behavior</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">6.</span>
        <span>Algorithm completes with consistent structure but customized behavior</span>
      </li>
    </ol>
  </div>
)

<TemplateMethodFlow />

## 🎨 Method Types in Template Pattern

<div className="space-y-4 my-6">
  <div className="border-l-4 border-blue-500 pl-4 bg-blue-50 p-4 rounded-r">
    <h4 className="font-bold mb-2">Template Method</h4>
    <p className="text-sm mb-2">Defines the algorithm skeleton. Usually marked as <code className="bg-blue-100 px-1">final</code> to prevent overriding.</p>
    <p className="text-xs text-gray-600">Example: <code>prepareRecipe()</code></p>
  </div>
  <div className="border-l-4 border-green-500 pl-4 bg-green-50 p-4 rounded-r">
    <h4 className="font-bold mb-2">Concrete Methods</h4>
    <p className="text-sm mb-2">Fixed steps implemented in base class that don't need customization.</p>
    <p className="text-xs text-gray-600">Example: <code>boilWater()</code>, <code>pourInCup()</code></p>
  </div>
  <div className="border-l-4 border-purple-500 pl-4 bg-purple-50 p-4 rounded-r">
    <h4 className="font-bold mb-2">Abstract Methods</h4>
    <p className="text-sm mb-2">Required steps that subclasses must implement.</p>
    <p className="text-xs text-gray-600">Example: <code>brew()</code>, <code>addCondiments()</code></p>
  </div>
  <div className="border-l-4 border-orange-500 pl-4 bg-orange-50 p-4 rounded-r">
    <h4 className="font-bold mb-2">Hook Methods</h4>
    <p className="text-sm mb-2">Optional steps with default implementation that subclasses can override if needed.</p>
    <p className="text-xs text-gray-600">Example: <code>customerWantsCondiments()</code> returning <code>true</code></p>
  </div>
</div>

## 🎨 Design Principles

### Followed Principles

* **Don't Repeat Yourself (DRY)**: Common code in one place
* **Open/Closed**: Open for extension (new subclasses), closed for modification (template method)
* **Hollywood Principle**: "Don't call us, we'll call you" - framework calls your code
* **Single Responsibility**: Base class handles flow; subclasses handle specifics

## 🔄 Related Patterns

* **Strategy Pattern**: Similar but uses composition instead of inheritance
* **Factory Method**: Often used as a step in template method
* **Hook Pattern**: Template method uses hooks for optional customization
* **Abstract Factory**: Can be used to create objects in template method steps

## 🆚 Template Method vs Strategy Pattern

<div className="grid grid-cols-1 md:grid-cols-2 gap-6 my-6">
  <div className="border-2 border-blue-200 rounded-lg p-6 bg-blue-50">
    <h3 className="text-xl font-bold mb-4 text-blue-700">📝 Template Method</h3>
    <ul className="space-y-2">
      <li><strong>Structure:</strong> Uses inheritance</li>
      <li><strong>Control:</strong> Base class controls algorithm structure</li>
      <li><strong>Customization:</strong> Subclasses override steps</li>
      <li><strong>Flexibility:</strong> Fixed at compile-time</li>
      <li><strong>Purpose:</strong> Code reuse & enforcing structure</li>
      <li><strong>Example:</strong> Beverage preparation process</li>
    </ul>
  </div>
  <div className="border-2 border-purple-200 rounded-lg p-6 bg-purple-50">
    <h3 className="text-xl font-bold mb-4 text-purple-700">🎯 Strategy Pattern</h3>
    <ul className="space-y-2">
      <li><strong>Structure:</strong> Uses composition</li>
      <li><strong>Control:</strong> Client chooses strategy</li>
      <li><strong>Customization:</strong> Swap entire algorithm</li>
      <li><strong>Flexibility:</strong> Can change at runtime</li>
      <li><strong>Purpose:</strong> Algorithm interchangeability</li>
      <li><strong>Example:</strong> Different payment methods</li>
    </ul>
  </div>
</div>

<Alert>
  <AlertDescription>
    ⚡ **Key Difference**: Template Method uses inheritance with base class controlling structure. Strategy Pattern uses composition with algorithms chosen at runtime. Use Template Method when algorithm structure is fixed; use Strategy when you need runtime flexibility.
  </AlertDescription>
</Alert>

## 🎓 Best Practices

<Alert>
  <AlertDescription>
    <ul className="space-y-2 mt-2">
      <li>✓ Make the template method <code>final</code> to prevent overriding</li>
      <li>✓ Use descriptive names for abstract methods</li>
      <li>✓ Keep the number of steps manageable (3-7 is ideal)</li>
      <li>✓ Document the algorithm flow clearly in comments</li>
      <li>✓ Use hook methods for optional customization points</li>
      <li>✓ Make concrete methods <code>private</code> or <code>protected</code> as appropriate</li>
      <li>✓ Consider using default implementations for hooks</li>
      <li>✓ Avoid making template methods too complex</li>
    </ul>
  </AlertDescription>
</Alert>

## 📊 Before and After Template Method

<div className="grid grid-cols-1 md:grid-cols-2 gap-6 my-6">
  <div className="border-2 border-red-200 rounded-lg p-6 bg-red-50">
    <h3 className="text-xl font-bold mb-4 text-red-700">❌ Without Template Method</h3>
    <ul className="space-y-2">
      <li>• Duplicated code across multiple classes</li>
      <li>• Algorithm structure repeated everywhere</li>
      <li>• Hard to maintain consistent flow</li>
      <li>• Changes require updates in multiple places</li>
      <li>• No guarantee of correct sequence</li>
      <li>• Difficult to add new variations</li>
    </ul>
  </div>
  <div className="border-2 border-green-200 rounded-lg p-6 bg-green-50">
    <h3 className="text-xl font-bold mb-4 text-green-700">✅ With Template Method</h3>
    <ul className="space-y-2">
      <li>• Common code centralized in base class</li>
      <li>• Algorithm structure defined once</li>
      <li>• Consistent flow enforced automatically</li>
      <li>• Changes in one place affect all subclasses</li>
      <li>• Sequence guaranteed by template method</li>
      <li>• Easy to add variations via subclasses</li>
    </ul>
  </div>
</div>

## 🔧 Implementation Variations

### With Hook Methods

Hook methods provide optional customization points with default behavior:

<div className="bg-gray-50 p-4 rounded-lg my-4">
  <p className="font-mono text-sm">
    <strong>Base class includes:</strong><br/>
    - <code>customerWantsCondiments()</code> returns <code>true</code> by default<br/>
    - Subclasses can override to return <code>false</code> and skip condiments
  </p>
</div>

### Advantages of Hooks

* Provide extension points without forcing subclasses to override
* Allow subclasses to "hook into" algorithm at specific points
* Enable optional behavior with sensible defaults
* Keep subclass implementations minimal

## 💡 Common Use Cases

<div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 my-6">
  <div className="border rounded-lg p-4 bg-gray-50">
    <h4 className="font-bold mb-2">🎮 Game Engines</h4>
    <p className="text-sm">Initialize → Load → Update Loop → Cleanup</p>
  </div>
  <div className="border rounded-lg p-4 bg-gray-50">
    <h4 className="font-bold mb-2">🌐 Web Frameworks</h4>
    <p className="text-sm">Request parsing → Authentication → Processing → Response</p>
  </div>
  <div className="border rounded-lg p-4 bg-gray-50">
    <h4 className="font-bold mb-2">📊 Data Processing</h4>
    <p className="text-sm">Read → Validate → Transform → Write</p>
  </div>
  <div className="border rounded-lg p-4 bg-gray-50">
    <h4 className="font-bold mb-2">🧪 Testing Frameworks</h4>
    <p className="text-sm">Setup → Execute → Assert → Teardown</p>
  </div>
  <div className="border rounded-lg p-4 bg-gray-50">
    <h4 className="font-bold mb-2">📝 Document Processing</h4>
    <p className="text-sm">Parse → Validate → Process → Export</p>
  </div>
  <div className="border rounded-lg p-4 bg-gray-50">
    <h4 className="font-bold mb-2">🔐 Authentication</h4>
    <p className="text-sm">Validate → Authenticate → Authorize → Grant Access</p>
  </div>
</div>

## 🎯 Design Considerations

### When Template Method Shines

* Algorithm structure is stable and unlikely to change
* Multiple variations share significant common code
* Need to enforce sequence of operations
* Building frameworks for others to extend

### When to Consider Alternatives

* Algorithm structure varies significantly between implementations
* Need runtime flexibility to change algorithms
* Prefer composition over inheritance
* Working in languages without inheritance support

---

<Alert>
  <AlertDescription>
    **Remember**: The Template Method Pattern is about **defining a fixed algorithm structure** while allowing customization of specific steps. Use it when you have a stable algorithm skeleton with varying implementations of individual steps.
  </AlertDescription>
</Alert>