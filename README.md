# Stock Event Lakehouse

This project is a learning aid, consisting of a Java 21 + Spring Boot practice project focused on backend and data-engineering concepts through the implementation of a simplified stockmarket-data ingestion platform.

The repository evolves incrementally through milestones and explores:
- event ingestion of stock price updates
- PostgreSQL persistence
- schema migrations
- idempotent event handling
- REST API design
- Docker-based local infrastructure
- modern Java development
- observability and operational concerns

---

# Current Features

- Java 21 Spring Boot service
- Docker Compose PostgreSQL environment
- Flyway schema migrations
- Event ingestion API
- Request validation
- JDBC persistence layer
- Idempotent inserts
- Structured application logging
- Spring Boot Actuator endpoints

---

# Technology Stack

- Java 21
- Spring Boot 4
- PostgreSQL
- Flyway
- Docker Compose
- Gradle
- JDBC
- Spring MVC
- Spring Validation
- Spring Actuator
- JUnit

---

# Quick Start

## Start PostgreSQL
```bash
docker compose up -d
```

## Run the application
```bash
./gradlew bootRun
```

## Verify health endpoint
Spring Actuator sets up a basic health check query endpoint. 
```bash
curl localhost:8080/actuator/health
```

A healthy response looks like so:
```json
{"groups":["liveness","readiness"],"status":"UP"}
```

## Ingest sample event
This curl command emulates a third party stock pricing engine pushing price updates to paying subscribers who front UIs to traders.

```bash
curl -X POST localhost:8080/stock-events \
  -H "Content-Type: application/json" \
  -d '{
    "symbol": "AAPL",
    "price": 181.25,
    "eventTimestamp": "2026-05-10T16:05:00Z",
    "source": "demo-feed"
  }'
```

---

# Documentation

- [Architecture Principles](docs/architecture-principles.md)
- [Local Development](docs/local-development.md)
- [Ingestion Flow](docs/ingestion-flow.md)
- [Milestones](docs/milestones.md)
- [Architecture Decisions](docs/decisions)

---

# Disclaimer

This repository is an educational and practice project only.

It is NOT production-grade software and should not be used in production environments or for real financial systems.

Use entirely at your own risk.

---