---
title: 'Iterator Pattern'
description: 'A behavioral design pattern that provides sequential access to collection elements without exposing internal structure'
category: 'Design Patterns'
tags: ['behavioral', 'design-pattern', 'collections', 'traversal']
---

# Iterator Pattern

## 📋 Overview

The **Iterator Pattern** is a behavioral design pattern that provides a way to access elements of a collection **sequentially without exposing its internal representation**. Instead of clients managing traversal logic, an **Iterator** object handles it, creating a clean separation between the collection and its traversal mechanism.

<Alert>
  <AlertDescription>
    💡 **Key Insight**: Think of a TV remote that lets you go channel by channel without knowing the internal wiring of the TV. You just press "next" and the remote handles the rest!
  </AlertDescription>
</Alert>

## 🎯 Intent

* Provide a standard way to traverse a collection without exposing its internal structure
* Decouple collection traversal logic from the collection itself
* Support multiple simultaneous traversals of the same collection
* Offer a uniform interface for iterating over different types of collections

## 🔑 Key Concepts

### The TV Remote Analogy

Think of the Iterator Pattern like a **TV Remote Control**:

- You can navigate through channels using "next" and "previous" buttons
- You don't need to know how channels are stored internally
- The remote provides a simple interface to access content sequentially
- Multiple remotes can control the same TV independently

## ✨ Core Components

<div className="grid grid-cols-1 md:grid-cols-2 gap-4 my-6">
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">1. Iterator Interface</h3>
    <p>Defines methods for traversing elements (hasNext, next)</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">2. Concrete Iterator</h3>
    <p>Implements the iteration logic for a specific collection</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">3. Aggregate/Collection Interface</h3>
    <p>Defines method to create an iterator</p>
  </div>
  <div className="border rounded-lg p-4">
    <h3 className="font-bold">4. Concrete Collection</h3>
    <p>Implements the collection and returns appropriate iterator</p>
  </div>
</div>

## 🎯 When to Use

### Ideal Scenarios

* **Uniform Traversal**: Need a standard way to iterate over different collection types (lists, sets, trees, custom containers)
* **Encapsulation**: Want to hide the internal structure of a collection from clients
* **Multiple Traversals**: Need to support different traversal methods (forward, backward, filtered, etc.)
* **Simplify Collection Interface**: Remove traversal responsibility from the collection class
* **Concurrent Iterations**: Multiple iterators should work on the same collection simultaneously

### Problem Indicators

* Clients need to know collection internals to traverse it
* Traversal logic is duplicated across multiple places
* Collection class is cluttered with different traversal methods
* Different collections require different traversal code
* Need to pause and resume traversal operations

## ✅ Benefits

### Advantages

* **Uniform Interface**: Provides consistent traversal mechanism across different collections
* **Encapsulation**: Hides internal collection structure (arrays, linked lists, trees, etc.)
* **Single Responsibility**: Separates traversal logic from collection management
* **Multiple Iterators**: Multiple iterators can work on the same collection simultaneously
* **Flexibility**: Easy to add new traversal methods without modifying collections
* **Simplified Client Code**: Clients use simple iterator interface regardless of collection type

### Trade-offs

* Adds extra classes to the codebase
* May be overkill for simple collections
* Iteration might be slower than direct access for some data structures
* Need to handle concurrent modification scenarios carefully

## 🌍 Real-World Examples

### TV Remote Control

* Navigate channels sequentially using next/previous buttons
* No need to understand the TV's internal channel storage
* Multiple remotes can control the same TV independently

### Music Streaming Services (Spotify, Apple Music)

* Skip through songs in a playlist without knowing storage details
* Same interface works for different playlist types
* Can have multiple playlists playing simultaneously

### File System Navigation

* Iterate through files in a directory
* Works the same way regardless of file system type
* Hide complex directory structure from users

### Social Media Feeds

* Scroll through posts sequentially
* Feed algorithm handles what comes next
* Users don't see the underlying data structure

### Book Reading Apps

* Turn pages or chapters sequentially
* Bookmark system allows multiple reading positions
* Internal book format is hidden from the reader

## 🔄 How It Works

export const IteratorFlow = () => (
  <div className="bg-gray-50 p-6 rounded-lg my-6">
    <ol className="space-y-3">
      <li className="flex items-start">
        <span className="font-bold mr-3">1.</span>
        <span>Client requests an <strong>Iterator</strong> from the <strong>Collection</strong></span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">2.</span>
        <span>Collection creates and returns a <strong>Concrete Iterator</strong> instance</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">3.</span>
        <span>Client uses <strong>hasNext()</strong> to check if more elements exist</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">4.</span>
        <span>Client calls <strong>next()</strong> to retrieve the current element and advance</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">5.</span>
        <span>Iterator maintains internal state (current position) during traversal</span>
      </li>
      <li className="flex items-start">
        <span className="font-bold mr-3">6.</span>
        <span>Process repeats until <strong>hasNext()</strong> returns false</span>
      </li>
    </ol>
  </div>
)

