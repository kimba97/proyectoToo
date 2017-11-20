
package controladores;

import Sistema.Conectar;
import Sistema.Consulta;
import Sistema.Diagnostico;
import java.sql.Date;
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
@RequestMapping("editarDiagnostico.htm")
public class EditDiagnosticoController {
    private JdbcTemplate jdbcTemplate;
    public EditDiagnosticoController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String cod_diag = (request.getParameter("id"));
        Diagnostico datos = this.selectDiag(cod_diag);
        mav.setViewName("editarDiagnostico");
        mav.addObject("diagnosticos", new Diagnostico(cod_diag, datos.getDescrip(), datos.getEx(), datos.getCons()));
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("diagnosticos") Diagnostico u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {

        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            String cod_diag = (request.getParameter("id"));
            Diagnostico datos = this.selectDiag(cod_diag);
            mav.setViewName("editarDiagnostico");
            mav.addObject("diagnosticos", new Diagnostico(cod_diag, datos.getDescrip(), datos.getEx(), datos.getCons()));
        return mav;
        } else {
            String cod_diag = (request.getParameter("id"));
            Diagnostico m = this.selectDiag(cod_diag);
            this.jdbcTemplate.update(
                    "UPDATE diagnostico SET cod_diag=?, cod_cons=?, cod_expe=?, descrp=? WHERE cod_diag=?",
                    cod_diag, m.getCons(), m.getEx(), u.getDescrip(), cod_diag);
            return new ModelAndView("redirect:/diagnosticos.htm");
        }

    }
    
    
    
    public Diagnostico selectDiag(String cod_diag) {
        final Diagnostico user = new Diagnostico();
        String quer = "SELECT * FROM diagnostico WHERE cod_diag='" + cod_diag + "'";
        return (Diagnostico) jdbcTemplate.query(
                quer, new ResultSetExtractor<Diagnostico>() {
            public Diagnostico extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                   user.setCod_Diag(cod_diag);
                   user.setCons(rs.getString("cod_cons"));
                   user.setDescrip(rs.getString("descrp"));
                   user.setEx(rs.getString("cod_expe"));
                }
                return user;
            }

        }
        );
    }
    
}
