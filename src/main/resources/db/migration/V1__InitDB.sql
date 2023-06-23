DROP TABLE IF EXISTS regions CASCADE;
DROP TABLE IF EXISTS countries CASCADE;
DROP TABLE IF EXISTS companies CASCADE;
DROP TABLE IF EXISTS sites CASCADE;
DROP TABLE IF EXISTS units CASCADE;

CREATE TABLE regions
(
    id          INTEGER PRIMARY KEY,
    region_name VARCHAR
);
CREATE TABLE countries
(
    id           INTEGER PRIMARY KEY,
    country_name VARCHAR,
    subregion    VARCHAR,
    region       VARCHAR,
    region_id    INTEGER REFERENCES regions (id)
);

CREATE TABLE companies
(
    id             INTEGER PRIMARY KEY,
    companies_name VARCHAR,
    full_name      VARCHAR,
    country_id     INTEGER REFERENCES countries (id)
);

CREATE TABLE sites
(
    id       INTEGER PRIMARY KEY,
    npp_name VARCHAR,
    place    INTEGER REFERENCES countries (id),
    owner_id INTEGER,
    operator INTEGER REFERENCES companies (id),
    builder  INTEGER
);

CREATE TABLE units
(
    id                   INTEGER PRIMARY KEY,
    code                 VARCHAR,
    unit_name            VARCHAR,
    site                 INTEGER REFERENCES sites (id),
    status               VARCHAR,
    type                 VARCHAR,
    model                VARCHAR,
    class                VARCHAR,
    ru_design            VARCHAR,
    operator             INTEGER,
    nsss_supplier        INTEGER,
    thermal_capacity     INTEGER,
    gross_capacity       INTEGER,
    net_capacity         INTEGER,
    construction_start   DATE,
    commercial_operation DATE,
    date_shutdown        DATE,
    enrichment           DECIMAL,
    load_factor          INTEGER,
    burnup               DECIMAL,
    first_load           DECIMAL,
    yearly_P             DECIMAL
);