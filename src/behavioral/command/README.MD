# Command Design Pattern

## Overview

The **Command Pattern** is a behavioral design pattern that encapsulates a request as an object, thereby allowing you to parameterize clients with different requests, queue or log requests, and support undoable operations. It decouples the object that invokes the operation from the one that knows how to perform it.

## Purpose

The Command Pattern enables you to:
- Encapsulate requests as objects with all necessary information
- Decouple the sender of a request from its receiver
- Support undo and redo operations
- Queue, log, or schedule requests for later execution
- Compose commands into macro commands (composite commands)
- Parameterize objects with operations
- Support transactions and rollback mechanisms

## Real-Life Analogies

### TV Remote Control
Each button on a remote is a command (power, volume up, channel change). The remote doesn't know how the TV works internally - it just invokes commands. You can press buttons in any order, and the remote remains the same.

### Restaurant Order System
A waiter takes your order (command) and gives it to the kitchen (receiver). The order slip encapsulates all the details. Orders can be queued, prioritized, or cancelled before execution.

### Text Editor
Every action (type, delete, format) is a command. The undo stack stores executed commands, allowing you to reverse operations. Redo re-executes previously undone commands.

### Smart Home Automation
Voice commands ("Alexa, turn on the lights") are encapsulated as command objects that control various devices without the assistant knowing device implementation details.

## Architecture

### Key Participants

1. **Command (Interface)** - Declares an interface for executing operations, typically with an `execute()` method
2. **ConcreteCommand** - Implements the Command interface and binds a Receiver with an action
3. **Receiver** - The object that knows how to perform the actual work
4. **Invoker** - Asks the command to carry out the request without knowing implementation details
5. **Client** - Creates ConcreteCommand objects and sets their Receivers

### Structure

```
Client → creates → ConcreteCommand (holds Receiver reference)
                         ↓
                    implements Command
                         ↓
Invoker → stores/executes → Command.execute()
                                ↓
                          Receiver.action()
```

The Invoker triggers command execution, and the command delegates to its Receiver.

## How It Works

### Core Mechanism

1. **Command Creation**: Client creates a command object and binds it to a receiver
2. **Command Assignment**: Client assigns the command to an invoker
3. **Invocation**: Invoker calls the command's `execute()` method
4. **Delegation**: Command delegates the request to the receiver
5. **Execution**: Receiver performs the actual work

### Request Flow

```
Client → Command → Invoker → execute() → Receiver → action()
```

The command acts as a middle layer, decoupling the invoker from the receiver.

## Common Use Cases

### 1. Undo/Redo Functionality
Text editors, graphics applications, and IDEs use command pattern to maintain command history and support undo/redo operations.

### 2. GUI Buttons and Menu Items
UI frameworks use commands to handle button clicks and menu selections, decoupling UI components from business logic.

### 3. Transaction Systems
Database transactions, financial operations, and distributed systems use commands to implement atomic operations with rollback capabilities.

### 4. Task Scheduling and Queuing
Job schedulers, thread pools, and message queues encapsulate tasks as command objects for delayed or asynchronous execution.

### 5. Macro Recording
Office applications and automation tools record user actions as commands that can be replayed later.

### 6. Remote Procedure Calls (RPC)
Network communication systems encapsulate remote operations as command objects for transmission.

### 7. Wizard and Multi-Step Processes
Multi-step workflows store each step as a command, allowing forward/backward navigation and validation.

### 8. Game Input Systems
Game engines use commands to handle player input (move, jump, attack), enabling input remapping and replay functionality.

## Advantages

✅ **Decoupling** - Separates object that invokes operation from the one that performs it  
✅ **Undo/Redo Support** - Easily implement reversible operations by storing command history  
✅ **Queuing and Logging** - Commands can be queued for later execution or logged for audit trails  
✅ **Macro Commands** - Combine multiple commands into composite commands  
✅ **Open/Closed Principle** - Add new commands without changing existing code  
✅ **Flexibility** - Parameterize objects with operations at runtime  
✅ **Testability** - Commands can be tested independently

## Disadvantages

⚠️ **Increased Classes** - Creates many small command classes  
⚠️ **Complexity** - Adds extra layers of indirection  
⚠️ **Memory Overhead** - Storing command history for undo can consume significant memory  
⚠️ **State Management** - Complex when commands need to maintain state  
⚠️ **Receiver Coupling** - Commands are coupled to their receivers

## When to Use

Consider the Command Pattern when:
- You want to parameterize objects with operations
- You need to queue, schedule, or log requests
- You need to support undo/redo operations
- You want to decouple the requester from the executor
- You need to support transactions with rollback capability
- You're building GUI applications with actions triggered by multiple sources
- You want to implement callback functionality in object-oriented way

## When NOT to Use

Avoid the Command Pattern when:
- Simple direct method calls suffice
- You don't need undo, queuing, or logging capabilities
- The overhead of command objects is unjustified
- Operations are trivial and don't benefit from encapsulation

