# Local Development

## Requirements

- Java 21
- Docker
- Docker Compose
- WSL/Linux/macOS recommended

---

## Start PostgreSQL

```bash
docker compose up -d
```

---

## Run Application
```bash
./gradlew bootRun
```

## Verify Health
```bash
curl localhost:8080/actuator/health
```

## Connect to PostgreSQL
```bash
docker exec -it stocklake-postgres psql -U stocklake -d stocklake
```

## Useful PostgreSQL Commands

### List tables:
```bash
\dt
```

### Describe table:
```bash
\d stock_price_events
```

### Query events:
```bash
select *
from stock_price_events;
```

---

## Stop Environment
```bash
docker compose down
```

---
