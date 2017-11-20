package controladores;

import Sistema.Conectar;
import Sistema.Expediente;
import Sistema.SignosVitales;
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
@RequestMapping("editSignosVitales.htm")
public class EditSignosVitales {

    private JdbcTemplate jdbcTemplate;

    public EditSignosVitales() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int cod_sin = Integer.valueOf((request.getParameter("id")));
        SignosVitales datos = this.selectSignos(cod_sin);
        mav.setViewName("editSignosVitales");
        mav.addObject("signos", new SignosVitales(datos.getCod_sig(), datos.getTemp(), datos.getAltura(), datos.getPres_Cardi(), datos.getPres_art(), datos.getPaciente()));
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("signos") SignosVitales u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {

        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            int cod_sin = Integer.valueOf((request.getParameter("id")));
            SignosVitales datos = this.selectSignos(cod_sin);
            mav.setViewName("editSignosVitales");
            mav.addObject("signos", new SignosVitales(datos.getCod_sig(), datos.getTemp(), datos.getAltura(), datos.getPres_Cardi(), datos.getPres_art(), datos.getPaciente()));
            return mav;
        } else {
            int cod_sin = Integer.valueOf((request.getParameter("id")));
            SignosVitales m = this.selectSignos(cod_sin);
            this.jdbcTemplate.update(
                    "UPDATE signos_vitales SET cod_sin=?, cod_pac=?, temp=?, altura=?, pres_cardi=?, pres_art=? WHERE cod_sin=?",
                    cod_sin, m.getPaciente(), u.getTemp(), u.getAltura(), u.getPres_Cardi(), u.getPres_art(), cod_sin);
            return new ModelAndView("redirect:/signosVitales.htm");
        }

    }

    public SignosVitales selectSignos(int cod_sin) {
        final SignosVitales user = new SignosVitales();
        String quer = "SELECT * FROM signos_vitales WHERE cod_sin=" + cod_sin + "";
        return (SignosVitales) jdbcTemplate.query(
                quer, new ResultSetExtractor<SignosVitales>() {
            public SignosVitales extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    user.setAltura(rs.getDouble("altura"));
                    user.setCod_sig(rs.getInt("cod_sin"));
                    user.setPaciente(rs.getString("cod_pac"));
                    user.setPres_Cardi(rs.getString("pres_cardi"));
                    user.setPres_art(rs.getString("pres_art"));
                    user.setTemp(rs.getString("temp"));
                }
                return user;
            }

        }
        );
    }

}
