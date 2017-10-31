/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Sistema.Clinica;
import Sistema.Conectar;
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
 * @author josej
 */
@Controller
@RequestMapping("addUser.html")
public class AddClinicaController {
    //ClinicaAddValidar usuarioValidar;
    private JdbcTemplate jdbcTemplate;

    public AddClinicaController() {
        //this.usuarioValidar = new ClinicaAddValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addClinica");
        mav.addObject("clinicas",new Clinica());
        return mav;
    }
     
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("clinicas") Clinica c,
            BindingResult result,
            SessionStatus status
        )
    {
        
        //this.usuarioValidar.validate(u, result);
        //u.setPsw(Encriptacion.Encriptar(u.getPsw()));
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addClinica");
            mav.addObject("clinicas",new Clinica());
            return mav;
        }else
        {
              
            this.jdbcTemplate.update(
            "insert into clinica (cod_clin,nom_clin,dep_clin,muni_clin) values (?,?,?,?)",c.getCod_Clin(),
            c.getNom_Clin(),c.getDep_Clin(),c.getMuni_Clin());
            return new ModelAndView("redirect:/clinicas.htm");
        
        }
        
    }
    
    
    
    
    
}
