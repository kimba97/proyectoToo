package controladores;

import Sistema.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

public class ExpedienteController {
    
    private JdbcTemplate jdbcTemplate;

    public ExpedienteController() {
         Conectar con = new Conectar();
         this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("expedientes.htm")
    public ModelAndView usuarios()
    {               
        ModelAndView mav = new ModelAndView();
        String sql = "SELECT ex.cod_expe, ex.cod_pac, per.nombre_p, per.apel_p,  ex.profesi_pac, ex.estad_civ, ex.nom_papa, ex.nom_mama, ex.pareja " +
                        "FROM expediente ex " +
                        "INNER JOIN paciente pa on pa.cod_pac = ex.cod_pac " +
                        "INNER JOIN persona per on per.dui = pa.dui";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("expedientes");
        return mav;
    }
    
}
