---
title: 'State Pattern'
description: 'A behavioral design pattern that allows objects to change behavior when their internal state changes'
category: 'Design Patterns'
tags: ['behavioral', 'design-pattern', 'state-management', 'polymorphism']
---

# State Pattern

## 📋 Overview

The **State Pattern** is a behavioral design pattern that allows an object to change its **behavior** when its **internal state** changes. Instead of using complex `if/else` or `switch` statements throughout your code, you encapsulate states into **separate classes**, making the code cleaner, more maintainable, and easier to extend.

<Alert>
  <AlertDescription>
    💡 **Key Insight**: Think of a fan with states: Off, Low, Medium, High. Pressing the button changes the state and the behavior accordingly. Each state knows what comes next!
  </AlertDescription>
</Alert>

## 🎯 Intent

* Allow an object to alter its behavior when its internal state changes
* Eliminate complex conditional statements for state-dependent behavior
* Encapsulate state-specific logic in separate, independent classes
* Make state transitions explicit and manageable
* Enable the object to appear as if it changed its class

## 🔑 Key Concepts

### The Fan Control Analogy

Think of the State Pattern like a **Multi-Speed Fan**:

- The fan has distinct states: Off, Low, Medium, High
- Pressing the button transitions between states in order
- Each state produces different behavior (fan speed)
- The fan "remembers" its current state
- State transitions follow specific rules

## ✨ Core Components

<div className="grid grid-cols-1 md:grid-cols-2 gap-4 my-6">
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">1. State Interface</h3>
    <p>Defines methods that all concrete states must implement</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">2. Concrete States</h3>
    <p>Implement state-specific behavior and handle transitions</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">3. Context</h3>
    <p>Maintains current state and delegates behavior to it</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">4. State Transitions</h3>
    <p>Logic that determines how and when states change</p>
  </div>
</div>

## 🎯 When to Use

### Ideal Scenarios

* **State-Dependent Behavior**: Object's behavior varies significantly based on its state
* **Complex Conditionals**: Large `if-else` or `switch` statements controlling behavior
* **State Transitions**: Well-defined state machines with clear transition rules
* **Encapsulation**: State-specific logic should be isolated in separate classes
* **Extensibility**: Need to add new states without modifying existing code

### Problem Indicators

* Massive conditional statements based on object state
* State-related behavior scattered across multiple methods
* Adding new states requires changes in many places
* Difficult to understand current state and possible transitions
* Code duplication across different state checks

## ✅ Benefits

### Advantages

* **Eliminates Conditionals**: Removes large `if-else` or `switch` statements
* **Single Responsibility**: Each state class handles one specific state
* **Open/Closed Principle**: Easy to add new states without modifying existing code
* **Cleaner Code**: State-specific logic is encapsulated in separate classes
* **Explicit Transitions**: State changes are clear and traceable
* **Easier Testing**: Each state can be tested independently

### Trade-offs

* Increases number of classes in the system
* Can be overkill for simple state machines
* State transition logic might be distributed across states
* Requires careful design of state interface

## 🌍 Real-World Examples

### Traffic Light System

* States: Red, Yellow, Green
* Each state knows the next state in sequence
* State-specific behavior (stop, caution, go)
* Automatic transitions based on timer

### Media Player

* States: Playing, Paused, Stopped
* Different behavior for play/pause/stop buttons
* State-specific UI updates
* Transitions based on user actions

### ATM Machine

* States: NoCard, HasCard, PinEntered, OutOfCash
* Each state allows different operations
* Security through state-controlled access
* Clear transition rules between states

### TCP Connection

* States: Closed, Listen, Established, CloseWait
* Network protocol state management
* Different handling for packets in each state
* RFC-defined state transitions

### Order Processing System

* States: Pending, Confirmed, Shipped, Delivered, Cancelled
* Different operations available in each state
* Business logic encapsulated in states
* Audit trail through state changes

## 🔄 How It Works

export const StateFlow = () => (
  <div className="bg-gray-50 p-6 rounded-lg my-6">
    <ol className="space-y-3">
      <li className="flex items-start">
        <span className="font-bold mr-3">1.</span>
        <span><strong>Context</strong> maintains a reference to a <strong>Concrete State</strong> object</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">2.</span>
        <span>Client calls a method on the <strong>Context</strong></span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">3.</span>
        <span><strong>Context</strong> delegates the call to its current <strong>State</strong> object</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">4.</span>
        <span>The <strong>State</strong> executes state-specific behavior</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">5.</span>
        <span>If needed, the <strong>State</strong> triggers a transition to another state</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">6.</span>
        <span><strong>Context</strong> updates its current state reference</span>
      </li>
    </ol>
  </div>
)

<StateFlow />

## 🎨 Design Principles

### Followed Principles

* **Single Responsibility**: Each state class handles one state's behavior
* **Open/Closed**: New states can be added without modifying existing ones
* **Polymorphism**: Context works with state interface, not concrete states
* **Encapsulation**: State-specific details are hidden within state classes

## 🔄 Related Patterns

* **Strategy Pattern**: Similar structure but different intent (see comparison below)
* **Flyweight Pattern**: Can be used to share state objects
* **Singleton Pattern**: Often used for state objects that have no internal data
* **Observer Pattern**: Can notify observers when state changes

## 🆚 State vs Strategy Pattern

