
package controladores;

import Sistema.Encriptacion;
import Sistema.Conectar;
import Sistema.Usuario;
import Sistema.UsuarioAddValidar;
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
        u.setPsw(Encriptacion.Encriptar(u.getPsw()));
        this.usuarioValidar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addUser");
            mav.addObject("usuarios",new Usuario());
            return mav;
        }else
        {
              
            this.jdbcTemplate.update(
            "insert into usuario (username,contrasenia) values (?,?)",
            u.getUsuario(), u.getPsw());
            return new ModelAndView("redirect:/usuarios.htm");
        
        }
        
    }
    
    
    
    
    
    
}
