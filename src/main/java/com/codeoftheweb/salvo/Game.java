package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private Set<GamePlayer> gamePlayers = new HashSet<>();



    private LocalDateTime creationDate;

    public Game() {
    }

    public Game(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void addGamePlayer(GamePlayer gamePlayer) {
        gamePlayer.setGame(this);
        this.gamePlayers.add(gamePlayer);
    }

    public long getId() {
        return id;
    }

    public Set<GamePlayer> getGamePlayers(){ return gamePlayers;}


    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Map<String, Object> makeGameDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", id);
        dto.put("creation", creationDate);
        dto.put("players", gamePlayers.stream()
                .map(GamePlayer::makeGamePlayerDTO)
                .collect(Collectors.toList()));
        return dto;
    }


}