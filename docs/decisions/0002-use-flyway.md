# ADR 0002 - Use Flyway for Schema Management

## Status

Accepted

---

## Context

Database schemas evolve over time and must remain reproducible across environments.

Manual schema management becomes difficult as systems grow.

---

## Decision

Use Flyway migrations to manage database schema evolution.

---

## Consequences

### Advantages

- version-controlled schema changes
- reproducible environments
- deterministic startup migrations
- auditable schema history

### Tradeoffs

- migration discipline required
- applied migrations should not be modified
- schema evolution requires forward-only thinking