

# Java-EE Client für Firebase
In diesem Beispiel verbinden wir uns zu einer Firebasedatenbank mithilfe der project-id und lesen anschließend die Daten über einen Rest-Service wieder aus.

InitBean

In der InitBean müssen wir uns zuerst mit Firebase verbinden. Dazu benötigen wir eine project-id, die wir uns in der Firebaseconsole für unser Projekt generieren lassen können. In meinem Beispiel verbinden wir uns zu einer Datenbank, die eine NoSql Variante, der Datenbank des Wiedholungstest, sein soll. Auf https://console.firebase.google.com kann sich jedoch jeder ein eigenes Projekt erstellen.

Code zum Verbinden zur Datenbank:

        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setProjectId(PROJECTID)
                .build();         
        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();
 
 Jetzt müssen wir nur noch eine Collection auswählen und die Daten fetchen.
 
        CollectionReference colRef = db.collection("shows");
        ApiFuture<QuerySnapshot> future = colRef.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
 
 Nun bleibt nur noch das parsen ausständig:
 
        List<Show> shows = documents.stream().map(d -> {
            Show show = new Show();
            show = d.toObject(Show.class);
            return show;
        }).collect(Collectors.toList());
 
Shows haben jedoch eine Liste aus Referenzen von Act und diese kann nicht automatisch aufgelöst werden. Im Setter der Liste in Show müssen wir ähnlich, wie oben parsen:

         private List<Act> mapToAct(List<DocumentReference> acts){
                return acts.stream()
                        .map(a -> {
                            try {
                                return a.get().get().toObject(Act.class);
                            } catch (InterruptedException e) {
                                System.err.println(e.getMessage());
                            } catch (ExecutionException e) {
                                System.err.println(e.getMessage());
                            }
                            return null;
                        })
                        .collect(Collectors.toList());
            }
        
Diese Methode wird nun im Setter aufgerufen und der Typ des Parameters von List<Act> auf List<DocumentReference> geändert.
Acts haben wiederum eine Liste von ActMember, die wir mit dem selben Prinzip noch auflösen müssen.
        
Das Basisprogramm verfügt bereits über eine funktionierende Facade, in der nur noch der Setter von Shows aufgerufen werden muss.
Der Endpoint greift dann auf den Getter zu und die Daten sind über die URL: http://localhost:8080/firebaseEELiveCoding-1.0-SNAPSHOT/api/shows ansehbar.
