package com.example.stocklake.db;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.core.simple.JdbcClient.StatementSpec;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
class DatabasePingController {
    private final JdbcClient jdbcClient;

    DatabasePingController(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    record DbPingResponse(
            String database, String user) {
    }

    @GetMapping("/db-ping")
    DbPingResponse ping() {
        Map<String, Object> result = jdbcClient.sql("""
                select current_database() as database_name, current_user as username
                    """).query().singleRow();

        return new DbPingResponse(result.get("database_name").toString(), result.get("username").toString());
    }
}
