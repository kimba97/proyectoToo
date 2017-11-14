
package controladores;

import Sistema.Conectar;
import Sistema.Paciente;
import Sistema.PacienteAddValidar;
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
    PacienteAddValidar validar;
    private JdbcTemplate jdbcTemplate;
    
    public AddPacienteController() {
        this.validar = new PacienteAddValidar();
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
        
        validar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addPaciente");
            mav.addObject("pacientes",new Paciente());
            return mav;
        }else
        {
           
            String dui = obtenerDui().getDui();
            this.jdbcTemplate.update(
            "insert into paciente (cod_pac, dui) values (?, ?)",
           u.getCod_Pac(), dui);
            return new ModelAndView("redirect:/addExpediente.htm");
        
        }
        
        
    
        
    }
        
      public Persona obtenerDui(){
        final Persona m=new Persona();
        String sql = "SELECT * FROM persona ORDER BY dui DESC LIMIT 1";
        return (Persona) this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            if(rs.next()){
                m.setDui(rs.getString("dui"));
            }
            return m;
        }); 
    } 
}
