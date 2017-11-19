package controladores;


import Sistema.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.servlet.http.HttpServletRequest;



public class UserController 
{
    private JdbcTemplate jdbcTemplate; 

    public UserController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("usuarios.htm")
    public ModelAndView usuarios()
    {
        ModelAndView mav = new ModelAndView();
        String sql = "select * from usuario";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("usuarios");
        return mav;
    }
    
    
}
