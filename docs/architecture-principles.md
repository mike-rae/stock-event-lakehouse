# Architecture Principles

The following sections describe the principles applied in architecting this project.

## DTO Boundaries

The project separates transport-layer request objects from internal domain models.

This prevents external API contracts from tightly coupling to internal implementation details.

A benefit of doing this means we won't expose the internal domain model to external  clients, allowing us to change internal domain model structure without impacting the external-facing interface. 

---

## Validation at System Boundaries

Incoming HTTP requests are validated before entering the domain layer.

This protects downstream systems from malformed or invalid data.

---

## Immutable Event Modelling

Events are represented as immutable Java __records__.

Events model historical facts rather than mutable state.

---

## Idempotent Ingestion

Duplicate events are safely ignored using:

PostgreSQL unique constraints:
```sql
ON CONFLICT DO NOTHING
```

This enables retry-safe ingestion behaviour.

---

## Explicit SQL over ORM Abstraction

The project intentionally prefers JDBC and explicit SQL over heavy ORM (Object Relational Mapping) abstraction.

Goals:
- understand query behaviour
- understand persistence semantics
- avoid hidden ORM complexity
- retain explicit control over ingestion logic

---

## Schema-as-Code

Database schema evolution is managed through Flyway migrations.

Migrations are version-controlled and reproducible.

When adding migration sql files, ensure not to edit existing versions, add a new file and incremenet version number. 

---

## Append-Oriented Storage

Events are inserted as immutable observations.

The system currently favours append-oriented event storage patterns over mutable state updates.

---