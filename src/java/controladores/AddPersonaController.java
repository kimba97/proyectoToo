/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Sistema.Clinica;
import Sistema.Conectar;
import Sistema.Persona;
import Sistema.Usuario;
import java.sql.Date;
import java.sql.ResultSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kimba
 */
@Controller
@RequestMapping("addPersona.htm")
public class AddPersonaController {
    private JdbcTemplate jdbcTemplate;

    public AddPersonaController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addPersona");
        mav.addObject("personas",new Persona());
        return mav;
    }
     
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("personas") Persona u,
            BindingResult result,
            SessionStatus status
        )
    {
        
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addPersona");
            mav.addObject("personas",new Persona());
            return mav;
        }else
        {      
            this.jdbcTemplate.update(
            "insert into persona (dui, cod_clin, nombre_p, apel_p, sexo_p, fech_nac, munic_p, dep_p) values (?, ?, ?, ?, ?, ?, ?, ?)",
            u.getDui(), u.getClinica(), u.getNombre_P(), u.getApel_P(), u.getSexo_P(), Date.valueOf(u.getFecha_Nacim()), u.getMunic_P(), u.getDep_P());
            return new ModelAndView("redirect:/addPaciente.htm");
        
        }
        
        
    
        
    }
        public Clinica obtenerClinica(String codClinica){
        final Clinica m=new Clinica();
        String sql = "SELECT * FROM clinica WHERE cod_clin='" +codClinica+"'";
        return (Clinica) this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            if(rs.next()){
                m.setCod_Clin(rs.getString("cod_clin"));
                m.setNom_Clin(rs.getString("nom_clin"));
                m.setDep_Clin(rs.getString("dep_clin"));
                m.setMuni_Clin(rs.getString("muni_clin"));
            }
            return m;
        }); 
    }
}
