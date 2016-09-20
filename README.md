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
- Um für verschiedene Übungszettel immer die korrekten Nummern für die Übungen
  zu benutzen, muss der Übungszettel im Verzeichnis `uebungen` gespeichert werden
  und mit `\registerexercise{<Dateiname>}` bekannt gemacht werden (Dateiname 
  _ohne_ Endung).

## Benutzerdefinierte Funktionen zur Layoutvereinheitlichung (aka Styleguide)

Die folgenden Funktionen sind in der `config/functions.tex` definiert und
sollten nach Möglichkeit verwendet werden. Für Beispiele sollte die `verbatim`
Umgebung oder `\verb` benutzt werden.

- `\pkg{Name}`: Zur Formatierung von Paketnamen
- `\umg{Name}`: Zur Formatierung von Umgebungsnamen
- `\cmd{Befehl}`: Setzt `\Befehl` in Typewriter-Schrift
- `\marg{Argument}`: Für Plfichtargumente (mandatory arguments), setzt `{<Argument>}`
- `\oarg{Argument}`: Für optionale Argumente, setzt `[<Argument>]`
- `\uebung{Label}`: Für Übungsfolien, erstellt eine Folie mit der Quelle der
  Folien und des Übungszettels, darauf Außerdem die Aufforderung, die angegebene
  Aufgabe zu bearbeiten. Das Label muss im registrierten Übungszettel vorhanden
  sein, alternativ können auch die beiden Label `<label>:first` und `<label>:last`
  vorhanden sein, dann wird ein Bereich von Ausgaben ausgegeben. _Die Variante mit
  `first` und `last` wird priorisiert!_
- `\loesung[Label]{Titel}{Body}`: Erstellt eine Lösungsfolie, mit dem gegebenen
  Titel und dem Body. _Verbatim ist nicht möglich, da die Folie nicht `fragile`
  ist_. Die Lösungen werden im Handout-Modus nicht angezeigt. Wenn das optionale
  Argument _Label_ verwendet wird, wird die Folie nur augegeben, wenn das Label
  im registrierten Übungszettel vorhanden ist. So kann man die Folien ausblenden,
  wenn sie nicht benötigt werden.

## Einstellungen in der Präambel

- `\hidesolutions`: Zeigt niemals Lösungen an.
- `\forcesolutions`: Zeigt immer alle Lösungen an, auch in Handouts
- `\registerexercise{<Dateiname>}`: Registriert eine Übung aus dem `uebungen`-
  Verzeichnis.
- `\handoutsolutions`: Zeigt Lösungen auch in Handouts an, alle anderen
  Auswahlregeln bleiben bestehen

## Übungszettel

Die Übungszettel sind im Verzeichnis `uebungen` abgelegt, sie folgen weitestgehend
dem selben Schema wie die Folien. Folgende Umgebungen stehen zur Verfügung:

- `uebung` für die einzelnen Übungsaufgaben, innerhalb jeder section einfach alles
  in eine `uebung`s-Umgebung packen.
- `hinweis` für einen Abgesetzen Hinweis zu einer Aufgabe
- `loesung` für eine Lösung, z.B. für Tutoren oder einen selber, wird standardmässig
  nicht mit ausgegeben.
- `mathe` zeichnet einen Kasten um den Inhalt, zum Absetzen größerer Blöcke zum
  nachtexen.

Außerdem gibt es noch die folgenden Befehle:
- `\showsolutions`: Gibt die Lösungen aus

Die folgenden Befehle aus den Folien sind ebenfalls verfügbar: `\pkg`, `\umg`, `\cmd`,
`\marg`, `\oarg`.

Um den Titel anzupassen, kann man den Studiengang/Kursnamen mit eingeben, er wird
dann direkt vor dem Jahr angezeigt. Dazu einfach `\renewcommand{\course}{Titel}`
nach dem `\input{head}` benutzen.

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
