---
title: 'Mediator Pattern'
description: 'A behavioral design pattern that encapsulates how objects interact through a central mediator'
category: 'Design Patterns'
tags: ['behavioral', 'design-pattern', 'software-architecture']
---

# Mediator Pattern

## 📋 Overview

The **Mediator Pattern** is a behavioral design pattern that defines an object (the Mediator) to encapsulate and coordinate how a set of objects interact with each other. Instead of objects communicating directly, they communicate through a central mediator, which significantly reduces coupling and makes complex interactions more manageable.

<Alert>
  <AlertDescription>
    💡 **Key Insight**: Think of it like an Air Traffic Controller - planes don't communicate directly with each other, they communicate with the tower, which coordinates everything.
  </AlertDescription>
</Alert>

## 🎯 Intent

* Define a centralized object that controls how a set of objects interact
* Eliminate direct dependencies between communicating objects
* Encapsulate interaction logic in one place rather than distributing it across multiple objects
* Promote loose coupling by preventing objects from referring to each other explicitly

## 🔑 Key Concepts

### The Air Traffic Controller Analogy

Think of the Mediator Pattern like an **Air Traffic Control Tower**:

- Planes (objects) don't communicate directly with each other
- All communication goes through the control tower (mediator)
- The tower coordinates all interactions and prevents collisions
- This centralized approach makes the system safer and more organized

## ✨ Core Components

<div className="grid grid-cols-1 md:grid-cols-2 gap-4 my-6">
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">1. Mediator</h3>
    <p>Interface that defines communication methods</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">2. Concrete Mediator</h3>
    <p>Implements coordination logic and maintains references to colleagues</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">3. Colleague</h3>
    <p>Objects that communicate through the mediator rather than directly</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">4. Concrete Colleague</h3>
    <p>Specific implementations that send and receive messages via the mediator</p>
  </div>
</div>

## 🎯 When to Use

### Ideal Scenarios

* **Complex Object Interactions**: Multiple objects interact in intricate ways
* **Chat Systems**: Users need to communicate with each other through a central server
* **UI Dialogs**: Multiple widgets need to coordinate their behavior
* **Workflow Systems**: Different components need to communicate in a controlled manner
* **Event Handling**: Multiple components respond to events without tight coupling

### Problem Indicators

* A "spaghetti mess" of object dependencies
* Objects directly referencing many other objects
* Difficult to understand who communicates with whom
* Changes to one object require changes to many others
* Complex communication protocols between objects

## ✅ Benefits

### Advantages

* **Reduces Coupling**: Objects don't need to know about each other directly
* **Centralized Control**: All communication logic in one place
* **Easier Maintenance**: Changes to interaction logic only affect the mediator
* **Simplified Object Protocols**: Objects have simpler interfaces
* **Reusability**: Colleague objects can be reused with different mediators
* **Flexibility**: Easy to change interaction logic without modifying colleagues

### Trade-offs

* The mediator itself can become complex if it handles too many interactions
* May become a "god object" if not designed carefully
* Can be harder to understand the overall system behavior

## 🌍 Real-World Examples

### Chat Applications

* Users send messages to a chat server (mediator)
* The server distributes messages to recipients
* Users don't need direct connections to each other

### Air Traffic Control

* Pilots communicate with the control tower
* The tower coordinates all aircraft movements
* Prevents planes from communicating directly (avoiding chaos)

### UI Dialog Systems

* Form fields, buttons, and controls interact through a dialog controller
* One field's change can trigger updates in other fields via the mediator
* The mediator enforces business rules and validation

### Online Auction Systems

* Bidders don't communicate directly with each other
* Auction system (mediator) coordinates all bids
* Ensures fair and organized bidding process

### Smart Home Systems

* Devices communicate through a central hub
* Hub coordinates interactions between devices
* Devices remain independent and loosely coupled

## 🔄 How It Works

export const MediatorFlow = () => (
  <div className="bg-gray-50 p-6 rounded-lg my-6">
    <ol className="space-y-3">
      <li className="flex items-start">
        <span className="font-bold mr-3">1.</span>
        <span><strong>Colleague objects</strong> are registered with the <strong>Mediator</strong></span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">2.</span>
        <span>When a colleague needs to communicate, it sends a message to the <strong>Mediator</strong></span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">3.</span>
        <span>The <strong>Mediator</strong> processes the message and determines which colleagues should receive it</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">4.</span>
        <span>The <strong>Mediator</strong> forwards appropriate messages to relevant colleagues</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">5.</span>
        <span>Colleagues respond through the <strong>Mediator</strong>, not directly to each other</span>
      </li>
    </ol>
  </div>
)

<MediatorFlow />

## 🎨 Design Principles

### Followed Principles

* **Single Responsibility**: Each colleague focuses on its own behavior
* **Open/Closed**: Easy to add new colleagues without modifying existing ones
* **Dependency Inversion**: Colleagues depend on the mediator abstraction
* **Low Coupling**: Objects are loosely connected through the mediator

## 🔄 Related Patterns

* **Observer Pattern**: Mediator coordinates communication; Observer broadcasts changes
* **Facade Pattern**: Mediator coordinates bidirectional communication; Facade provides simplified interface
* **Chain of Responsibility**: Can be used within a mediator to handle requests

## 🎓 Best Practices

<Alert>
  <AlertDescription>
    <ul className="space-y-2 mt-2">
      <li>✓ Keep the mediator focused on coordination, not business logic</li>
      <li>✓ Avoid making the mediator too complex</li>
      <li>✓ Consider breaking down large mediators into smaller, specialized ones</li>
      <li>✓ Document the interaction protocols clearly</li>
      <li>✓ Use dependency injection to provide mediator references to colleagues</li>
    </ul>
  </AlertDescription>
</Alert>

## 📊 Comparison with Direct Communication

<div className="grid grid-cols-1 md:grid-cols-2 gap-6 my-6">
  <div className="border-2 border-red-200 rounded-lg p-6 bg-red-50">
    <h3 className="text-xl font-bold mb-4 text-red-700">❌ Without Mediator</h3>
    <ul className="space-y-2">
      <li>• N objects need N×(N-1)/2 potential connections</li>
      <li>• Each object must know about all others it communicates with</li>
      <li>• Changes ripple through multiple objects</li>
    </ul>
  </div>
  <div className="border-2 border-green-200 rounded-lg p-6 bg-green-50">
    <h3 className="text-xl font-bold mb-4 text-green-700">✅ With Mediator</h3>
    <ul className="space-y-2">
      <li>• N objects need only N connections (to the mediator)</li>
      <li>• Objects only know about the mediator</li>
      <li>• Changes are localized to the mediator</li>
    </ul>
  </div>
</div>

---

<Alert>
  <AlertDescription>
    **Remember**: The Mediator Pattern is about **centralizing complex communications and control logic** to promote loose coupling and easier maintenance. Use it when direct object-to-object communication becomes unwieldy.
  </AlertDescription>
</Alert>