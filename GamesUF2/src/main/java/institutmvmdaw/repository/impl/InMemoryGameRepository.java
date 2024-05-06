/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institutmvmdaw.repository.impl;

import institutmvmdaw.domain.Game;
import institutmvmdaw.repository.GamesRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alumne_2n
 */
@Repository
public class InMemoryGameRepository implements GamesRepository {

    private List<Game> listOfGames = new ArrayList<Game>();

    public InMemoryGameRepository() {
        Game fortnite = new Game("id1", "fortnite", "epic games", 0f, 2018, 15, "battle royale", "pc");
        Game fifa23 = new Game("ff23", "fifa 2023", "EA SPORT", 60f, 2023, 15, "furbo", "pc");
        Game fifa21 = new Game("ff21", "fifa 2021", "EA SPORT", 60f, 2023, 15, "furbo", "pc");
        Game fifa20 = new Game("ff20", "fifa 2020", "EA SPORT", 60f, 2023, 15, "furbo", "pc");
        listOfGames.add(fifa20);
        listOfGames.add(fifa21);
        listOfGames.add(fifa23);
        listOfGames.add(fortnite);
    }

    @Override
    public List<Game> getAllGames() {
        return listOfGames;
    }

    public Game getGameById(String gameId) {
        Game gameById = null;
        for (Game game : listOfGames) {
            if (game != null && game.getId() != null
                    && game.getId().equals(gameId)) {
                gameById = game;
                break;
            }
        }
        if (gameById == null) {
            throw new IllegalArgumentException(
                    "No s'han trobat jocs amb el codi: " + gameId);
        }
        return gameById;
    }

    @Override
    public List<Game> getGamesByCategory(String category) {
        List<Game> gamesByCategory = new ArrayList<Game>();
        for (Game game : listOfGames) {
            if (category.equalsIgnoreCase(game.getCategoria())) {
                gamesByCategory.add(game);
            }
        }
        return gamesByCategory;
    }

    public Set<Game> getGamesByFilter(Map<String, List<String>> filterParams) {
        Set<Game> gamesByProducer = new HashSet<Game>();
        Set<Game> gamesInStockRange = new HashSet<Game>();
        Set<String> criterias = filterParams.keySet();
        long minStock = 0;
        long maxStock = 0;
        if (criterias.contains("empresa")) {
            for (String producerName : filterParams.get("empresa")) {
                for (Game game : listOfGames) {
                    if (producerName.equalsIgnoreCase(game.getEmpresa())) {
                        gamesByProducer.add(game);
                    }
                }
            }
        }
        if (criterias.contains("estoc")) {
            minStock = Long.parseLong(filterParams.get("estoc").get(0));
            maxStock = Long.parseLong(filterParams.get("estoc").get(1));

            for (Game game : listOfGames) {
                if ((game.getLimitDownload() >= minStock) && (game.getLimitDownload() <= maxStock)) {
                    gamesInStockRange.add(game);
                }
            }

        }
        gamesInStockRange.retainAll(gamesByProducer);
        return gamesInStockRange;
    }

    @Override
    public void addGame(Game game) {
        listOfGames.add(game);
    }

    @Override
    public List<Game> getGamesByYear(int yearMin, int yearMax) {
        List<Game> gamesByYear = new ArrayList<Game>();

        for (Game game : listOfGames) {

            if (game.getYear() >= yearMin && game.getYear() <= yearMax) {
                gamesByYear.add(game);
            }
        }
        return gamesByYear;

    }

    @Override
    public List<Game> getGamesByClau(String clau) {
        List<Game> gamesByClau = new ArrayList<Game>();
        clau = clau.toLowerCase();
        for (Game game : listOfGames) {
            if (game.getNom().toLowerCase().contains(clau)) {
                gamesByClau.add(game);
            } else {
                if (game.getEmpresa().toLowerCase().contains(clau)) {
                    gamesByClau.add(game);
                } else if (game.getPlataforma().toLowerCase().contains(clau)) {
                    gamesByClau.add(game);

                }
            }
        }
        return gamesByClau;
    }

    @Override
    public void updateGame(Game game) {
    for (int i = 0; i < listOfGames.size(); i++) {
        Game gameF = listOfGames.get(i);
        if (gameF != null && gameF.getId() != null
                && game.getId().equals(gameF.getId())) {
            listOfGames.set(i, game);
            return; 
        }
    }
}

    @Override
    public void deleteGame(String gameId) {
    Iterator<Game> iterator = listOfGames.iterator();
    while (iterator.hasNext()) {
        Game game = iterator.next();
        if (game != null && game.getId() != null && game.getId().equals(gameId)) {
            iterator.remove(); 
            return; 
        }
    }
}



}
