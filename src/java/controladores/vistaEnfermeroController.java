package controladores;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josej
 */
public class vistaEnfermeroController {
    @RequestMapping("vistaEnfermero.htm")
    public ModelAndView vistaEnfermero()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("vistaEnfermero");
        return mav;
    }
}
