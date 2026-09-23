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

## Clean-Code-Report

Ein Blick auf den Code, ohne Gnade und ohne Gate: Der Bericht liest den Code mit dem Java-Parser des JDK,
sucht 30 Code Smells aus sechs Familien (Bloaters, Object-Orientation Abusers, Dispensables, Couplers,
Readability, Test Smells) und macht daraus Punkte, einen Rang, einen Radar je Familie und eine Monster-Galerie.
Links die Funde, rechts der Code wie in der IDE, ein Klick springt zur Zeile; das Regelwerk mit jeder Schwelle
und jedem Refactoring steht im Bericht. Ein Ausschnitt geht auch: `--nur core`, `--nur Kasse` oder `--nur Kasse#bezahlen`,
in opencode auch in Worten: `/clean-code-report nur die Domain-Klassen`.

```bash
java .opencode/skills/clean-code-report/CleanCodeReport.java   # schreibt target/clean-code-report.html
```

In opencode: `/clean-code-report` erzeugt den Bericht und nennt die drei teuersten Funde samt erstem Schritt.
Nichts zu installieren, JDK 17 reicht. Jeder Lauf merkt sich den Punktestand in `.clean-code-history`,
der Bericht zeigt den Verlauf. Der Branch `beispiel-legacy` enthält eine Lösung der Kata, die alle Regeln
bricht und trotzdem grün ist. Der Skill ist ein Ordner: `.opencode/skills/clean-code-report/` plus der
Command lassen sich in jedes Java-Projekt kopieren.

## Struktur

| Ort | Inhalt |
|---|---|
| `src/main/java/de/sharpsharp/stringcalculator/` | hier entsteht der `StringCalculator` |
| `src/test/java/de/sharpsharp/stringcalculator/StringCalculatorTest.java` | die Tests, Start mit einem Kanarienvogel |
| `StringCalculatorKata.md` | die Aufgabe, Schritt für Schritt |
| `other-katas/` | Bowling Game, Counting Lines of Code, Poker Hands, Roman Numerals |
| `.opencode/skills/clean-code-report/` | der Clean-Code-Report als Skill: Java-Programm ohne Abhängigkeiten plus Anleitung |