<MediatorFlow />

## 🎨 Design Principles

### Followed Principles

* **Single Responsibility**: Collection manages data; Iterator manages traversal
* **Open/Closed**: New iterator types can be added without modifying collections
* **Encapsulation**: Internal collection structure is hidden from clients
* **Separation of Concerns**: Traversal logic is separate from business logic

## 🔄 Related Patterns

* **Composite Pattern**: Iterators often used to traverse composite structures
* **Factory Method**: Can be used to create different types of iterators
* **Memento Pattern**: Can save and restore iterator state
* **Visitor Pattern**: Visitors often use iterators to traverse collections

## 🎓 Best Practices

<Alert>
  <AlertDescription>
    <ul className="space-y-2 mt-2">
      <li>✓ Keep iterator interface simple and focused (hasNext, next are usually sufficient)</li>
      <li>✓ Consider supporting remove() operation if collection is mutable</li>
      <li>✓ Handle concurrent modification exceptions appropriately</li>
      <li>✓ Document iterator behavior clearly (fail-fast vs fail-safe)</li>
      <li>✓ Consider providing different iterator types (forward, reverse, filtered)</li>
      <li>✓ Make iterators lightweight - they shouldn't copy the entire collection</li>
    </ul>
  </AlertDescription>
</Alert>

## 📊 Iterator Pattern in Practice

<div className="grid grid-cols-1 md:grid-cols-2 gap-6 my-6">
  <div className="border-2 border-red-200 rounded-lg p-6 bg-red-50">
    <h3 className="text-xl font-bold mb-4 text-red-700">❌ Without Iterator</h3>
    <ul className="space-y-2">
      <li>• Clients must know collection internal structure</li>
      <li>• Different code needed for different collection types</li>
      <li>• Traversal logic scattered throughout codebase</li>
      <li>• Difficult to support multiple traversal strategies</li>
      <li>• Hard to maintain if collection structure changes</li>
    </ul>
  </div>
  <div className="border-2 border-green-200 rounded-lg p-6 bg-green-50">
    <h3 className="text-xl font-bold mb-4 text-green-700">✅ With Iterator</h3>
    <ul className="space-y-2">
      <li>• Uniform interface hides collection internals</li>
      <li>• Same code works for all collection types</li>
      <li>• Traversal logic centralized in iterator</li>
      <li>• Easy to add new traversal methods</li>
      <li>• Collection changes don't affect clients</li>
    </ul>
  </div>
</div>

## 💻 Built-in Language Support

### Java

Java has built-in support for the Iterator Pattern:

* `Iterator<E>` interface in `java.util` package
* `Iterable<E>` interface for collections that can be iterated
* Enhanced for-each loop: `for (String item : collection)`
* `ListIterator<E>` for bidirectional iteration

### Other Languages

* **C#**: `IEnumerator` and `IEnumerable` interfaces, `foreach` loop
* **Python**: Iterator protocol with `__iter__()` and `__next__()`
* **JavaScript**: Iterator protocol with `Symbol.iterator`
* **C++**: STL iterators with `begin()` and `end()`

## 🎯 Iterator Variations

### Common Iterator Types

<div className="space-y-4 my-6">
  <div className="border-l-4 border-blue-500 pl-4">
    <h4 className="font-bold">Forward Iterator</h4>
    <p>Traverses collection from beginning to end (most common)</p>
  </div>
  <div className="border-l-4 border-purple-500 pl-4">
    <h4 className="font-bold">Reverse Iterator</h4>
    <p>Traverses collection from end to beginning</p>
  </div>
  <div className="border-l-4 border-green-500 pl-4">
    <h4 className="font-bold">Filtered Iterator</h4>
    <p>Returns only elements matching certain criteria</p>
  </div>
  <div className="border-l-4 border-orange-500 pl-4">
    <h4 className="font-bold">Bidirectional Iterator</h4>
    <p>Supports both forward and backward traversal</p>
  </div>
  <div className="border-l-4 border-red-500 pl-4">
    <h4 className="font-bold">Random Access Iterator</h4>
    <p>Allows jumping to arbitrary positions</p>
  </div>
</div>

---

<Alert>
  <AlertDescription>
    ⚡ **Fun Fact**: Java's built-in `Iterator<E>` interface and the enhanced `for-each` loop (`for (String s : list)`) are based on the Iterator Pattern. This pattern is so fundamental that it's built into most modern programming languages!
  </AlertDescription>
</Alert>

<Alert>
  <AlertDescription>
    **Remember**: The Iterator Pattern is about **providing a clean, uniform way to traverse collections** while keeping their internal structure hidden. Use it when you need to access elements sequentially without exposing how they're stored.
  </AlertDescription>
</Alert>