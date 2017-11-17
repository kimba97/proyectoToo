
package controladores;

import Sistema.Conectar;
import Sistema.Encriptacion;
import Sistema.Usuario;
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
@RequestMapping("buscarUsuario.html")
public class BuscarUsuarioController 
{
    private JdbcTemplate jdbcTemplate;
    
    public BuscarUsuarioController() {
        
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("buscarUsuario");
        mav.addObject("usuarios",new Usuario());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("usuarios") Usuario u,
            BindingResult result,
            SessionStatus status
        )
    {
        
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("buscarUsuario");
            mav.addObject("usuarios",new Usuario());
            return mav;
        }else
        {
         
            ModelAndView mav = new ModelAndView();
            String sql = "SELECT * FROM usuario WHERE username='" +u.getUsuario()+"'";
            List datos = this.jdbcTemplate.queryForList(sql);
            mav.addObject("datos",datos);
            mav.setViewName("buscarUsuario");
            return mav;
        
        
        }
        
    }
    
    
    
    
}
