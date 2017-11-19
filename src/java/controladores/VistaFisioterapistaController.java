
package controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class VistaFisioterapistaController {
    
     @RequestMapping("vistaFisioterapista.htm")
    public ModelAndView vistaFisioterapista()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("vistaFisioterapista");
        return mav;
    }
}
