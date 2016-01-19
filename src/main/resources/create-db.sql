CREATE TABLE books (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    book_id VARCHAR(20),
    author VARCHAR(255),
    title VARCHAR(255),
    genre VARCHAR(80),
    price DOUBLE,
    publish_date VARCHAR(20),
    description VARCHAR(512),
    PRIMARY KEY (id)
);
