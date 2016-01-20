CREATE TABLE IF NOT EXISTS books (
    id INTEGER IDENTITY PRIMARY KEY,
    book_id VARCHAR(20),
    author VARCHAR(255),
    title VARCHAR(255),
    genre VARCHAR(80),
    price DOUBLE,
    publish_date VARCHAR(20),
    description VARCHAR(512)
);
