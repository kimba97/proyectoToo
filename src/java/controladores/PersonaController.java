
package controladores;

import Sistema.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author josej
 */
public class PersonaController {
    private JdbcTemplate jdbcTemplate; 

    public PersonaController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("personas.htm")
    public ModelAndView personas()
    {
        ModelAndView mav = new ModelAndView();
        String sql = "select c.nom_clin, p.dui, p.nombre_p, p.apel_p, p.sexo_p, p.fech_nac, p.munic_p, p.dep_p from persona p inner join clinica c on p.cod_clin= c.cod_clin";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("personas");
        return mav;
    }
    
}
