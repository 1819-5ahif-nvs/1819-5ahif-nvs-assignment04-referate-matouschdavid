# `<Thema des Referats>`

## Java-EE Client für Firebase
In diesem Beispiel verbinden wir uns zu einer Firebasedatenbank mithilfe der project-id und lesen anschließend die Daten über einen Rest-Service wieder aus.

InitBean

In der InitBean müssen wir uns zuerst mit Firebase verbinden. Dazu benötigen wir eine project-id, die wir uns in der Firebaseconsole für unser Projekt generieren lassen können. In meinem Beispiel verbinden wir uns zur Datenbank von Ludimus. Der Lesezugriff auf die Collection "Games" ist frei, der Lesezugriff auf alle anderen Collections und der Schreibzugriff sind blockiert. Auf https://console.firebase.google.com kann sich jedoch jeder ein eigenes Projekt erstellen.

Code zum Verbinden zur Datenbank:

        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setProjectId(PROJECTID)
                .build();         
        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();
 
 Jetzt müssen wir nur noch eine Collection auswählen und die Daten fetchen.
 
        CollectionReference colRef = db.collection("games");
        ApiFuture<QuerySnapshot> future = colRef.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
 
 Nun bleibt nur noch das parsen ausständig:
 
        List<Game> games = new ArrayList<Game>();
        for (QueryDocumentSnapshot doc :
                documents) {
            Game game = doc.toObject(Game.class);
            game.setId(doc.getId());
            games.add(game);
        }

- Kurze Beschreibung
- Status der Ausarbeitung: funktiniert, funktioniert nicht, weil, ...
- Wie kann das Beispiel gestartet werden? `mvn package`, gefolgt von ... 
- URIs des REST-Endpoints

## Beispiel 2

...

## Ausarbeitung des Referats
