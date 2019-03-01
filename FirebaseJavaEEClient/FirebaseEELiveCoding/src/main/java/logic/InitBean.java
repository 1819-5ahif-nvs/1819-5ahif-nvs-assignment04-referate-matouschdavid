package logic;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Startup
@Singleton
public class InitBean {

    @Inject
    private ShowFacade showFacade;

    private static final String PROJECTID = "fir-referat-2a269";
    private static final String SERVICEFILEPATH = "";

    @PostConstruct
    public void init() throws IOException, ExecutionException, InterruptedException {
        FileInputStream serviceAccount = new FileInputStream(SERVICEFILEPATH);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://fir-referat-2a269.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();

        showFacade.loadData(db);
    }
}
