# Käsekästchen – Minispiel (SE2 Projekt SoSe19)

📅 Sommersemester 2019  
🎓 Hochschule der Medien Stuttgart  
---

## 🧩 Kurzbeschreibung

**Käsekästchen** ist ein rundenbasiertes Minispiel, entwickelt im Rahmen der Veranstaltung *Software Entwicklung 2*. Ziel ist es, durch das Setzen von Linien möglichst viele Kästchen zu erobern. Das Spiel unterstützt zwei Spieler:innen, die abwechselnd Linien auf einem Spielfeld platzieren.

### Spielregeln:
- Ein Kästchen gehört dem Spieler, der die vierte Linie setzt.
- Punkteverteilung:
  - Normales Feld: **+1 Punkt**
  - Bonusfeld: **+3 Punkte**
  - Minusfeld: **–2 Punkte**
- Optional aktivierbare Felder (Bonus/Minus) werden zufällig verteilt.
- Das Spiel endet, wenn alle Felder belegt sind.

---

## 🚀 Start & Ausführung

- Startklasse: `GUI.java`
- Java SDK: Version **11.0.2**
- Zum Starten:
  ```bash
  javac GUI.java
  java GUI
  ```

---

## 🔍 Architektur & Besonderheiten

- **Designprinzipien:**
  - Interface: `IField`, implementiert durch `Field`
  - Vererbung: `Bonusfield` & `Minusfield` erweitern `Field`
  - GUI erweitert `Application` (JavaFX)
  - Weitere Klassen: `AIPlayer`, `PlayerManager`, `MatchfieldSettings`
  - Factory Pattern: `FieldFactory` erstellt dynamisch Felder
- **Clean Code:**
  - Keine öffentlichen Member
  - Kopien statt direkter Referenzen
  - Reduzierter Einsatz statischer Methoden
---

## 🧪 Tests

Folgende Komponenten werden getestet:
- `FieldTest`, `LineTest`, `MatchfieldSettingsTest`, `PlayerTest`
- Inklusive Negativtests

---

## 🖼️ GUI

- Zwei Szenen: Startmenü & Spielfeld
- Dynamische Gridpane für Spielfeldgröße
- Startmenü via BorderPane & GridPane mit Labels, Textfeldern & Buttons

---

## 📦 Packages & Funktionalität

- `CustomExceptions`, `Matchfield`, `PlayerManager`, `Threads`
- Logging (Debug, Info, Error) in mehreren Klassen
- Threads: Hintergrundmusik via `Music`-Thread
- Lambda-Ausdruck (z. B. Button-Klicks)
- Streams zur Sortierung von Highscores (`updateHighscoreList`)

---

## 📊 UML-Diagramme

- Use-Case-Diagramm  
- Klassendiagramm  
(Beide im Repository enthalten)

---

## 👥 Autor:innen

- **Mascha Weis** 
- **Susanne Weiß**
- **Alexander Kraus**

---

🎮 Viel Spaß beim Spielen und Ausprobieren von Käsekästchen!
