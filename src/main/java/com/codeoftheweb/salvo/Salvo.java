package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Salvo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String turn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayer_id")
    private GamePlayer gamePlayer;

    @ElementCollection
    @Column(name = "locations")
    private List<String> salvoLocations;


    public Salvo() {
    }

    public Salvo(String turn, List<String> salvoLocations) {
        this.turn = turn;
        this.salvoLocations = salvoLocations;
    }


    public List<String> getSalvoLocations() {
        return salvoLocations;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public Map<String, Object> makeSalvoDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", id);
        dto.put("turn", turn);
        dto.put ("locations", salvoLocations);
        dto.put("player", getGamePlayer().getPlayer().makePlayerDTO());
        return dto;
    }
}


