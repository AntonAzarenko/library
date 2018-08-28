ALTER TABLE public.metadata DROP CONSTRAINT metadata_books_fk;
ALTER TABLE public.authors_books DROP CONSTRAINT authors_books_author_id_fk;
ALTER TABLE public.authors_books DROP CONSTRAINT authors_books_book_id_fk;
ALTER TABLE public.books DROP CONSTRAINT book_publishers_fk;
DROP TABLE public.metadata;
DROP TABLE public.authors_books;
DROP TABLE public.books;
DROP TABLE public.publishers;
DROP TABLE public.authors;

-- auto-generated definition
CREATE TABLE authors
(
  id   BIGSERIAL    NOT NULL
    CONSTRAINT author_pk
    PRIMARY KEY,
  name VARCHAR(128) NOT NULL
);

-- auto-generated definition
CREATE TABLE publishers
(
  id   BIGSERIAL    NOT NULL
    CONSTRAINT publisher_pk
    PRIMARY KEY,
  name VARCHAR(256) NOT NULL
);

-- auto-generated definition
CREATE TABLE books
(
  id           BIGSERIAL    NOT NULL
    CONSTRAINT book_pk
    PRIMARY KEY,
  title        VARCHAR(256) NOT NULL,
  description  VARCHAR(512),
  publisher_id BIGINT
    CONSTRAINT book_publishers_fk
    REFERENCES publishers
);

-- auto-generated definition
CREATE TABLE authors_books
(
  author_id BIGINT NOT NULL
    CONSTRAINT authors_books_author_id_fk
    REFERENCES authors,
  book_id   BIGINT NOT NULL
    CONSTRAINT authors_books_book_id_fk
    REFERENCES books,
  CONSTRAINT authors_books_pkey
  PRIMARY KEY (author_id, book_id)
);

-- auto-generated definition
CREATE TABLE metadata
(
  id      BIGSERIAL    NOT NULL
    CONSTRAINT metadata_pk
    PRIMARY KEY,
  url     VARCHAR(256) NOT NULL,
  book_id BIGINT
    CONSTRAINT metadata_books_fk
    REFERENCES books
);

-- Populate Tables
insert INTO authors (name)
VALUES ('Maxim Gorky'), ('Ilya Ilf'), ('Eugeny Petrov');

insert INTO publishers (name)
VALUES ('Open Book'), ('Azbuka');

insert INTO books (title, description, publisher_id)
VALUES ('Mother',NULL ,1), ('The Lower Depths',NULL ,1), ('The Twelve Chairs',NULL ,1);

INSERT INTO authors_books (author_id, book_id) VALUES (1,1), (1,2), (2,3), (3,3);
