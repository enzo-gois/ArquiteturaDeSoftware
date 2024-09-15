CREATE TABLE sale (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    id_customer TEXT NOT NULL,
    id_product TEXT NOT NULL,
    sale_date TIMESTAMP NOT NULL,
    amount_value NUMERIC NOT NULL,
    CONSTRAINT fk_customer
        FOREIGN KEY (id_customer)
        REFERENCES customer (id),
    CONSTRAINT fk_product
        FOREIGN KEY (id_product)
        REFERENCES product (id)
);