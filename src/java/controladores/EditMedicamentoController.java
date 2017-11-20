/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Sistema.Conectar;
import Sistema.Encriptacion;
import Sistema.Medicamentos;
import Sistema.Usuario;
import Sistema.UsuarioAddValidar;
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
@RequestMapping("editMedicamento.htm")
public class EditMedicamentoController {
    UsuarioAddValidar usuariosValidar;
    private JdbcTemplate jdbcTemplate;

    public EditMedicamentoController() 
    {
        //this.usuariosValidar = new UsuarioAddValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
     @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        String cod_Med=(request.getParameter("id"));
        Medicamentos datos=this.selectMedicamento(cod_Med);
        mav.setViewName("editMedicamento");
        mav.addObject("medicamentos",new Medicamentos(cod_Med, datos.getCod_Diag(),datos.getNom_Med(),datos.getCant_Med(),datos.getDosis_Med()));
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
        
        //this.usuariosValidar.validate(u, result);
        //u.setPsw(Encriptacion.Encriptar(u.getPsw()));
        if(result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            String cod_med=(request.getParameter("id"));
            Medicamentos datos=this.selectMedicamento(cod_med);
            mav.setViewName("editMedicamento");
            mav.addObject("medicamentos",new Medicamentos(cod_med, datos.getCod_Diag(),datos.getNom_Med(),datos.getCant_Med(),datos.getDosis_Med()));
            return mav;
        }else
        {
            String cod_med=(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "update medicamentos "
                + "set nom_med=?,"
                + "set cod_diag=?,"
                + "cant_med=?,"
                + "dosis_med=?"
                + "where "
                + "cod_med=? ",
                
         m.getNom_Med(),m.getCod_Diag(),m.getCant_Med(),m.getDosis_Med(),cod_med);
         return new ModelAndView("redirect:/medicamentos.htm");
        }
       
    }
    
    public Medicamentos selectMedicamento(String cod_Med) 
    {
        final Medicamentos medica = new Medicamentos();
        String quer = "SELECT * FROM medicamentos WHERE cod_med='" + cod_Med+"'";
        return (Medicamentos) jdbcTemplate.query
        (
                quer, new ResultSetExtractor<Medicamentos>() 
            {
                public Medicamentos extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        
                        medica.setCod_Med(rs.getString("cod_med"));
                        medica.setNom_Med(rs.getString("nom_med"));
                        medica.setCant_Med(rs.getString("cant_med"));
                        medica.setDosis_Med(rs.getString("dosis_med"));
                        medica.setCod_Diag(rs.getString("cod_diag"));
                    }
                    return medica;
                }


            }
        );
    }
}