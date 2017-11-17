
package controladores;

import Sistema.Encriptacion;
import Sistema.Conectar;
import Sistema.Usuario;
import Sistema.UsuarioAddValidar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("addUser.html")
public class AddUserController {
    
    UsuarioAddValidar usuarioValidar;
    private JdbcTemplate jdbcTemplate;

    public AddUserController() {
        this.usuarioValidar = new UsuarioAddValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addUser");
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
        
        this.usuarioValidar.validate(u, result);
        u.setPsw(Encriptacion.Encriptar(u.getPsw()));
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addUser");
            mav.addObject("usuarios",new Usuario());
            return mav;
        }else
        {
              
         ModelAndView mav = new ModelAndView();
        String sql = "select * from usuario";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("usuarios");
        return mav;
        
        }
        
    }
    
    
    
    
    
    
}
