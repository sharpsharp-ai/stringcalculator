# String Calculator Kata

Startstand für die Kata: ein leeres Projekt mit Maven, JUnit 4, Hamcrest und Mockito. Der einzige Test
prüft, dass die Werkzeuge laufen. Die Aufgabe steht in `StringCalculatorKata.md` (auch als PDF),
weitere Katas liegen unter `other-katas/`.

Fertig ist eine Änderung, wenn `mvn -q verify` ohne Ausgabe und mit Exit-Code 0 endet.

## Loslegen

Voraussetzung: JDK 17 oder neuer und Maven (IntelliJ bringt Maven mit).

```bash
git clone https://github.com/sharpsharp-ai/stringcalculator.git
cd stringcalculator
mvn -q verify      # keine Ausgabe heißt grün
```

IntelliJ: File → New → Project from Version Control, die URL einfügen. IntelliJ erkennt die `pom.xml`
und lädt die Bibliotheken. Rechtsklick auf `src/test/java` → Run 'All Tests'.

## Struktur

| Ort | Inhalt |
|---|---|
| `src/main/java/de/sharpsharp/stringcalculator/` | hier entsteht der `StringCalculator` |
| `src/test/java/de/sharpsharp/stringcalculator/StringCalculatorTest.java` | die Tests, Start mit einem Kanarienvogel |
| `StringCalculatorKata.md` | die Aufgabe, Schritt für Schritt |
| `other-katas/` | Bowling Game, Counting Lines of Code, Poker Hands, Roman Numerals |
