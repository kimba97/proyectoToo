
package controladores;

import Sistema.Conectar;
import Sistema.SignosVitales;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("buscarSignosVitales.htm")
public class BuscarSignosVitalesController {

     private JdbcTemplate jdbcTemplate;
    
    public BuscarSignosVitalesController() {
        
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("buscarSignosVitales");
        mav.addObject("signos",new SignosVitales());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("signos") SignosVitales s,
            BindingResult result,
            SessionStatus status
        )
    {
        
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("buscarSignosVitales");
            mav.addObject("signos",new SignosVitales());
            return mav;
        }else
        {
         
            ModelAndView mav = new ModelAndView();
            String sql = "select * " +
                    "from signos_vitales where cod_pac ='" + s.getPaciente()+"'";
             List datos = this.jdbcTemplate.queryForList(sql);
            mav.addObject("datos",datos);
            mav.setViewName("buscarSignosVitales");
            return mav;
        
        
        }
        
    }
    
}
