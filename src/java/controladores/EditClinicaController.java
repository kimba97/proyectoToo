/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Sistema.Conectar;
import Sistema.Encriptacion;
import Sistema.Clinica;
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

/**
 *
 * @author josej
 */
@Controller
@RequestMapping("editClinica.htm")
public class EditClinicaController {
    private JdbcTemplate jdbcTemplate;

    public EditClinicaController() 
    {
        //this.clinicasValidar = new ClinicaAddValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
     @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        String cod_clinica=(request.getParameter("id"));
        Clinica datos=this.selectClinica(cod_clinica);
        mav.setViewName("editClinica");
        mav.addObject("clinicas",new Clinica(cod_clinica, datos.getNom_Clin(),datos.getDep_Clin(),datos.getMuni_Clin()));
        return mav;
    }
    
   @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("clinicas") Clinica c,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        
        //this.clinicasValidar.validate(u, result);
        //c.setPsw(Encriptacion.Encriptar(u.getPsw()));
        if(result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            String cod_clinica=(request.getParameter("id"));
            Clinica datos=this.selectClinica(cod_clinica);
            mav.setViewName("editClinica");
            mav.addObject("clinicas",new Clinica(cod_clinica, datos.getNom_Clin(),datos.getDep_Clin(),datos.getMuni_Clin()));
            return mav;
        }else
        {
            String cod_clinica=(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "update clinica "
                + "set nom_clin=?,"
                + "dep_clin=?,"
                + "muni_clin=? "
                + "where "
                + "cod_clin=? ",
                
            c.getNom_Clin(),c.getDep_Clin(),c.getMuni_Clin(),cod_clinica);
         return new ModelAndView("redirect:/clinicas.htm");
        }
       
    }
    
    public Clinica selectClinica(String cod_clinica) 
    {
        final Clinica clini = new Clinica();
        String quer = "SELECT * FROM clinica WHERE cod_clin='"+cod_clinica+"'";
        return (Clinica) jdbcTemplate.query
        (
                quer, new ResultSetExtractor<Clinica>() 
            {
                public Clinica extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        
                        clini.setNom_Clin(rs.getString("nom_Clin"));
                        clini.setDep_Clin(rs.getString("Dep_Clin"));
                        clini.setMuni_Clin(rs.getString("Muni_Clin"));
                    }
                    return clini;
                }


            }
        );
    }
   
    
}
