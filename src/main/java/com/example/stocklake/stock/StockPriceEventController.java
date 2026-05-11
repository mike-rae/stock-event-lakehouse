package com.example.stocklake.stock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.*;

@RestController
class StockPriceEventController {
    private static final Logger log = LoggerFactory.getLogger(StockPriceEventController.class);

    private final StockPriceEventRepository repository;

    public StockPriceEventController(StockPriceEventRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/stock-events")
    @ResponseStatus(HttpStatus.CREATED)
    IngestResponse ingest(@Valid @RequestBody IngestStockPriceEventRequest request) {
        StockPriceEvent event = request.toEvent();

        int rowsInserted = repository.save(event);
        String result = rowsInserted == 1 ? "inserted" : "duplicate_ignored";

        log.info(
                "stock_event_ingested symbol={} source={} eventTimestamp={} result={}",
                event.symbol(),
                event.source(),
                event.eventTimestamp(),
                rowsInserted == 1 ? "inserted" : "duplicate_ignored");

        return new IngestResponse(result);
    }

    record IngestResponse(String status) {
    }
}
