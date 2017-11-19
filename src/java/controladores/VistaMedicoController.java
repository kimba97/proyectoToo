
package controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class VistaMedicoController {
    
    @RequestMapping("vistaMedico.htm")
    public ModelAndView vistaMedico()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("vistaMedico");
        return mav;
    }
    
}
