# Benutzerverwaltung – Konsolenanwendung (Java & MySQL)

## 📋 Projektbeschreibung
Dieses Projekt ist eine Java-Konsolenanwendung zur Verwaltung von Benutzeraccounts.  
Benutzer können sich registrieren und anschließend einloggen.  
Die Benutzerdaten werden in einer MySQL-Datenbank gespeichert, wobei das Passwort **ausschließlich verschlüsselt** abgelegt wird.

Die Anwendung wurde im Rahmen einer Programmieraufgabe erstellt.  
Eine manuelle Benutzereingabe ist nicht erforderlich – die Funktionalität wird automatisch getestet.

---

## ⚙️ Verwendete Technologien
- Java (JDK 17 oder höher empfohlen)
- MySQL
- JDBC
- IntelliJ IDEA

---

## 🗄️ Datenbankstruktur

```sql
CREATE DATABASE benutzerverwaltung;

CREATE TABLE benutzer (
    name VARCHAR(100) PRIMARY KEY,
    passwort VARBINARY(255),
    vorname VARCHAR(100),
    nachname VARCHAR(100)
);
```
---
## 🔐 Passwort-Verschlüsselung
Das Passwort wird mit dem SHA-256 Algorithmus verschlüsselt und als Byte-Array gespeichert.

```java
Code kopieren
private static byte[] encode(String passwort) throws Exception {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    return digest.digest(passwort.getBytes(StandardCharsets.UTF_8));
}
```
---
## 📦 Projektstruktur
```css
Code kopieren
Benutzerverwaltung
│
├── src
│   └── main
│       └── java
│           ├── Main.java
│           ├── Benutzer.java
│           └── MySQL.java
```
---
## 🧩 Zentrale Methoden
Registrierung
java
Code kopieren
public static boolean register(String benutzername, String passwort, String vorname, String nachname)
Gibt true zurück, wenn die Registrierung erfolgreich war

Gibt false zurück, wenn der Benutzername bereits existiert oder ein Fehler auftritt

Login
java
Code kopieren
public static Benutzer login(String benutzername, String passwort)
Gibt ein Benutzer-Objekt zurück, wenn Login erfolgreich ist

Gibt null zurück, wenn Login fehlschlägt
---
## 🧪 Test der Anwendung
Die Anwendung wird automatisch getestet:

Ein Benutzer wird registriert

Der Benutzer meldet sich an

Die Benutzerdaten werden in der Konsole ausgegeben

Es ist keine manuelle Eingabe erforderlich.
---
## ▶️ Anwendung starten
MySQL-Server starten

SQL-Skript ausführen

Projekt in IntelliJ öffnen

Main.java ausführen
---
## 👤 Autor
Name: Vitalijs Smancers (Vitaliy Smancer)

Projekt: Benutzerverwaltung – Java Konsolenanwendung

Kontext: Schulische Programmieraufgabe
