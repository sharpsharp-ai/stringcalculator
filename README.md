# String Calculator

Katas für Clean Code, TDD und Legacy-Code mit einer gemeinsamen Werkzeugkiste (Java 17, Maven, JUnit 4, Hamcrest,
Mockito, ApprovalTests, Cucumber, JaCoCo) und gemeinsamen opencode-Rollen. Jede Kata ist ein Ordner mit eigener `pom.xml`
und eigener AGENTS.md. Fertig ist eine Änderung, wenn `mvn -q verify` ohne Ausgabe und mit Exit-Code 0 endet.

| Kata | Worum es geht | Startstand |
|---|---|---|
| `stringcalculator/` | TDD von der ersten Zeile an (Roy Osherove) | leer, ein Testname |

## Loslegen

Voraussetzung: JDK 17 oder neuer und Maven (IntelliJ bringt Maven mit).

```bash
git clone https://github.com/sharpsharp-ai/stringcalculator.git
cd stringcalculator/stringcalculator # der Ordner einer Kata
mvn -q verify                      # keine Ausgabe heißt grün; schreibt den Abdeckungsbericht
../scripts/unabgedeckt.sh          # welche Zeilen und Verzweigungen die Tests nicht erreichen
```

IntelliJ: File → New → Project from Version Control, die URL einfügen. IntelliJ erkennt die `pom.xml` der Wurzel und
lädt jede Kata als Modul. `mvn -q verify` in der Wurzel baut alle.

## Mit opencode arbeiten

opencode im Kata-Ordner starten, nicht in der Wurzel: `cd stringcalculator`, dann `opencode --agent <rolle>`. Rollen,
Skills und Commands liegen einmal in `.opencode/` der Wurzel und gelten in jedem Kata-Ordner; die AGENTS.md der Wurzel
und die der Kata werden beide gelesen. In IntelliJ (ACP) den Session-Modus mit dem Rollennamen wählen.

Die Rollen, jede eine Markdown-Datei unter `.opencode/agents/`:

| Rolle | Tut | Darf ändern |
|---|---|---|
| `clean-code-reviewer` | Befunde mit Datei:Zeile und Refactoring, der Clean-Code-Report | nichts |

### Dazulernen

Jede Rolle darf ihre eigene Definition ändern, und nur die: am Ende ihrer Datei steht ein Abschnitt „Gelernt", in den
sie schreibt, was sie beim nächsten Mal wissen will, eine Zeile je Erkenntnis, mit Datum. So lernen die Rollen über
Sessions hinweg. Fremde Definitionen und `opencode.json` sind für alle gesperrt.

```text
/review                                      Befunde zu den Änderungen seit dem letzten Commit
/clean-code-report                           Punkte, Rang, Endgegner; Bericht in target/
```

| Datei | Wirkung |
|---|---|
| `AGENTS.md` | Befehle, Rollen, Regeln für alle Katas; je Kata eine zweite mit der Struktur |
| `opencode.json` | Rechte und die Bash-Whitelist |
| `.opencode/agents/*.md` | die Rollen: Rechte im Kopf, Prompt im Rumpf, „Gelernt" am Ende |
| `.opencode/commands/*.md` | die Commands; lesbares Markdown, das ist der Prompt |
| `.opencode/skills/*/SKILL.md` | die Skills: Regeln und Muster, ohne Bezug auf eine Kata |
| `scripts/` | Werkzeuge für die Kommandozeile, aus dem Kata-Ordner als `../scripts/…`; welche, steht in der AGENTS.md |
| `.github/workflows/ci.yml` | baut alle Katas bei jedem Push |

## Clean-Code-Report

Ein Blick auf den Code, ohne Gnade und ohne Gate: 30 Code Smells aus sechs Familien, Punkte, Rang, Radar und
Monster-Galerie; das Regelwerk mit jeder Schwelle und jedem Refactoring steht im Bericht.

```bash
cd stringcalculator
java ../.opencode/skills/clean-code-report/CleanCodeReport.java   # schreibt target/clean-code-report.html
```
