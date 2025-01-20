# Konzept CI-Pipeline

Bei Pull requests auf den Develop-branch wird unsere CI-Pipeline durchgeführt. <br>
Diese führt Tests durch und wartet bis alle erfolgreich sind. <br>
Bei der erfolgreichen Durchführung von Tests fehlt noch das Approval von mindestens einem Teammitglied um mergen zu dürfen. <br>
Der merge wird danach manuell ausgeführt sobald alle tests erfolgreich sind und jemand approved hat. <br>
Wenn nicht alle Tests erfolgreich sind wird der Pull request rot angezeigt und es wird nochmal nach Änderungen gefragt. <br>

Commits auf den Main-branch sind völlig unabhängig von unserer Pipeline und lösen dadurch die Pipeline nicht aus. <br>
Dies nutzen wir um unsere Dokumentation zu pushen.