
package controladores;

import Sistema.Conectar;
import Sistema.Encriptacion;
import Sistema.Expediente;
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
@RequestMapping("buscarExpediente.htm")
public class BuscarExpedienteController {

    private JdbcTemplate jdbcTemplate;
    
    public BuscarExpedienteController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
 
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("buscarExpediente");
        mav.addObject("expedientes",new Expediente());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("expedientes") Expediente ex,
            BindingResult result,
            SessionStatus status
        )
    {
        
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("buscarExpediente");
            mav.addObject("expedientes",new Expediente());
            return mav;
        }else
        {
         
            ModelAndView mav = new ModelAndView();
            String sql = "SELECT ex.cod_expe, ex.cod_pac, per.nombre_p, per.apel_p,  ex.profesi_pac, ex.estad_civ, ex.nom_papa, ex.nom_mama, ex.pareja "
                    + "FROM expediente ex "
                    + "INNER JOIN paciente pa on pa.cod_pac = ex.cod_pac "
                    + "INNER JOIN persona per on per.dui = pa.dui "
                    + "WHERE ex.cod_expe ='" + ex.getCodExpe()+"'" ;
            List datos = this.jdbcTemplate.queryForList(sql);
            mav.addObject("datos",datos);
            mav.setViewName("buscarExpediente");
            return mav;
        
        
        }
        
    }
}
