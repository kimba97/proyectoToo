
package controladores;

import Sistema.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

public class PacienteController {
    
    
    private JdbcTemplate jdbcTemplate; 

    public PacienteController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("pacientes.htm")
    public ModelAndView usuarios()
    {
        ModelAndView mav = new ModelAndView();
        String sql = "select pa.cod_pac, per.dui, per.nombre_p, per.apel_p,  per.sexo_p, per.fech_nac, per.munic_p, per.dep_p from paciente pa inner join persona per on per.dui = pa.dui";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("pacientes");
        return mav;
    }
    
    
    
}