<div className="grid grid-cols-1 md:grid-cols-2 gap-6 my-6">
  <div className="border-2 border-blue-200 rounded-lg p-6 bg-blue-50">
    <h3 className="text-xl font-bold mb-4 text-blue-700">🔄 State Pattern</h3>
    <ul className="space-y-2">
      <li><strong>Purpose:</strong> Manage state transitions</li>
      <li><strong>Control:</strong> Context manages state changes</li>
      <li><strong>Transitions:</strong> States know about each other</li>
      <li><strong>Focus:</strong> Object behavior changes with state</li>
      <li><strong>Example:</strong> Traffic light cycling through colors</li>
    </ul>
  </div>
  <div className="border-2 border-purple-200 rounded-lg p-6 bg-purple-50">
    <h3 className="text-xl font-bold mb-4 text-purple-700">🎯 Strategy Pattern</h3>
    <ul className="space-y-2">
      <li><strong>Purpose:</strong> Choose algorithms</li>
      <li><strong>Control:</strong> Client selects strategy</li>
      <li><strong>Transitions:</strong> Strategies are independent</li>
      <li><strong>Focus:</strong> Interchangeable algorithms</li>
      <li><strong>Example:</strong> Selecting payment method</li>
    </ul>
  </div>
</div>

<Alert>
  <AlertDescription>
    ⚡ **Key Difference**: In the State Pattern, state transitions are controlled by the Context or States themselves. In the Strategy Pattern, the client explicitly chooses which strategy to use.
  </AlertDescription>
</Alert>

## 🎓 Best Practices

<Alert>
  <AlertDescription>
    <ul className="space-y-2 mt-2">
      <li>✓ Keep state interface focused on essential operations</li>
      <li>✓ Consider using enums or constants to identify states</li>
      <li>✓ Document valid state transitions clearly</li>
      <li>✓ Consider using Flyweight pattern if states have no instance variables</li>
      <li>✓ Handle invalid state transitions gracefully</li>
      <li>✓ Consider centralized vs distributed transition logic based on complexity</li>
      <li>✓ Use state diagrams to visualize state machine before implementation</li>
    </ul>
  </AlertDescription>
</Alert>

## 📊 Before and After State Pattern

<div className="grid grid-cols-1 md:grid-cols-2 gap-6 my-6">
  <div className="border-2 border-red-200 rounded-lg p-6 bg-red-50">
    <h3 className="text-xl font-bold mb-4 text-red-700">❌ Without State Pattern</h3>
    <ul className="space-y-2">
      <li>• Large if-else/switch statements everywhere</li>
      <li>• State logic scattered across methods</li>
      <li>• Hard to add new states</li>
      <li>• Difficult to understand state transitions</li>
      <li>• Tight coupling between context and state logic</li>
      <li>• Hard to test individual states</li>
    </ul>
  </div>
  <div className="border-2 border-green-200 rounded-lg p-6 bg-green-50">
    <h3 className="text-xl font-bold mb-4 text-green-700">✅ With State Pattern</h3>
    <ul className="space-y-2">
      <li>• Clean, maintainable code structure</li>
      <li>• State logic encapsulated in classes</li>
      <li>• Easy to add new states</li>
      <li>• Clear, explicit state transitions</li>
      <li>• Loose coupling through polymorphism</li>
      <li>• Each state easily testable</li>
    </ul>
  </div>
</div>

## 🎯 State Transition Management

### Two Approaches

<div className="space-y-4 my-6">
  <div className="border-l-4 border-blue-500 pl-4 bg-blue-50 p-4 rounded-r">
    <h4 className="font-bold mb-2">1. Context-Controlled Transitions</h4>
    <p className="mb-2">The Context class manages all state transitions.</p>
    <p className="text-sm"><strong>Pros:</strong> Centralized transition logic, easier to understand flow</p>
    <p className="text-sm"><strong>Cons:</strong> Context needs to know about all states</p>
  </div>
  <div className="border-l-4 border-green-500 pl-4 bg-green-50 p-4 rounded-r">
    <h4 className="font-bold mb-2">2. State-Controlled Transitions</h4>
    <p className="mb-2">Each State class determines its own transitions.</p>
    <p className="text-sm"><strong>Pros:</strong> More flexible, states are self-contained</p>
    <p className="text-sm"><strong>Cons:</strong> Transition logic distributed, states coupled to each other</p>
  </div>
</div>

## 🎭 Common State Pattern Variations

### State Machine Types

<div className="grid grid-cols-1 md:grid-cols-3 gap-4 my-6">
  <div className="border rounded-lg p-4 bg-gray-50">
    <h4 className="font-bold mb-2">Finite State Machine</h4>
    <p className="text-sm">Fixed number of states with defined transitions</p>
  </div>
  <div className="border rounded-lg p-4 bg-gray-50">
    <h4 className="font-bold mb-2">Hierarchical State Machine</h4>
    <p className="text-sm">States can contain sub-states</p>
  </div>
  <div className="border rounded-lg p-4 bg-gray-50">
    <h4 className="font-bold mb-2">Concurrent State Machine</h4>
    <p className="text-sm">Multiple independent states active simultaneously</p>
  </div>
</div>

## 💡 Implementation Tips

### Code Organization

* Create a dedicated package/folder for state classes
* Use consistent naming: `[StateName]State` (e.g., `PlayingState`, `PausedState`)
* Consider using factory methods for state creation
* Document state transition diagrams in code comments or separate docs

### Error Handling

* Define behavior for invalid state transitions
* Consider using exceptions for illegal state changes
* Log state transitions for debugging
* Validate state preconditions before transitions

---

<Alert>
  <AlertDescription>
    **Remember**: The State Pattern is about **encapsulating state-specific behavior** in separate classes and making state transitions explicit. Use it when an object's behavior depends heavily on its state and you want to eliminate complex conditionals.
  </AlertDescription>
</Alert>