# SoftwareProject-Server

# Aufgabe 08

|  Was               |  Wie                           |
| --------------- | --------------------------- |
| __Titel:__      | Transfer von Dateien |
| __Deadline:__   | `2020-01-31T12:00:00+02:00` |
| __Abgabepfad:__ | `Task_08`                   |
| __Unittest:__   | ``              |

!!! attention
> - Abgaben nach der Deadline: __0 Punkte__!
> - Achtung, Deadline ist __UTC__
> - Abgaben in falschem Abgabepfad: __0 Punkte__!
> - Abgaben die nicht compilieren: __0 Punkte__!

## Beschreibung

Erstellen Sie zwei Programme zum Dateitransfer   


### Aufgabenstellung

Erstellen Sie zwei Programme, je ein Client und einen Server, sodass

- das Client-Programm, je nach Aufruf eine bestimmte Datei BZIP2-komprimiert an den Server sendet oder 
  von ihm empfängt. Das Client-Programm unterstützt folgende Kommandozeilenaufrufe:
   - list &lt;IP-Adresse&gt; &lt;Port&gt; {&lt;Pattern&gt;}
   - send &lt;IP-Adresse&gt; &lt;Port&gt; &lt;Filename&gt; 
   - receive &lt;IP-Adresse&gt; &lt;Port&gt; &lt;Filename&gt;
   - delete &lt;IP-Adresse&gt; &lt;Port&gt; &lt;Filename&gt; // Nur für 4-er Gruppen
- das Server-Programm die Gegenseite implementiert. 
  
### Hinweise für die Implementierung

** Bitte geben Sie grundsätzlich alle Klassen ab, auch diejenigen, die Sie nicht 
implementieren müssen. **

** Anstelle eines Unit-Tests läuft ab Donnerstag, 14.01.21, 19:00 eine Server-Implementierung im Lida, die 
dort lokal über den Port 28765 erreichbar ist. **
 
## Vorlagen
```java
package de.hft_stuttgart.ip1;

public interface FileServer implements Remote {
    FileTransfer getTransfer(String user, String password) throws RemoteException;
}

public interface FileTransfer implements Remote {
    String[] listFiles(String pattern) throws RemoteException;
    void sendFile(String name, byte [] data) throws RemoteException;
    byte[] receiveFile(String name) throws RemoteException;
    // Nur für 4-er Gruppen zu implementieren
    boolean deleteFile(String name) throws RemoteException;
}

## Links


Moritz: Liste

Anton: 	Löschen

Philip: Senden

Luca:	Empfangen

