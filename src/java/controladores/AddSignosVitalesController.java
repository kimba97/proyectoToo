
package controladores;

import Sistema.Clinica;
import Sistema.SignosVitales;
import Sistema.Conectar;
import Sistema.SignosVitalesAddValidar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
@RequestMapping("addSignosVitales.htm")

public class AddSignosVitalesController {
  
    private JdbcTemplate jdbcTemplate;
    SignosVitalesAddValidar validar;
    
    public AddSignosVitalesController() {
        this.validar = new SignosVitalesAddValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addSignosVitales");
        mav.addObject("signos",new SignosVitales());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    @SuppressWarnings("empty-statement")
    public ModelAndView form
        (
            @ModelAttribute("signos") SignosVitales s,
            BindingResult result,
            SessionStatus status
        )
    {
       validar.validate(s, result);
       if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addSignosVitales");
            mav.addObject("signos",new SignosVitales());
            return mav;
        }else
        {
            if(ObtenerSignos().isEmpty() == true){
                s.setCod_sig(1);
            }else{
                SignosVitales si = selectSignos(ObtenerSignos().size()+1);
                if(si == null){
                    s.setCod_sig(ObtenerSignos().size()+1);
                }else{
                    s.setCod_sig(si.getCod_sig()+1);
                }
            }
            
            this.jdbcTemplate.update(
            "insert into signos_vitales(cod_sin, cod_pac, temp, altura, pres_cardi, pres_art) values (?,?, ?, ?, ?, ?)",
            s.getCod_sig(),s.getPaciente(),s.getTemp(),s.getAltura(),s.getPres_art(),s.getPres_Cardi());
            return new ModelAndView("redirect:/signosVitales.htm");
        
        }
        
    }
    
        public SignosVitales selectSignos(int cod_sin) 
    {
        final SignosVitales clini = new SignosVitales();
        String quer = "SELECT * FROM signos_vitales WHERE cod_sin="+cod_sin+"";
        return (SignosVitales) jdbcTemplate.query
        (
                quer, new ResultSetExtractor<SignosVitales>() 
            {
                public SignosVitales extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        
                        clini.setCod_sig(rs.getInt("cod_sin"));
                    }
                    return clini;
                }


            }
        );
    }
      
        public List ObtenerSignos()
        {
             String sql = "select * from signos_vitales";
             List datos = this.jdbcTemplate.queryForList(sql);
             return datos;
        }
        
        
}
