/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Sistema.Conectar;
import Sistema.Expediente;
import Sistema.ExpedienteAddValidar;
import Sistema.Paciente;
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
@RequestMapping("addExpediente.htm")
public class addExpedienteController {
    private JdbcTemplate jdbcTemplate;
    ExpedienteAddValidar validar;
    public addExpedienteController() {
        this.validar = new ExpedienteAddValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addExpediente");
        mav.addObject("expedientes",new Expediente());
        return mav;
    }
     
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("expedientes") Expediente u,
            BindingResult result,
            SessionStatus status
        )
    {
        
        validar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addExpediente");
            mav.addObject("expedientes",new Expediente());
            return mav;
        }else
        {
            
            this.jdbcTemplate.update(
            "insert into expediente (cod_expe, cod_pac, profesi_pac, estad_civ, nom_papa, nom_mama, pareja) values (?, ?, ?, ?, ?, ?, ?)",
           u.getCodExpe(), u.getPaci(), u.getProfesion(), u.getEstadoCivil(), u.getNomPadre(), u.getNomMadre(), u.getNomConyuge());
            return new ModelAndView("redirect:/Expedientes.htm");
        
        }
        
        
    
        
    }
        public Paciente obtenerPac(){
        final Paciente m=new Paciente();
        String sql = "SELECT * FROM paciente ORDER BY cod_pac DESC LIMIT 1";
        return (Paciente) this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            if(rs.next()){
                m.setCod_Pac(rs.getString("cod_pac"));
            }
            return m;
        }); 
    }
}
