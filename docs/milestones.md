# Milestones

This project is developed incrementally, adding features incrementally. At time of initial check-in to Github, the project has fulfilled Milestone 2.

## Milestone 1

Infrastructure and service scaffold:
- Spring Boot service
- Docker Compose PostgreSQL
- JDBC datasource
- Health endpoints
- Basic controllers

---

## Milestone 2

Core ingestion pipeline:
- Flyway migrations
- Event table schema
- DTO validation
- Domain event modelling
- JDBC repository
- Idempotent inserts
- Structured logging

---

## Planned Milestone 3

Testing and reliability:
- Testcontainers integration tests
- Repository testing
- Duplicate event tests
- Validation tests

---

## Planned Future Areas

- Kafka/Redpanda integration
- Event streaming
- Retry handling
- Dead-letter queues
- Metrics and observability
- Event replay
- Partitioning strategies
- Containerized deployment
- Lakehouse-style modelling