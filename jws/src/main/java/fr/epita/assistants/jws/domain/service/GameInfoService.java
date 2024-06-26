package fr.epita.assistants.jws.domain.service;

import fr.epita.assistants.jws.data.model.GameModel;
import fr.epita.assistants.jws.data.model.PlayerModel;
import fr.epita.assistants.jws.data.repository.GameRepository;
import fr.epita.assistants.jws.presentation.rest.response.CreatePlayerResponse;
import fr.epita.assistants.jws.presentation.rest.response.GameDetailResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GameInfoService {
    @Inject
    GameRepository gameRepository;

    @Transactional
    public GameDetailResponse getInfo(long game_id)
    {
        GameModel game = gameRepository.findById(game_id);
        if (game == null)
        {
            return null;
        }

        List<PlayerModel> players = game.players_id;
        List<CreatePlayerResponse> players_list = new ArrayList<>();
        for (PlayerModel player:players)
        {
            players_list.add(new CreatePlayerResponse(player.id, player.name, player.lives, player.posx, player.posy));
        }

        return new GameDetailResponse(game.id, game.starttime, game.state, players_list, game.map);
    }
}
