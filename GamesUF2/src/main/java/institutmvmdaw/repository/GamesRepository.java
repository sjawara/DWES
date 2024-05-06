/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institutmvmdaw.repository;
import institutmvmdaw.domain.Game;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author alumne_2n
 */

public interface GamesRepository {
    
  List <Game> getAllGames();
  Game getGameById(String gameId);
  List<Game> getGamesByCategory(String category);
  Set<Game> getGamesByFilter(Map<String, List<String>> filterParams);
  void addGame(Game game);
  List<Game> getGamesByYear(int yearMin, int yearMax);
  
  List<Game> getGamesByClau(String clau);
  void updateGame(Game game);
  void deleteGame(String game);


}
