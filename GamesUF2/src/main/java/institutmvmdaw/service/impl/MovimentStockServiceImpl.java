/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institutmvmdaw.service.impl;

import institutmvmdaw.domain.Game;
import institutmvmdaw.repository.GamesRepository;
import institutmvmdaw.service.MovimentStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alumne_2n
 */
@Service
public class MovimentStockServiceImpl implements MovimentStockService {

    @Autowired
    private GamesRepository gamesRepository;

    @Override
    public void processMovimentStock(String gameId, long quantity, int signe) {
        Game gameById = gamesRepository.getGameById(gameId);
        long signedQuantity = quantity * signe;
        if ((gameById.getLimitDownload()+ signedQuantity) < 0) {
            throw new IllegalArgumentException("No hi ha prou unitats. La quantitat en estoc és: " + gameById.getLimitDownload());
        }
        gameById.setLimitDownload((int) (gameById.getLimitDownload() + signedQuantity));
    }
}
