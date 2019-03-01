package endpoints;

import entities.Show;
import logic.ShowFacade;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("shows")
public class ShowEndPoint {

    @Inject
    ShowFacade showFacade;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Show> getAllGames(){
        return showFacade.getAllShows();
    }
}
