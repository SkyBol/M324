## 3.12.2024
Ich finde es beeindruckend wie gross und komplex das Thema ist. Bis anhin war alles klar und logisch so wie es in meiner Firma praktiziert wurde. Auch wenn es alle etwas anders machen, im Grund ist es überall ähnlich. 
Aber erst wenn man selbst so eine Struktur von Beginn an aufbaut, merkt man das.

#### Feedback YN
Ich hatte dies wohl das letzte Mal übersehen :(. Gehe auf spezifische Themen ein. Was hast du neues gelernt und vor allem wie könntest du es bei der Firma anwenden. Oder wie könntest du eines der Themen verbessern. Oder das gleiche auch bei deiner Gruppe.

## 17.12.2024
- Beim Research über die Kennzahlen habe ich mich unteranderem mit den 4 Kennzahlen vom DORA-Team von Google auseinander gesetzt. Dies erscheint mir wie eine Art verbreiteter Standart zu sein, welcher mir bislang unbekannt war.
- Durch das Aufsetzten der Projektstrucktur und der initalisierung eines Docker-Compose Setups,  konnt ich für mich noch einmal Docker und vorallem Docker-Compose repetieren. Dies ist etwas untergegangen da ich in der Firma nicht oft, resp. fast garnie mit Docker direkt arbeiten muss.
  
## 14.01.2024
Heute hatte ich leider fast keine Zeit um an unserem Projekt zu arbeiten, da ich ein Problem mit der Verbindung von meinem Windows PC zum Datenbank-Dockercontainer hatte. Nach vielen verschiedenen Versuchen das Problem zubeheben, war die Lösung für den aufgewendeten Aufwand viel zu simple:
Der Port 5432 unter welchem der Container von aussen erreichbar ist, war bereits von einem anderen Prozess auf meinem Computer beleget. Nach dem ich den Port mit ```taskkill /PID <PID> /F``` "abgeschossen" habe, hatte ich wieder Zugriff und konnte weiterentwicklen.
#### Learings
Bei kuriosen Fehlermeldungen während dem Verbindungsaufbau auch mal prüfen, ob der Port schon von einem anderen Service verwendet wird. 
