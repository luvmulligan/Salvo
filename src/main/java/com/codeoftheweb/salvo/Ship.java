package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String type;

    @ElementCollection
    @Column(name = "locations")
    private List<String> shipLocations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayer_id")
    private GamePlayer gamePlayer;


    public Ship() {
    }

    public Ship(String type, List<String> shipLocations) {
        this.type = type;
        this.shipLocations = shipLocations;
    }

    public String getType() {
        return type;
    }

    public List<String> getShipLocations() {
        return shipLocations;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public Map<String, Object> makeShipDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("locations", shipLocations);
        dto.put ("ships", type);
        return dto;

    }
}



