package controladores;

import Sistema.Conectar;
import Sistema.Doctor;
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
@RequestMapping("editDoctor.htm")
public class EditDoctorController {
     private JdbcTemplate jdbcTemplate;
     
     public EditDoctorController() {

        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
     
     @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String cod_esp = (request.getParameter("id"));
        Doctor datos = this.selectDoctor(cod_esp);
        mav.setViewName("editDoctor");
        mav.addObject("doctores", new Doctor(datos.getCod_Esp(), datos.getNom_Esp()));
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("doctores") Doctor u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {

        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            String cod_esp = (request.getParameter("id"));
            Doctor datos = this.selectDoctor(cod_esp);
            mav.setViewName("editDoctor");
            mav.addObject("doctores", new Doctor(datos.getCod_Esp(), datos.getNom_Esp()));
            return mav;
        } else {
            String cod_esp = (request.getParameter("id"));
            Doctor m = this.selectDoctor(cod_esp);
            this.jdbcTemplate.update(
                    "UPDATE doctor SET cod_esp=?, nom_esp=? WHERE cod_esp=?",
                    cod_esp, u.getNom_Esp(), cod_esp);
            return new ModelAndView("redirect:/doctores.htm");
        }

    }
    
    
     public Doctor selectDoctor(String cod_esp) {
        final Doctor user = new Doctor();
        String quer = "SELECT * FROM doctor WHERE cod_esp='" + cod_esp + "'";
        return (Doctor) jdbcTemplate.query(
                quer, new ResultSetExtractor<Doctor>() {
            public Doctor extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    user.setCod_Esp(rs.getString("cod_esp"));
                    user.setNom_Esp(rs.getString("nom_esp"));
                    
                    
                }
                return user;
            }

        }
        );
    }
}