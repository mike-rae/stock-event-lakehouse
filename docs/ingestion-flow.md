# Ingestion Flow

## Overview
```text
HTTP JSON event
        ↓
Validated DTO boundary
        ↓
Domain event conversion
        ↓
Repository layer
        ↓
Parameterized SQL
        ↓
PostgreSQL persistence
        ↓
Idempotent storage semantics
```

## Request Validation

Incoming requests are validated using Jakarta Bean Validation annotations.

Invalid requests return HTTP 400 responses before entering the domain layer.

## Domain Conversion

Validated request DTOs (Data Transfer Objects) are converted into immutable domain events.

The domain layer represents trusted internal system data.

## Persistence

Events are persisted using JDBC and explicit SQL statements. 

The repository layer intentionally avoids heavy ORM abstractions.

## Idempotency

Duplicate events are ignored using PostgreSQL unique constraints combined with:

```sql
ON CONFLICT DO NOTHING
```
This enables retry-safe ingestion behaviour.

---