## Real-World Applications

### Java Swing / AWT
Action listeners and actions in Java GUI frameworks are implementations of the Command pattern.

### Spring Framework
Spring's `@Command` annotation and command bus implementations facilitate CQRS (Command Query Responsibility Segregation) architectures.

### Thread Pools (Runnable/Callable)
Java's `Runnable` and `Callable` interfaces are examples of Command pattern - they encapsulate operations for execution by thread pools.

### Git Version Control
Git commands (commit, push, pull, revert) encapsulate operations and maintain history for undoing changes.

### Text Editors (VSCode, IntelliJ)
Every user action is a command that can be undone, redone, or recorded in macros.

### Game Engines (Unity, Unreal)
Input systems and replay functionality use command pattern to record and playback player actions.

## Implementation Variations

### Command with Undo
Add an `undo()` method to the Command interface to reverse operations.

### Macro Commands (Composite Commands)
Create composite commands that execute multiple commands in sequence.

### Command Queue
Store commands in a queue for sequential or prioritized execution.

### Command History
Maintain a stack of executed commands to support undo/redo functionality.

### Asynchronous Commands
Execute commands asynchronously using threads or async/await patterns.

### Transactional Commands
Implement commands with commit/rollback semantics for database-like operations.

## Undo/Redo Implementation

### Basic Undo Support
Commands store previous state and implement an `undo()` method to restore it.

### Command History Stack
Maintain two stacks: one for executed commands (undo stack) and one for undone commands (redo stack).

### Memento Pattern Integration
Combine Command pattern with Memento pattern to save and restore object states.

## Best Practices

### Keep Commands Focused
Each command should do one thing well. Avoid creating "god commands" that do too much.

### Immutable Commands
Make commands immutable when possible to ensure thread safety and predictable behavior.

### Null Object Command
Implement a "do nothing" command to avoid null checks in invokers.

### Command Factory
Use factory pattern to create commands, especially when you have many command types.

### Error Handling
Implement robust error handling in commands and consider how failures affect undo operations.

### Resource Management
Be mindful of resources (memory, connections) when storing command history for undo.

### Command Naming
Use clear, action-oriented names for commands (SaveDocumentCommand, DeleteUserCommand).

## Command vs. Similar Patterns

### Command vs. Strategy
- **Command**: Encapsulates a request as an object, supports undo/redo
- **Strategy**: Encapsulates an algorithm, focuses on interchangeable behavior
- Command is about requests; Strategy is about algorithms

### Command vs. Memento
- **Command**: Encapsulates operations
- **Memento**: Encapsulates state snapshots
- Often used together for undo functionality

### Command vs. Observer
- **Command**: One-to-one relationship, explicit invocation
- **Observer**: One-to-many, automatic notification
- Command is pull-based; Observer is push-based

### Command vs. Chain of Responsibility
- **Command**: Single handler (receiver) for each command
- **Chain**: Multiple potential handlers, request passes through chain
- Command knows its receiver; Chain discovers it

## Advanced Features

### Macro Commands Example Flow
```
MacroCommand
  ├─ Command1
  ├─ Command2
  └─ Command3
```
Executing MacroCommand executes all sub-commands in order.

### Queued Execution
Commands can be added to a queue and processed by worker threads, enabling task scheduling and load balancing.

### Logged Execution
Commands can be logged before execution, creating an audit trail or enabling replay after system crashes.

### Remote Commands
Commands can be serialized and sent over networks for remote execution (RPC, microservices).

## Key Takeaways

🔑 Encapsulates requests as objects with all necessary information  
🔑 Decouples invoker from receiver, promoting loose coupling  
🔑 Enables undo/redo by maintaining command history  
🔑 Supports queuing, logging, and scheduling of operations  
🔑 Commands can be composed into macro commands  
🔑 Perfect for GUI applications and transaction systems  
🔑 Invoker doesn't need to know how operations are performed  
🔑 New commands can be added without modifying existing code

## Design Principles Supported

- **Single Responsibility Principle**: Each command handles one specific operation
- **Open/Closed Principle**: New commands can be added without modifying invoker
- **Dependency Inversion Principle**: Invoker depends on Command abstraction
- **Interface Segregation Principle**: Command interface is focused and minimal
- **Encapsulation**: Request details are hidden inside command objects

## CQRS Connection

The Command pattern is fundamental to **Command Query Responsibility Segregation (CQRS)** architecture, where:
- Commands represent state-changing operations
- Queries represent read-only operations
- Commands and queries follow separate paths

## Event Sourcing Integration

Command pattern naturally integrates with **Event Sourcing**, where:
- Commands generate events
- Events are stored as immutable log
- System state is rebuilt by replaying events
- Commands with events enable complete audit trails

---

*The Command Pattern is essential for building flexible, maintainable systems that require undoable operations, task queuing, or decoupling between request senders and receivers.*