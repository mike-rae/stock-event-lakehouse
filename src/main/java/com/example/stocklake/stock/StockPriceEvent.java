package com.example.stocklake.stock;

import java.math.BigDecimal;
import java.time.Instant;

record StockPriceEvent(
        String symbol,
        BigDecimal price,
        Instant eventTimestamp,
        String source) {
}
