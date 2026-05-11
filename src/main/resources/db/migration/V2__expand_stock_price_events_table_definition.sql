alter table stock_price_events
    add column price numeric(18,4) not null,
    add column event_timestamp timestamptz not null,
    add column ingestion_timestamp timestamptz not null default now(),
    add column source varchar(32) not null;

alter table stock_price_events
    add constraint uq_stock_price_event unique (
        symbol,
        event_timestamp,
        source
    );

create index idx_stock_price_events_symbol
    on stock_price_events(symbol);

create index idx_stock_price_events_event_timestamp
    on stock_price_events(event_timestamp);