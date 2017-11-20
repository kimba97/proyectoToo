
package controladores;

import Sistema.Conectar;
import Sistema.Consulta;

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
@RequestMapping("buscarConsulta.htm")
public class BuscarConsultasController {
    
    private JdbcTemplate jdbcTemplate;

    public BuscarConsultasController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("buscarConsulta");
        mav.addObject("consultas",new Consulta());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("consultas") Consulta co,
            BindingResult result,
            SessionStatus status
        )
    {
        
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("buscarConsulta");
            mav.addObject("consultas",new Consulta());
            return mav;
        }else
        {
         
            ModelAndView mav = new ModelAndView();
            String sql = "select co.cod_cons,ex.cod_expe,sig.cod_sin,pa.cod_pac,per.nombre_p,per.apel_p,pir.nombre_p,pir.apel_p,co.fecha_cons, co.hora_cons "
                     +"from consulta co "
                     +"inner join signos_vitales sig on sig.cod_sin = co.cod_sin "
                     +"inner join paciente  pa on  pa.cod_pac = sig.cod_pac "
                     +"inner join persona per on per.dui = pa.dui "
                     +"inner join doctor doc on doc.cod_esp = co.cod_esp "
                     +"inner join empleado em on em.cod_emp = doc.cod_emp "
                     +"inner join persona pir on pir.dui = em.dui "
                     +"inner join expediente ex on ex.cod_pac = pa.cod_pac "
                    +" where co.cod_cons='" + co.getCod_Cons()+"'";
            
            List datos = this.jdbcTemplate.queryForList(sql);
            mav.addObject("datos",datos);
            mav.setViewName("buscarConsulta");
            return mav;
        
        
        }
        
    }
    
}
