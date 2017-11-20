/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Sistema.Encriptacion;
import Sistema.Conectar;
import Sistema.Medicamentos;
import Sistema.Usuario;
import Sistema.UsuarioAddValidar;
import javax.servlet.http.HttpServletRequest;
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
public class AddMedicamentoController {
    //UsuarioAddValidar usuarioValidar;
    private JdbcTemplate jdbcTemplate;

    public AddMedicamentoController() {
        //this.usuarioValidar = new UsuarioAddValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addMedicamento");
        mav.addObject("medicamentos",new Medicamentos());
        return mav;
    }
     
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("medicamentos") Medicamentos m,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
        )
    {
        
        //this.usuarioValidar.validate(m, result);
        /*m.setPsw(Encriptacion.Encriptar(m.getCod_Med());*/
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addMedicamento");
            mav.addObject("medicamentos",new Medicamentos());
            return mav;
        }else
        {
            String cod_diag=request.getParameter("id");
            this.jdbcTemplate.update(
            "insert into medicamentos (cod_med, cod_diag, nom_med, cant_med, dosis_med) values (?,?,?,?,?)",
            m.getCod_Med(), cod_diag , m.getNom_Med(), m.getCant_Med(),m.getDosis_Med());
            return new ModelAndView("redirect:/medicamentos.htm");
        
        }
        
    }
    
}