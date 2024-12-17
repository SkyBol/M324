# Kennzahlen
In diesem File folgt eine kurze Analyse welche Kennzahlen es gibt und wie man diese Erfassen kann. Zusätzlich folgt eine Einschätzung wie sinnvoll sie sind für unser Projekt.

## DORA-Kennzahlen

Das DORA-Team von Google hat vier allgemeinen Kennzahlen identifiziert, die die Performance von Software-Entwicklungsteams präzise abbilden.

- Deployment-Häufigkeit\
Es wird angegeben, wie häufig mit der CI/CD-Pipeline die Applkation in die Produktivität deployed wird.
- Vorlaufzeit (Time to Delivery)\
DORA misst hier die Zeit vom letzten Code-Commit bis zum Deployment.
- Aussfallrate von Änderungen\
  Die Änderungsausfallrate bezeichnet den Anteil der in die Produktion übernommenen Änderungen, die zu Ausfällen oder Fehlern führen und entweder ein Rollback oder einen Hotfix erfordern. 
- Mittlere Wiederherstellungszeit\
  Die mittlere Wiederherstellungszeit (mean time to recovery/resolution, MTTR) gibt die Zeit an, die benötigt wird, um einen Ausfall in der Produktion zu beheben

## Weitere Kennzahlen
- Testabdeckung
- Kundenrückmeldungen pro Release
- Geschätzte Zeit vs Actual Aufwand
- Durchnttilche Zeit pro Issue

## Automatisieren mit GitHub Metrics
Viele Kennzahlen werden von Github schon getracked, oder können getrcked werden. Sobald wir mit Github Actions arbeiten, also beim Einsatz von CI/CD Piplines werden diese Erfasst.

## Interne Kennzahlen
Gewisse Internekennzahlen können in Github über Repository Insights resp. Projekt Insights aufgerufen werden.
