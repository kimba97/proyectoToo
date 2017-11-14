
package controladores;

import Sistema.Conectar;
import Sistema.Expediente;
import Sistema.Paciente;
import Sistema.Persona;
import java.sql.ResultSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("addPaciente.htm")
public class AddPacienteController {
    private JdbcTemplate jdbcTemplate;
    
    public AddPacienteController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addPaciente");
        mav.addObject("pacientes",new Paciente());
        return mav;
    }
     
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("pacientes") Paciente u,
            BindingResult result,
            SessionStatus status
        )
    {
        
        
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addPaciente");
            mav.addObject("pacientes",new Paciente());
            return mav;
        }else
        {
            
            this.jdbcTemplate.update(
            "insert into paciente (cod_pac, dui) values (?, ?)",
           u.getCod_Pac(), u.getDui());
            return new ModelAndView("redirect:/addPaciente.htm");
        
        }
        
        
    
        
    }
        
}
