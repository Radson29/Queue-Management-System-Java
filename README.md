# Queue Management System

A Java-based queue management system that handles both regular and VIP customers in a store or service environment. The system provides functionality for customer queue management with priority handling for VIP customers.

## Features

- **Dual Queue System**
 - Regular customer queue
 - VIP customer queue with priority service
- **Customer Management**
 - Add new customers (regular and VIP)
 - Remove customers from queue
 - Process customers (with VIP priority)
- **Queue Monitoring**
 - Real-time queue status display
 - Customer counting system
 - Unique customer ID generation
 
## Core Components

### Main
The entry point of the application that supports two modes of operation:
- Interactive mode using Scanner for real-time command input
- Fixed command list mode for testing and demonstration

### Person
A class representing a customer with attributes:
- Name
- Surname
- Counter (for duplicate names)
- VIP status
- Unique ID generation

### CustomQueue
Manages the dual queue system with features:
- Separate VIP and regular queues
- Customer entry and exit handling
- Queue status monitoring
- Customer counter management

### PersonCommandProcessor
Handles command processing with support for:
- ADD PERSON - Adds new customer (regular or VIP)
- LEAVE PERSON - Removes customer from queue
- PROCESS - Services next customer in queue (VIP priority)

### Example Commands
```java
ADD PERSON(Tomasz_Romański)
ADD PERSON(Rafał_Adamczuk)
ADD PERSON(Tomasz_Romański,VIP)
PROCESS
LEAVE PERSON(Tomasz_Romański_2)
```
