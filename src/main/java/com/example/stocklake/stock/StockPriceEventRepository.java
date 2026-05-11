package com.example.stocklake.stock;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
class StockPriceEventRepository {

    private final JdbcClient jdbcClient;

    StockPriceEventRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    int save(StockPriceEvent event) {

        return jdbcClient.sql("""
                insert into stock_price_events (
                    symbol,
                    price,
                    event_timestamp,
                    source
                )
                values (
                    :symbol,
                    :price,
                    :eventTimestamp,
                    :source
                )
                on conflict do nothing
                """)
                .param("symbol", event.symbol())
                .param("price", event.price())
                .param("eventTimestamp", java.sql.Timestamp.from(event.eventTimestamp()))
                .param("source", event.source())
                .update();
    }
}