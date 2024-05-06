/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institutmvmdaw.service;

/**
 *
 * @author alumne_2n
 */


import institutmvmdaw.domain.Game;
import java.util.List;

public interface GameService {

    List<Game> getAllGames();
    List<Game> getGamesByClau(String clau);
    List<Game> getGamesByCategory(String category);
    Game getGameById(String gameId);
    void addGame(Game game);
    List<Game> getGamesByYear(int yearMin, int yearMax);
    void updateGame(Game game);
    void deleteGame(String gameId);

}
