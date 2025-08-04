CREATE TABLE book (
	id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	isbn10 VARCHAR(10),
	isbn13 VARCHAR(13),
	title TEXT NOT NULL,
	publishing_year SMALLINT,
	publisher TEXT,
	number_of_pages SMALLINT,
	year_recommendation SMALLINT,
	is_fiction BOOLEAN NOT NULL,
	code_dewey TEXT REFERENCES dewey(code_dewey),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT non_fiction_requires_dewey
    CHECK (is_fiction = false OR code_dewey IS NULL);
)

CREATE TABLE dewey (
    code_dewey TEXT PRIMARY KEY,
    name TEXT NOT NULL,
    parent_code TEXT REFERENCES dewey(code_dewey)
);

CREATE TABLE library (
	id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name TEXT UNIQUE
)

CREATE TYPE copy_status AS ENUM ('available', 'borrowed', 'on_hold', 'lost', 'damaged', 'removed');

CREATE TABLE copy (
	id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	book_id BIGINT NOT NULL REFERENCES book(id) ON DELETE CASCADE,
	code_identification TEXT NOT NULL,
	library_id BIGINT NOT NULL REFERENCES library(id),
	status copy_status NOT NULL DEFAULT 'available'
)

CREATE TABLE genre (
	id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name TEXT UNIQUE
)

CREATE TABLE book_genre (
	genre_id BIGINT NOT NULL REFERENCES genre(id) ON DELETE CASCADE,
	book_id BIGINT NOT NULL REFERENCES book(id) ON DELETE CASCADE,

	PRIMARY KEY (genre_id, book_id)
)

CREATE TABLE cover (
	book_id BIGINT NOT NULL REFERENCES book(id) ON DELETE CASCADE,
	size TEXT,
	link TEXT,

	PRIMARY KEY (book_id, size)
)

CREATE TABLE author (
	id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name TEXT UNIQUE
)

CREATE TABLE book_author (
	author_id BIGINT NOT NULL REFERENCES author(id) ON DELETE CASCADE,
	book_id BIGINT NOT NULL REFERENCES book(id) ON DELETE CASCADE,

	PRIMARY KEY (author_id, book_id)
)

CREATE EXTENSION citext;
CREATE DOMAIN email AS citext
  CHECK ( value ~ '^[a-zA-Z0-9.!#$%&''*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$' );

CREATE TABLE users(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	first_name TEXT,
	last_name TEXT,
	is_super BOOLEAN,
	email email UNIQUE NOT NULL,
	is_active BOOLEAN DEFAULT TRUE,
    last_login TIMESTAMP,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)

CREATE TYPE borrowing_status AS ENUM ('borrowed', 'returned', 'overdue');

CREATE TABLE borrowing (
	id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	copy_id BIGINT NOT NULL REFERENCES copy(id),
	user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
	status borrowing_status NOT NULL DEFAULT 'borrowed',
	start_date DATE NOT NULL CHECK (start_date <= end_date),
	end_date DATE NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
)

CREATE TYPE hold_status AS ENUM ('active', 'expired', 'fulfilled');

CREATE TABLE hold (
	id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	copy_id BIGINT NOT NULL REFERENCES copy(id),
	user_id BIGINT NOT NULL REFERENCES users(id),
	status hold_status NOT NULL DEFAULT 'active',
	start_date DATE NOT NULL CHECK (start_date <= end_date),
	end_date DATE NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)

CREATE TABLE waitlist (
	book_id BIGINT NOT NULL REFERENCES book(id),
    user_id BIGINT NOT NULL REFERENCES users(id),

    PRIMARY KEY (book_id, user_id)
)

CREATE TABLE notification (
	id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	user_id BIGINT NOT NULL REFERENCES users(id),
	sent_at DATE,
	type TEXT
)

CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = CURRENT_TIMESTAMP;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_borrowing_set_updated_at
BEFORE UPDATE ON borrowing
FOR EACH ROW
EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER trg_hold_set_updated_at
BEFORE UPDATE ON hold
FOR EACH ROW
EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER trg_users_set_updated_at
BEFORE UPDATE ON users
FOR EACH ROW
EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER trg_book_set_updated_at
BEFORE UPDATE ON book
FOR EACH ROW
EXECUTE FUNCTION update_updated_at_column();



