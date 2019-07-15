package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    @OneToMany(mappedBy="gamePlayer", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Salvo> salvos = new HashSet<>();

    @OneToMany(mappedBy = "gamePlayer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Ship> ships = new HashSet<>();



    private LocalDateTime joinDate;



    public GamePlayer() {
    }

    public GamePlayer(Player player, Game game, Set<Ship> ships, Set<Salvo> salvos){
        this.player = player;
        this.game = game;
        this.addShips(ships);
        this.joinDate = LocalDateTime.now();
        this.addSalvo(salvos);
    }




    public void addShips(Set<Ship> ships) {
        ships.forEach(this::addShip);
    }


    public void addShip(Ship ship) {
        ship.setGamePlayer(this);
        this.ships.add(ship);
    }


    public void addSalvo(Set<Salvo> salvos) {
        salvos.forEach(this::addSalvo);
    }


    public void addSalvo(Salvo salvo) {
        salvo.setGamePlayer(this);
        this.salvos.add(salvo);
    }

    public Player getPlayer() {
        return player;
    }


    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setScore(Score score){
    }



    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public long getId() {
        return id;
    }

    public Set<Salvo> getSalvos() {
        return salvos;
    }
    public Score getScore(){
        return player.getScore(this.game);
    }





    public Map<String, Object> makeGamePlayerDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("gpid", id);
        dto.put("created", game.getCreationDate());
        dto.put("player", player.makePlayerDTO());
        if(getScore() != null)
            dto.put("score", getScore().makeScoreDTO());
        else
            dto.put("score", null);
        return dto;
    }

    public Map<String, Object> makeGameViewDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", this.game.getId());
        dto.put("created", this.game.getCreationDate());
        dto.put("Gameplayers", this.game.getGamePlayers().stream()
                .map(GamePlayer::makeGamePlayerDTO)
                .collect(Collectors.toList()));
        dto.put("Ships", this.ships.stream()
                .map(Ship::makeShipDTO)
                .collect(Collectors.toList()));
        dto.put("Salvos", this.game.getGamePlayers().stream()
                .flatMap(gamePlayer -> gamePlayer.getSalvos().stream().map(Salvo::makeSalvoDTO))
                .collect(Collectors.toList()));
        return dto;
    }

}