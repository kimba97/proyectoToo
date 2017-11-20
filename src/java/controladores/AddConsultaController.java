
package controladores;

import Sistema.Conectar;
import Sistema.Consulta;
import Sistema.ConsultaAddValidar;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("addConsulta.htm")
public class AddConsultaController {
    private JdbcTemplate jdbcTemplate;
    ConsultaAddValidar validar;

    public AddConsultaController() {
        this.validar = new ConsultaAddValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addConsulta");
        mav.addObject("consultas",new Consulta());
        return mav;
    }
    
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("consultas") Consulta u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
        )
    {
        validar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addConsulta");
            mav.addObject("consultas",new Consulta());
            return mav;
        }else
        {
           
            int cod_sin = Integer.valueOf((request.getParameter("id")));
            this.jdbcTemplate.update(
            "INSERT INTO consulta(cod_cons, cod_esp, cod_sin, sintom, trat_med, hora_cons, fecha_cons) VALUES (?, ?, ?, ?, ?, ?, ?)",
           u.getCod_Cons(), u.getDoctor_Cons(), cod_sin, u.getSintom(), u.getTrat_Med(), u.getHora_Cons(), Date.valueOf(u.getFecha_Cons()));
            return new ModelAndView("redirect:/signosVitales.htm");
        
        }
        
        
    
        
    }
    
    
}
