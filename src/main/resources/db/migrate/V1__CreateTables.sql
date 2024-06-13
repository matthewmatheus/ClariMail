-- src/main/resources/db/migrate/V1__CreateTables.sql
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       email VARCHAR(100) UNIQUE NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE emails (
                        id SERIAL PRIMARY KEY,
                        user_id INTEGER REFERENCES users(id),
                        subject VARCHAR(255),
                        body TEXT,
                        sender VARCHAR(100),
                        recipient VARCHAR(100),
                        sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        is_read BOOLEAN DEFAULT FALSE,
                        important BOOLEAN DEFAULT FALSE
);
