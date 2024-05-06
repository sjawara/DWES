/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institutmvmdaw.controller;

import institutmvmdaw.domain.Game;
import institutmvmdaw.service.GameService;
//import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author alumne_2n
 */
@Controller
@RequestMapping("/games")
public class GameController {
    
    

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView allGames(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("games");
        modelview.getModelMap().addAttribute("games", gameService.getAllGames());
        return modelview;
    }

    @RequestMapping("/{category}")
    public ModelAndView getMedicamentsByCategory(@PathVariable("category") String medicamentCategory, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("games");
        modelview.getModelMap().addAttribute("games", gameService.getGamesByCategory(medicamentCategory));
        return modelview;
    }

    @RequestMapping("/filtYear")
    public ModelAndView getGamesByYear(@RequestParam("minYear") int minYear, @RequestParam("maxYear") int maxYear, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    ModelAndView modelview = new ModelAndView("games");
    modelview.getModelMap().addAttribute("games", gameService.getGamesByYear(minYear, maxYear));
    return modelview;
    }
    
    
    @RequestMapping("/clau")
    public ModelAndView getGamesByClau(@RequestParam("clau") String clau, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    ModelAndView modelview = new ModelAndView("games");
    modelview.getModelMap().addAttribute("games", gameService.getGamesByClau(clau));
    return modelview;
    }
    
    


    @RequestMapping("/game")
    public ModelAndView getGameById(@RequestParam("codi") String gameId, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("game");
        modelview.getModelMap().addAttribute("game", gameService.getGameById(gameId));
        return modelview;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getAddNewGameForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("addGame");
        Game newGame = new Game();
        modelview.getModelMap().addAttribute("newGame", newGame);
        return modelview;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateNewGameForm(@RequestParam("codi") String gameId, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("update");
        Game gameUpdate = gameService.getGameById(gameId);
        modelview.getModelMap().addAttribute("updateGame", gameUpdate);
        return modelview;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateNewGameFormPost(@ModelAttribute("updateGame") Game newGameToAdd) {
        gameService.updateGame(newGameToAdd);
        return "redirect:/games/all";
    }
    

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewMedicamentForm(@ModelAttribute("newGame") Game newGameToAdd) {
        gameService.addGame(newGameToAdd);
        return "redirect:/games/all";
    }
    
    @RequestMapping(value = "/fitYearForm", method = RequestMethod.GET)
    public ModelAndView processfiltYearForm( HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("formYear");
        modelview.getModelMap().addAttribute("newFilt", "");
        return modelview;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGame(@RequestParam("codi") String gameId) {
        gameService.deleteGame(gameId);
        return "redirect:/games/all";
    }
    
    
    @RequestMapping(value = "/filtYearForm", method = RequestMethod.POST)
    public ModelAndView processfiltYearForm(@RequestParam("minYear") int minYear, @RequestParam("maxYear") int maxYear) {
    ModelAndView modelview = new ModelAndView("games");
    modelview.getModelMap().addAttribute("games", gameService.getGamesByYear(minYear, maxYear));
    return modelview;
    }
    

}








/*
    @Controller
public class GameController {

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("games");
        Game  fortnite = new Game("id1","fortnite","epic games",0f,2018);
        modelview.getModelMap().addAttribute("game", fortnite);
        return modelview;
    }
}
*/
