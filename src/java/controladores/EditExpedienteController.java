
package controladores;

import Sistema.Conectar;
import Sistema.Expediente;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@RequestMapping("editExpedientes.htm")
public class EditExpedienteController {
     private JdbcTemplate jdbcTemplate;
     
     public EditExpedienteController() {

        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
     
     @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String cod_expe = (request.getParameter("id"));
        Expediente datos = this.selectExpediente(cod_expe);
        mav.setViewName("editExpedientes");
        mav.addObject("expedientes", new Expediente(datos.getCodExpe(), datos.getPaci(), datos.getProfesion(), datos.getEstadoCivil(), datos.getNomMadre(), datos.getNomPadre(), datos.getNomConyuge()));
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("expedientes") Expediente u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {

        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            String cod_expe = (request.getParameter("id"));
            Expediente datos = this.selectExpediente(cod_expe);
            mav.setViewName("editExpediente");
            mav.addObject("expedientes", new Expediente(datos.getCodExpe(), datos.getPaci(), datos.getProfesion(), datos.getEstadoCivil(), datos.getNomMadre(), datos.getNomPadre(), datos.getNomConyuge()));
            return mav;
        } else {
            String cod_expe = (request.getParameter("id"));
            Expediente m = this.selectExpediente(cod_expe);
            this.jdbcTemplate.update(
                    "UPDATE expediente SET cod_expe=?, cod_pac=?, profesi_pac=?, estad_civ=?, nom_papa=?, nom_mama=?, pareja=? WHERE cod_expe=?",
                    cod_expe, m.getPaci(), u.getProfesion(), u.getEstadoCivil(), u.getNomPadre(), u.getNomMadre(), u.getNomConyuge(), cod_expe);
            return new ModelAndView("redirect:/expedientes.htm");
        }

    }
    
    
     public Expediente selectExpediente(String cod_expe) {
        final Expediente user = new Expediente();
        String quer = "SELECT * FROM expediente WHERE cod_expe='" + cod_expe + "'";
        return (Expediente) jdbcTemplate.query(
                quer, new ResultSetExtractor<Expediente>() {
            public Expediente extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    user.setCodExpe(rs.getString("cod_expe"));
                    user.setPaci(rs.getString("cod_pac"));
                    user.setProfesion(rs.getString("profesi_pac"));
                    user.setEstadoCivil(rs.getString("estad_civ"));
                    user.setNomPadre(rs.getString("nom_papa"));
                    user.setNomMadre(rs.getString("nom_mama"));
                    user.setNomConyuge(rs.getString("pareja"));
                }
                return user;
            }

        }
        );
    }
}
