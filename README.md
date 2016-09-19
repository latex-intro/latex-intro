# Präsentationen für Latex-Kurse

Dies ist eine Sammlung an Folien für die verschiedenen
Latex-Einführungsveranstaltungen an der Uni Bremen. Sie wird entwickelt von der
Arbeitsgruppe Latex-Kurse (Mail: latex-kurse@mailman.zfn.uni-bremen.de).

## Konfiguration

Zur Erstellung eine an eine Veranstaltung angepasste Präsentation kann wie
unten beschrieben angelegt werden. Dann kann die Folienauswahl und Reihenfolge
individuell geändert werden.

Folgende Dinge können angepasst werden:

- In der Standardeinstellung werden für Übungen und die Präsentation URLs
  angezeigt, wo diese herunterzuladen sind. Diese können angepasst werden
    - Übungen: `\renewcommand{\exerciseurl}{URL}`
    - Folien: `\renewcommand{\exerciseurl}{URL}`
    - Wenn beides zusammen woanders verfügbar ist (z.B. StudIP), kann der gesamte
      Text mit `\renewcommand{\exercisesource}{Die Folien findet ihr hier}`

## Benutzerdefinierte Funktionen zur Layoutvereinheitlichung (aka Styleguide)

Die folgenden Funktionen sind in der `config/functions.tex` definiert und
sollten nach möglichkeit verwendet werden. Für Beispiele sollte die `verbatim`
Umgebung oder `\verb` Benutzt werden.

- `\pkg{Name}`: Zur Formatierung von Paketnamen
- `\umg{Name}`: Zur Formatierung von Umgebungsnamen
- `\cmd{Befehl}`: Setzt `\Befehl` in Typewriter-Schrift
- `\marg{Argument}`: Für Plfichtargumente (mandatory arguments), setzt `{<Argument>}`
- `\oarg{Argument}`: Für optionale Argumente, setzt `[<Argument>]`
- `\uebung{Nummern}`: Für Übungsfolien, erstellt eine Folie mit der Quelle der
  Folien und des Übungszettels, darauf Außerdem die Aufforderung, die angegebene
  Aufgabe zu bearbeiten

## Daten-Struktur

Aufgrund des Designs von Latex ist es nicht möglich, Pakete nach
`\begin{document}` zu laden. Daher sind alle `usepackage`-Befehle in der Datei
`config/head.tex` enthalten, unabhängig davon ob diese Pakete gebraucht werden.
Dies sollte zu keinen unerwünschten Nebenwirkungen führen.

Die eigentlichen Abschnitte der Präsentation sind in dem Ordner `sections`
enthalten. Dieser Ordner besitzt weiterhin eine Ebene von Unterordnern, um eine
übersichtliche Struktur des Dateibaums zu gewährleisten und gleichzeitig eine
granulare Auswahl an Themen zu ermöglichen. Um bei Benutzung des ganzen
Unterordners nicht alle Dateien extra angeben zu müssen, sollte es im Ordner
`sections` zusätzlich eine `<Unterordner>.tex`-Datei geben, in der alle Dateien
eingebunden werden.

Statische Dateien wie Bilder sind in dem Ordner `images` zu speichern. Außnahmen
sind momentan noch `sty`-Dateien und dergleichen, da Latex nach diesem im
texmf-Tree und dem aktuellen Verzeichnis sucht. Einbinden geht dann einfach mit
dem Dateinamen, da der `graphicspath` entsprechend gesetzt ist.

Die jeweilige auf den Studiengang angepasste Version der Präsentation sollte
dann im Wurzelverzeichnis des Repositories gespeichert werden. Vorgeschlagenes
Namesschema: `presentation-<Fach>[-<Typ>].tex`. Typ kann benutzt werden, um z.B.
eine Version als Handout zu compilieren und eine normal mit Pausen.

Eine Übersetzung des Dokuments ist dann ohne Hilfe von Makefiles mit
`latexmk -pdf <Dateiname>` möglich. Alle Abhängigkeiten werden hierbei berücksichtigt.
