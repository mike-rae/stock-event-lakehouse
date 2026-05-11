# ADR 0001 - Use JDBC over JPA

## Status

Accepted

---

## Context

The project focuses on backend and data-engineering concepts rather than CRUD-oriented business applications.

The ingestion pipeline benefits from:
- explicit SQL visibility
- direct control over inserts
- simple persistence semantics
- reduced ORM complexity

---

## Decision

Use Spring JDBC and explicit SQL statements rather than JPA/Hibernate.

---

## Consequences

### Advantages

- simpler mental model
- explicit query behaviour
- easier reasoning about ingestion semantics
- closer alignment with data-engineering workflows

### Tradeoffs

- more manual SQL
- less automatic entity management
- fewer ORM abstractions

---

