package com.example.stocklake.stock;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

record IngestStockPriceEventRequest(
                @NotBlank @Size(max = 16) String symbol,
                @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal price,
                @NotNull Instant eventTimestamp,
                @NotBlank @Size(max = 16) String source) {
        StockPriceEvent toEvent() {
                return new StockPriceEvent(
                                symbol.toUpperCase(),
                                price,
                                eventTimestamp,
                                source);
        }
}
