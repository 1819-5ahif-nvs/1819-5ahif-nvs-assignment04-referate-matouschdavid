package logic;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import entities.Act;
import entities.Show;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Stateless
public class ShowFacade {

    private List<Show> shows = new ArrayList<>();

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public List<Show> getAllShows(){
        return shows;
    }

    public void loadData(Firestore db) throws ExecutionException, InterruptedException {

    }

}
