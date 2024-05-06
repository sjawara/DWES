/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institutmvmdaw.controller;

import institutmvmdaw.service.MovimentStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alumne_2n
 */
@Controller
public class MovimentStockController {

    @Autowired
    private MovimentStockService movimentStockService;

    @RequestMapping("/games/id1/2/-1")
    public String process() {
        movimentStockService.processMovimentStock("id1", 2, -1);
        return "redirect:/games";
    }
}
    