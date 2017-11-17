package controladores;

import Sistema.Conectar;
import Sistema.Persona;
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
@RequestMapping("editPacientes.htm")
public class EditPacienteController {

    private JdbcTemplate jdbcTemplate;

    public EditPacienteController() {

        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String dui = (request.getParameter("id"));
        Persona datos = this.selectPersona(dui);
        mav.setViewName("editPacientes");
        mav.addObject("pacientes", new Persona(dui, datos.getClinica(), datos.getNombre_P(), datos.getApel_P(), datos.getSexo_P(), datos.getFecha_Nacim(), datos.getMunic_P(), datos.getDep_P()));
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("pacientes") Persona u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {

        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            String dui = (request.getParameter("id"));
            Persona datos = this.selectPersona(dui);
            mav.setViewName("editPacientes");
            mav.addObject("usuarios", new Persona(dui, datos.getClinica(), datos.getNombre_P(), datos.getApel_P(), datos.getSexo_P(), datos.getFecha_Nacim(), datos.getMunic_P(), datos.getDep_P()));
            return mav;
        } else {
            String dui = (request.getParameter("id"));
            this.jdbcTemplate.update(
                    "UPDATE persona SET dui=?, cod_clin=?, nombre_p=?, apel_p=?, sexo_p=?, fech_nac=?, munic_p=?, dep_p=? WHERE dui=? ",
                    dui, u.getClinica(), u.getNombre_P(), u.getApel_P(), u.getSexo_P(), Date.valueOf(u.getFecha_Nacim()), u.getMunic_P(), u.getDep_P(), dui);
            return new ModelAndView("redirect:/pacientes.htm");
        }

    }

    public Persona selectPersona(String dui) {
        final Persona user = new Persona();
        String quer = "SELECT * FROM persona WHERE dui='" + dui + "'";
        return (Persona) jdbcTemplate.query(
                quer, new ResultSetExtractor<Persona>() {
            public Persona extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    user.setDui(rs.getString("dui"));
                    user.setClinica(rs.getString("cod_clin"));
                    user.setNombre_P(rs.getString("nombre_p"));
                    user.setApel_P(rs.getString("apel_p"));
                    user.setSexo_P(rs.getString("sexo_p"));
                    user.setFecha_Nacim(String.valueOf(rs.getDate("fech_nac")));
                    user.setMunic_P(rs.getString("munic_p"));
                    user.setDep_P(rs.getString("dep_p"));
                }
                return user;
            }

        }
        );
    }
}
