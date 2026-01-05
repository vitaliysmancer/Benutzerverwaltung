DROP DATABASE IF EXISTS benutzerverwaltung;
CREATE DATABASE benutzerverwaltung;

USE benutzerverwaltung;

CREATE TABLE IF NOT EXISTS benutzer (
    name VARCHAR(100) PRIMARY KEY,
    passwort VARBINARY(255),
    vorname VARCHAR(100),
    nachname VARCHAR(100)
);