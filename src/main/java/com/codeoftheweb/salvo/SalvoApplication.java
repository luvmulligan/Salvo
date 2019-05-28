package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository) {
		return (args) -> {
			// save a couple of players
			Player player1 = new Player("j.bauer@ctu.gov");
			Player player2 = new Player("c.obrian@ctu.gov");
			Player player3 = new Player("kim_bauer@gmail.com");
			Player player4 = new Player("t.almeida@ctu.gov");

			// Add new ships

			Set<Ship> ships1 = new HashSet<>();
			ships1.add(new Ship ("Destroyer", Arrays.asList("H2", "H3", "H4")));
			ships1.add(new Ship ("Submarine", Arrays.asList("E1", "F1", "G1")));
			ships1.add(new Ship ("Patrol Boat", Arrays.asList("B4", "B5")));

			Set<Ship> ships2 = new HashSet<>();
			ships2.add(new Ship ("Destroyer", Arrays.asList("B5", "C5", "D5")));
			ships2.add(new Ship ("Patrol Boat", Arrays.asList("F1", "F2")));

			Set<Ship> ships3 = new HashSet<>();
			ships3.add(new Ship ("Destroyer", Arrays.asList("B5", "C5", "D5")));
			ships3.add(new Ship ("Patrol Boat", Arrays.asList("C6", "C7")));

			Set<Ship> ships4 = new HashSet<>();
			ships4.add(new Ship ("Submarine", Arrays.asList("A2", "A3", "A4")));
			ships4.add(new Ship ("Patrol Boat", Arrays.asList("G6", "H6")));

			Set<Ship> ships5 = new HashSet<>();
			ships5.add(new Ship ("Destroyer", Arrays.asList("B5", "C5", "D5")));
			ships5.add(new Ship ("Patrol Boat", Arrays.asList("C6", "C7")));

			Set<Ship> ships6 = new HashSet<>();
			ships6.add(new Ship ("Submarine", Arrays.asList("A2", "A3", "A4")));
			ships6.add(new Ship ("Patrol Boat", Arrays.asList("G6", "H6")));

			Set<Ship> ships7 = new HashSet<>();
			ships7.add(new Ship ("Destroyer", Arrays.asList("B5", "C5", "D5")));
			ships7.add(new Ship ("Patrol Boat", Arrays.asList("C6", "C7")));

			Set<Ship> ships8 = new HashSet<>();
			ships8.add(new Ship ("Submarine", Arrays.asList("A2", "A3", "A4")));
			ships8.add(new Ship ("Patrol Boat", Arrays.asList("G6", "H6")));




			playerRepository.save(player1);
			playerRepository.save(player2);
			playerRepository.save(player3);
			playerRepository.save(player4);

			// Save new games
			Game game1 = new Game(LocalDateTime.now());
			Game game2 = new Game(LocalDateTime.now().plusHours(1));
			Game game3 = new Game(LocalDateTime.now().plusHours(2));
			Game game4 = new Game (LocalDateTime.now().plusHours(3));


			gameRepository.save(game1);
			gameRepository.save(game2);
			gameRepository.save(game3);
			gameRepository.save(game4);

			// Add new Gameplayers

			gamePlayerRepository.save(new GamePlayer(player1, game1, ships1));
			gamePlayerRepository.save(new GamePlayer(player2, game1, ships2));
			gamePlayerRepository.save(new GamePlayer(player3, game2, ships3));
			gamePlayerRepository.save(new GamePlayer(player4, game2, ships4));
			gamePlayerRepository.save(new GamePlayer(player2, game3, ships5));
			gamePlayerRepository.save(new GamePlayer(player4, game3, ships6));
			gamePlayerRepository.save(new GamePlayer(player2, game4, ships7));
			gamePlayerRepository.save(new GamePlayer(player1, game4, ships8));



		};
	}
}
