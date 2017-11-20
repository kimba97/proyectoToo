
package controladores;

import Sistema.Conectar;
import Sistema.Consulta;
import Sistema.SignosVitales;
import Sistema.Usuario;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javafx.scene.input.KeyCode.T;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("editConsultas.htm")
public class EditConsultasController {
    private JdbcTemplate jdbcTemplate;

    public EditConsultasController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String cod_cons = (request.getParameter("id"));
        Consulta datos = this.selectConsulta(cod_cons);
        mav.setViewName("editConsultas");
        mav.addObject("consultas", new Consulta(cod_cons, datos.getSintom(), datos.getTrat_Med(), datos.getFecha_Cons(), datos.getHora_Cons(), datos.getDoctor_Cons(), datos.getCodSign()));
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("consultas") Consulta u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {

        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            String cod_cons = (request.getParameter("id"));
            Consulta datos = this.selectConsulta(cod_cons);
            mav.setViewName("editConsultas");
            mav.addObject("consultas", new Consulta(cod_cons, datos.getSintom(), datos.getTrat_Med(), datos.getFecha_Cons(), datos.getHora_Cons(), datos.getDoctor_Cons(), datos.getCodSign()));
        return mav;
        } else {
            String cod_cons = (request.getParameter("id"));
            Consulta m = this.selectConsulta(cod_cons);
            this.jdbcTemplate.update(
                    "UPDATE consulta SET cod_cons=?, cod_esp=?, cod_sin=?, sintom=?, trat_med=?, hora_cons=?, fecha_cons=? WHERE cod_cons=?",
                    cod_cons, m.getDoctor_Cons(), Integer.valueOf(m.getCodSign()), u.getSintom(), u.getTrat_Med(), u.getHora_Cons(), Date.valueOf(u.getFecha_Cons()), cod_cons);
            return new ModelAndView("redirect:/consultas.htm");
        }

    }
    
    
    
    
    
    public Consulta selectConsulta(String cod_cons) {
        final Consulta user = new Consulta();
        String quer = "SELECT * FROM consulta WHERE cod_cons='" + cod_cons + "'";
        return (Consulta) jdbcTemplate.query(
                quer, new ResultSetExtractor<Consulta>() {
            public Consulta extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    user.setCod_Cons(rs.getString("cod_cons"));
                    user.setDoctor_Cons(rs.getString("cod_esp"));
                    user.setCodSign(rs.getString("cod_sin"));
                    user.setSintom(rs.getString("sintom"));
                    user.setTrat_Med(rs.getString("trat_med"));
                    user.setHora_Cons(rs.getString("hora_cons"));
                    user.setFecha_Cons(String.valueOf(rs.getDate("fecha_cons")));
                }
                return user;
            }

        }
        );
    }
    
}
