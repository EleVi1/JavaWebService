package fr.epita.assistants.jws.presentation.rest;

import fr.epita.assistants.jws.domain.entity.Game;
import fr.epita.assistants.jws.domain.service.GameListService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class Endpoints{

    private GameListService gameListService = new GameListService();
    @GET
    @Path("/games")
    public List<Game> getAllGames()
    {
        List<Game> res =  gameListService.getAll();
        return res;
    }

//    @GET
//    @Path("/games/{gameId}")
//    public Game getGameInfo(@PathParam("gameId") long gameId)
//    {
//        //TODO
//    }


//    @POST
//    @Path("/games/")
//    public Game createGame()
//    {
//        //TODO
//    }

//    @POST
//    @Path("/games/{gameId}")
//    public Response joinGame(@PathParam("gameId") long gameId)
//    {
//        //TODO
//    }

//    @PATCH
//    @Path("/games/{gameId}/start")
//    public Response startGame(@PathParam("gameId") long gameId)
//    {
//        //TODO
//    }

//    @POST
//    @Path("/reverse")
//    public Response reverse(ReverseRequest response)
//    {
//        if (response == null || response.content == null ||response.content.isEmpty() || response.content.compareTo("") == 0)
//        {
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//        ReverseResponse rep = new ReverseResponse(response);
//        if (rep == null || rep.original == null || rep.original.isEmpty())
//        {
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//        return Response.ok(rep, MediaType.APPLICATION_JSON_TYPE).build();
//    }
}