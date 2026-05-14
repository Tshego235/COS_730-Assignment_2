# Intelligent Submission & Review System

## Overview

This project implements a simplified **research paper submission and peer-review system** in Java.

The system simulates the complete workflow of:
- validating submissions,
- selecting reviewers,
- evaluating research papers,
- calculating outcomes,
- and notifying researchers of final decisions.

The repository contains two implementations:

### Task 1 — Baseline Implementation
A direct implementation of the provided sequence diagram with intentionally preserved design flaws for analysis purposes.

### Task 5 — Optimised Implementation
A refactored and improved version that reduces coupling, improves cohesion, simplifies logic, and improves maintainability and efficiency.

---

## Features

- Submission validation
- Reviewer assignment
- Conflict and workload filtering
- Research evaluation and scoring
- Decision generation
- Notification handling
- Method call tracking
- Benchmark execution timing

---

## Project Structure

```text
.
├── Task1_Baseline/
│   ├── BaselineMain.java
│   ├── SubmissionController.java
│   ├── Validator.java
│   ├── ReviewerManager.java
│   ├── EvaluationManager.java
│   ├── NotificationService.java
│   ├── Reviewer.java
│   ├── Database.java
│   └── CallTracker.java
│
├── Task5_Optimised/
│   ├── OptimisedMain.java
│   ├── SubmissionSystem.java
│   ├── DecisionEngine.java
│   ├── ReviewerService.java
│   ├── EvaluationService.java
│   ├── NotificationService.java
│   ├── Reviewer.java
│   ├── Database.java
│   └── CallTracker.java
│
└── README.md

# Compile Baseline
	cd Task1 
  javac *.java

# Run Baseline
  java BaselineMain

# Compile Optimised
	cd Task5
  javac *.java

# Run Optimised
	java OptimisedMain

# Compile Everything
