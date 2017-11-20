
package controladores;

import Sistema.Conectar;
import Sistema.Diagnostico;
import Sistema.DiagnosticoAddValidar;
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
@RequestMapping("addDiagnostico.htm")
public class AddDiagnosticoController {
    
    private JdbcTemplate jdbcTemplate;
   DiagnosticoAddValidar validar;
    
     public AddDiagnosticoController() {
        this.validar = new DiagnosticoAddValidar();
         Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
     
     @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addDiagnostico");
        mav.addObject("diagnosticos",new Diagnostico());
        return mav;
    }
    
     @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("diagnosticos") Diagnostico u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
        )
    {
        validar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addDiagnostico");
            mav.addObject("diagnosticos",new Diagnostico());
            return mav;
        }else
        {
           
            String cod_cons = request.getParameter("id");
            this.jdbcTemplate.update(
            "INSERT INTO diagnostico(cod_diag, cod_cons, cod_expe, descrp) VALUES (?, ?, ?, ?);",
             u.getCod_Diag(),cod_cons,u.getEx(),u.getDescrip());
            return new ModelAndView("redirect:/diagnosticos.htm");
        
        }
        
        
    
        
    }
    
}
