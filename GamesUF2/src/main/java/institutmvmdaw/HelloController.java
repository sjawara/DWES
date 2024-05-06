/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institutmvmdaw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author alumne_2n
 */

@Controller
public class HelloController {

    @RequestMapping(value = "")
    public ModelAndView saluda() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("titulo", "Hola a tothom");
        mv.addObject("mensaje", "");
        mv.setViewName("hello");
        return mv;
    }
    
    @RequestMapping(value = "/bondia")
    public ModelAndView bondia() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("titulo", "Bon dia a tothom");
        mv.addObject("mensaje", "");
        mv.setViewName("hello");
        return mv;
    }
    
    @RequestMapping(value = "/bonanit")
    public ModelAndView bonanit() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("titulo", "Bona nit a tothom");
        mv.addObject("mensaje", "");
        mv.setViewName("hello");
        return mv;
    }

    
}
