package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoController {

    @Autowired
    private GameRepository gameRepository;

    @RequestMapping("/games")
    public List<Map<String, Object>> getAll() {
        return gameRepository.findAll()
                .stream()
                .map(Game::makeGameDTO)
                .collect(Collectors.toList());
    }

    @Autowired
    private ShipRepository shipRepository;

    @RequestMapping("/ships")
    public List<Map<String, Object>> getGames() {
        return shipRepository.findAll()
                .stream()
                .map(Ship::makeShipDTO)
                .collect(Collectors.toList());
    }


    @Autowired
    private GamePlayerRepository gamePlayerRepository;


    @RequestMapping("/game_view/{gameplayerID}")
    private Map<String, Object> getGamePlayers(@PathVariable long gameplayerID) {
        return gamePlayerRepository.findById(gameplayerID).get().makeGameViewDTO();
    }

}




