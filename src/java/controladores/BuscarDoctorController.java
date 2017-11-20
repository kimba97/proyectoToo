package controladores;

import Sistema.Conectar;
import Sistema.Doctor;
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
@RequestMapping("buscarDoctor.htm")
public class BuscarDoctorController {

    private JdbcTemplate jdbcTemplate;
    
    public BuscarDoctorController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
 
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("buscarDoctor");
        mav.addObject("doctores",new Doctor());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("doctores") Doctor doc,
            BindingResult result,
            SessionStatus status
        )
    {
        
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("buscarDoctor");
            mav.addObject("doctores",new Doctor());
            return mav;
        }else
        {
         
            ModelAndView mav = new ModelAndView();
            String sql = "select  d.cod_esp, d.nom_esp, e.cod_emp, p.nombre_p, p.apel_p from doctor d inner join empleado e on d.cod_emp= e.cod_emp inner join persona p on e.dui=p.dui where d.cod_esp='" + doc.getCod_Esp()+"'" ;
            List datos = this.jdbcTemplate.queryForList(sql);
            mav.addObject("datos",datos);
            mav.setViewName("buscarDoctor");
            return mav;
        
        
        }
        
    }
}