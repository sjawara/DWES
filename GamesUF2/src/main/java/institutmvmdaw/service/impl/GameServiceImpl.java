/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institutmvmdaw.service.impl;

import institutmvmdaw.domain.Game;
import institutmvmdaw.service.GameService;
import institutmvmdaw.repository.GamesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alumne_2n
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GamesRepository gamesRepository;

    @Override
    public List<Game> getAllGames() {
        return gamesRepository.getAllGames();
    }

    @Override
    public Game getGameById(String gameId) {
        return gamesRepository.getGameById(gameId);
    }

    @Override
    public List<Game> getGamesByCategory(String category) {
        return gamesRepository.getGamesByCategory(category);
    }

    @Override
    public void addGame(Game game) {
        gamesRepository.addGame(game);
    }

    @Override
    public List<Game> getGamesByYear(int yearMin, int yearMax) {
        return gamesRepository.getGamesByYear(yearMin, yearMax);
    }

    @Override
    public List<Game> getGamesByClau(String clau) {
        return gamesRepository.getGamesByClau(clau);
    }

    @Override
    public void updateGame(Game game) {
         gamesRepository.updateGame(game);
    }

    @Override
    public void deleteGame(String string) {
        gamesRepository.deleteGame(string);
    }

}
