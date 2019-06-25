package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}
	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository, SalvoRepository salvoRepository, ScoreRepository scoreRepository) {
		return (args) -> {
			// save a couple of players
			Player player1 = new Player("j.bauer@ctu.gov", passwordEncoder.encode("24"));
			Player player2 = new Player("c.obrian@ctu.gov",  passwordEncoder.encode("33"));
			Player player3 = new Player("kim_bauer@gmail.com",  passwordEncoder.encode("44"));
			Player player4 = new Player("t.almeida@ctu.gov",  passwordEncoder.encode("55"));

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

			//Add new Salvoes

			Set<Salvo> salvo1 = new HashSet<>();
			salvo1.add(new Salvo("1", Arrays.asList("B5", "C5", "F1")));
			salvo1.add(new Salvo("2", Arrays.asList("F2", "D5")));

			Set<Salvo> salvo2 = new HashSet<>();
			salvo2.add(new Salvo("1", Arrays.asList("B4", "B5", "B6")));
			salvo2.add(new Salvo("2", Arrays.asList("E1", "H3", "A2")));

			Set<Salvo> salvo3 = new HashSet<>();
			salvo3.add(new Salvo("1", Arrays.asList("A2", "A4", "G6")));
			salvo3.add(new Salvo("2", Arrays.asList("A3", "H6")));

			Set<Salvo> salvo4 = new HashSet<>();
			salvo4.add(new Salvo("1", Arrays.asList("B5", "D5", "C7")));
			salvo4.add(new Salvo("2", Arrays.asList("C5", "C6")));

			Set<Salvo> salvo5 = new HashSet<>();
			salvo5.add(new Salvo("1", Arrays.asList("G6", "H6", "A4")));
			salvo5.add(new Salvo("2", Arrays.asList("A2", "A3", "D8")));

			Set<Salvo> salvo6 = new HashSet<>();
			salvo6.add(new Salvo("1", Arrays.asList("H1", "H2", "H3")));
			salvo6.add(new Salvo("2", Arrays.asList("E1", "F2", "G3")));

			Set<Salvo> salvo7 = new HashSet<>();
			salvo7.add(new Salvo("1", Arrays.asList("A3", "A4", "F7")));
			salvo7.add(new Salvo("2", Arrays.asList("A2", "G6", "H6")));

			Set<Salvo> salvo8 = new HashSet<>();
			salvo8.add(new Salvo("1", Arrays.asList("B5", "C6", "H1")));
			salvo8.add(new Salvo("2", Arrays.asList("C5", "C7", "D5")));

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

			gamePlayerRepository.save(new GamePlayer(player1, game1, ships1, salvo1));
			gamePlayerRepository.save(new GamePlayer(player2, game1, ships2, salvo2));
			gamePlayerRepository.save(new GamePlayer(player3, game2, ships3, salvo3));
			gamePlayerRepository.save(new GamePlayer(player4, game2, ships4, salvo4));
			gamePlayerRepository.save(new GamePlayer(player2, game3, ships5, salvo5));
			gamePlayerRepository.save(new GamePlayer(player4, game3, ships6, salvo6));
			gamePlayerRepository.save(new GamePlayer(player2, game4, ships7, salvo7));
			gamePlayerRepository.save(new GamePlayer(player1, game4, ships8, salvo8));

			// Add new Scores

			Score score1 = new Score(player1, game1, 1d);
			Score score2 = new Score(player2, game1, 0d);
			Score score3 = new Score(player3, game2, 0.5);
			Score score4 = new Score(player4, game2, 0.5);
			Score score5 = new Score(player2, game3, 1d);
			Score score6 = new Score(player4, game3, 0d);
			Score score7 = new Score(player2, game4, 0.5);
			Score score8 = new Score(player1, game4, 0.5);


			scoreRepository.save(score1);
			scoreRepository.save(score2);
			scoreRepository.save(score3);
			scoreRepository.save(score4);
			scoreRepository.save(score5);
			scoreRepository.save(score6);
			scoreRepository.save(score7);
			scoreRepository.save(score8);

		};
	}
}

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	PlayerRepository playerRepository;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(inputName-> {
			Player player = playerRepository.findByUserName(inputName);
			if (player != null) {
				if(player.getUserName() == "j.bauer@ctu.gov")
				return new User(player.getUserName(), player.getPassword(),
						AuthorityUtils.createAuthorityList("USER", "ADMIN"));
				else {
				return new User(player.getUserName(), player.getPassword(),
						AuthorityUtils.createAuthorityList("USER"));}

			} else {
				throw new UsernameNotFoundException("Unknown user: " + inputName);
			}
		});
	}
}

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/rest/**").hasAuthority("ADMIN")
				.antMatchers("/api/game_view/**").hasAuthority("USER")
				.antMatchers("/web/**").permitAll()
				.antMatchers("/api/**").permitAll()
				;
		http.formLogin()
				.usernameParameter("name")
				.passwordParameter("pwd")
				.loginPage("/api/login")
				;
		http.logout().logoutUrl("/api/logout")
				;

		// turn off checking for CSRF tokens
		http.csrf().disable();

		// if user is not authenticated, just send an authentication failure response
		http.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

		// if login is successful, just clear the flags asking for authentication
		http.formLogin().successHandler((req, res, auth) -> clearAuthenticationAttributes(req));

		// if login fails, just send an authentication failure response
		http.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

		// if logout is successful, just send a success response
		http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
	}

	private void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
	}



}


