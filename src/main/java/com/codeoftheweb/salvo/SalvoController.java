package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class SalvoController {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private SalvoRepository salvoRepository;
    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping("/games")
    public Map<String, Object> getAll(Authentication authentication) {
                Map<String, Object> dto = new LinkedHashMap<String, Object>();

                if (isGuest(authentication))
                    dto.put("player", null);
                else dto.put("player", playerRepository.findByUserName(authentication.getName()).makePlayerDTO());
                dto.put("games",  gameRepository.findAll()
                        .stream()
                        .map(Game::makeGameDTO)
                        .collect(Collectors.toList()));
                return dto;




    }




    @RequestMapping("/ships")
    public List<Map<String, Object>> getGames() {
        return shipRepository.findAll()
                .stream()
                .map(Ship::makeShipDTO)
                .collect(Collectors.toList());
    }


    @RequestMapping("/game_view/{gameplayerID}")
    private ResponseEntity<Map<String, Object>> getGamePlayers(@PathVariable long gameplayerID, Authentication authentication) {
        Player player = playerRepository.findByUserName(authentication.getName());
        GamePlayer gamePlayer = gamePlayerRepository.findById(gameplayerID).get();

        if(gamePlayer.getPlayer().getId()  == player.getId())
            return new ResponseEntity<>(gamePlayer.makeGameViewDTO(), HttpStatus.OK);
        else
            return new ResponseEntity<>(makeMap("error", "no es tu juego"), HttpStatus.FORBIDDEN);

    }






        @PostMapping("/players")
        public ResponseEntity<Object> register(
            @RequestParam String name, @RequestParam String pwd) {

        if (name.isEmpty() || pwd.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        if (playerRepository.findByUserName(name) != null) {
            return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);
        }

        playerRepository.save(new Player(name, passwordEncoder.encode(pwd)));
        return new ResponseEntity<>(HttpStatus.CREATED);


    }

    //@PostMapping("/games")
    //public ResponseEntity<Object> createGame(){
     //   GamePlayer gamePlayer = gamePlayerRepository.findById(gameplayerID).get();


    //}


    private boolean isGuest(Authentication authentication) {
        return authentication == null || authentication instanceof AnonymousAuthenticationToken;
    }
    private Map<String, Object> makeMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }


}




