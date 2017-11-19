
package controladores;

import Sistema.Conectar;
import Sistema.Encriptacion;
import Sistema.Paciente;
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
@RequestMapping("buscarPaciente.htm")
public class BuscarPacienteController {

    private JdbcTemplate jdbcTemplate;
    
    public BuscarPacienteController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar()); 
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("buscarPaciente");
        mav.addObject("pacientes",new Paciente());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("pacientes") Paciente p,
            BindingResult result,
            SessionStatus status
        )
    {
        
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("buscarPaciente");
            mav.addObject("pacientes",new Paciente());
            return mav;
        }else
        {
         
            ModelAndView mav = new ModelAndView();
            String sql = "select pa.cod_pac, per.dui, per.nombre_p, per.apel_p,  per.sexo_p, per.fech_nac, per.munic_p, per.dep_p "
                    + "from paciente pa "
                    + "inner join persona per on per.dui = pa.dui "
                    + "WHERE pa.cod_pac='" + p.getCod_Pac()+"'" ;
            List datos = this.jdbcTemplate.queryForList(sql);
            mav.addObject("datos",datos);
            mav.setViewName("buscarPaciente");
            return mav;
        
        
        }
        
    }
    
}
