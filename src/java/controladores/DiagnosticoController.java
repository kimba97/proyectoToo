package controladores;

import Sistema.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class DiagnosticoController {
    
    private JdbcTemplate jdbcTemplate; 

    public DiagnosticoController() {
        
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("diagnosticos.htm")
    public ModelAndView diagnostico()
    {
        ModelAndView mav = new ModelAndView();
        String sql = "select di.cod_diag, ex.cod_expe,per.nombre_p,per.apel_p,di.descrp "
                     +"from diagnostico di "
                     +"inner join expediente ex on ex.cod_expe = di.cod_expe "
                     +"inner join paciente pa on pa.cod_pac = ex.cod_pac "
                     +"inner join persona per on per.dui = pa.dui";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("diagnosticos");
        return mav;
    
    }
    
    
}
