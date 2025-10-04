---
title: "Adapter Pattern"
---

# Adapter Pattern

## Overview

The **Adapter Pattern** is a structural design pattern that acts as a bridge between two incompatible interfaces. It allows classes with different interfaces to work together by wrapping one interface to match another.

## Real-Life Analogy

Think of a **power adapter** when traveling internationally:

- Your laptop charger has a **US 2-pin plug**
- The wall socket in Europe uses a **3-pin configuration**
- You need an **adapter** to connect them

The adapter doesn't change how your charger works internally—it simply translates the interface so both can communicate.

## How It Works

The pattern involves three key components:

1. **Target Interface** - The interface that the client expects to work with
2. **Adaptee** - The existing class with an incompatible interface
3. **Adapter** - The translator that makes the Adaptee compatible with the Target

## When to Use the Adapter Pattern

### ✅ Use When:

- You need to integrate **legacy code** with modern systems without modifying the original code
- Working with **third-party libraries** that have different method signatures than your application expects
- You want to **reuse existing classes** but their interfaces don't match your requirements
- Multiple classes need to use a common interface but have different implementations

### ❌ Avoid When:

- You can modify the original class directly
- The interface differences are too complex (consider refactoring instead)
- You're in the early stages of design (design correct interfaces from the start)

## Benefits

<div className="benefits-grid">
  <div className="benefit-card">
    <h3>Reusability</h3>
    <p>Allows existing code to work in new contexts</p>
  </div>
  <div className="benefit-card">
    <h3>Flexibility</h3>
    <p>Decouples client code from specific implementations</p>
  </div>
  <div className="benefit-card">
    <h3>Single Responsibility</h3>
    <p>Separates interface conversion logic from business logic</p>
  </div>
  <div className="benefit-card">
    <h3>Open/Closed Principle</h3>
    <p>Add new adapters without modifying existing code</p>
  </div>
</div>

## Real-World Examples

<div className="examples-list">

  - **Media Players** - Adapting different audio/video formats to work with a common player interface.
  - **Database Connections** - Using different database drivers through a unified interface.
  - **Payment Gateways** - Integrating multiple payment providers (PayPal, Stripe, etc.) with a single payment interface.
  - **Logging Systems** - Adapting various logging frameworks to work with your application's logging interface.
</div>

## Types of Adapters

<table>
  <thead>
    <tr>
      <th>Type</th>
      <th>Description</th>
      <th>Usage</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Class Adapter</strong></td>
      <td>Uses inheritance to adapt interfaces</td>
      <td>Requires multiple inheritance</td>
    </tr>
    <tr>
      <td><strong>Object Adapter</strong></td>
      <td>Uses composition to wrap the adaptee</td>
      <td>More common and flexible</td>
    </tr>
  </tbody>
</table>

## Summary

<div className="summary-box">
  The Adapter Pattern is like a universal translator for your code. It enables seamless communication between incompatible interfaces without requiring changes to existing, working code. It's particularly valuable when integrating external libraries, legacy systems, or standardizing diverse implementations under a common interface.
</div>

