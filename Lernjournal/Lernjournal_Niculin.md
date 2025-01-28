## 3.12.2024
Ich finde es beeindruckend wie gross und komplex das Thema ist. Bis anhin war alles klar und logisch so wie es in meiner Firma praktiziert wurde. Auch wenn es alle etwas anders machen, im Grund ist es überall ähnlich. 
Aber erst wenn man selbst so eine Struktur von Beginn an aufbaut, merkt man das.

#### Feedback YN
Ich hatte dies wohl das letzte Mal übersehen :(. Gehe auf spezifische Themen ein. Was hast du neues gelernt und vor allem wie könntest du es bei der Firma anwenden. Oder wie könntest du eines der Themen verbessern. Oder das gleiche auch bei deiner Gruppe.

## 17.12.2024
- Beim Research über die Kennzahlen habe ich mich unteranderem mit den 4 Kennzahlen vom DORA-Team von Google auseinander gesetzt. Dies erscheint mir wie eine Art verbreiteter Standart zu sein, welcher mir bislang unbekannt war.
- Durch das Aufsetzten der Projektstrucktur und der initalisierung eines Docker-Compose Setups,  konnt ich für mich noch einmal Docker und vorallem Docker-Compose repetieren. Dies ist etwas untergegangen da ich in der Firma nicht oft, resp. fast garnie mit Docker direkt arbeiten muss.
  
## 14.01.2025
Heute hatte ich leider fast keine Zeit um an unserem Projekt zu arbeiten, da ich ein Problem mit der Verbindung von meinem Windows PC zum Datenbank-Dockercontainer hatte. Nach vielen verschiedenen Versuchen das Problem zubeheben, war die Lösung für den aufgewendeten Aufwand viel zu simple:
Der Port 5432 unter welchem der Container von aussen erreichbar ist, war bereits von einem anderen Prozess auf meinem Computer beleget. Nach dem ich den Port mit ```taskkill /PID <PID> /F``` "abgeschossen" habe, hatte ich wieder Zugriff und konnte weiterentwicklen.
#### Learings
Bei kuriosen Fehlermeldungen während dem Verbindungsaufbau auch mal prüfen, ob der Port schon von einem anderen Service verwendet wird. 

## 28.01.2025
Heute war sehr spannend, da ich mein Wissen mit Git Hub Actions erweitern konnte. Im Zusammenhang mit dem CD Task habe ich unsere App in einem neuen Workflow auf einen Docker Swarm deployed. Dies ging wie folgt:
1. Manager Instanz in AWS erstellt
2. Darauf den command ```docker swarm init```ausgeführt
3. Worker Instanz in AWS erstellt
4. Darauf den command ```docker swarm join``` um dem swarm manager zu joinen
5. Key pair generiert um sich mit github actions zu authentifizieren
6. ```
   deploy:
      replicas: 3
      restart_policy:
        condition: on-failure
   ```
   Im docker-compose ergänzt
7. Workflow einrichten --> pulled die aktuellsten Images (erstellt in CI Pipeline des PR), kopiert die db files auf die instanz, sowie das docker compose file, und führt dann folgenden command aus damit die App auf dem swarm leuft: ```docker stack deploy --compose-file /home/ec2-user/app/docker-compose.yaml app```
8. Der Workflow wird jeweils bei einem push in den dev Branch getriggerd
9. Resultat aus ```docker stack services ls```:
![grafik](https://github.com/user-attachments/assets/f8cefaf8-70fb-4502-8169-7564108faec0)
10. Für die Datenbank haben wir jeweils nur eine Replica, für die beiden Springapps 2.

Des weiteren habe ich danach einen 2 Job im Workflow erstellt, welche die Postmantests noch gegen diese Instanzen ausführt, um deren funktionalitäten zu Prüfen.
Heute hat mir sehr spass gemacht, da ich viel neues lernen konnte.


