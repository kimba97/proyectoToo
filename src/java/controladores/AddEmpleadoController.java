/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import Sistema.Conectar;
import Sistema.Encriptacion;
import Sistema.Empleado;
import Sistema.Persona;
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
 * @author josej
 */
@Controller
@RequestMapping("addEmpleado.htm")
public class AddEmpleadoController {
    //EmpleadoAddValidar empleadoValidar;
    private JdbcTemplate jdbcTemplate;

    public AddEmpleadoController() {
        //this.empleadoValidar = new EmpleadoAddValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addEmpleado");
        mav.addObject("empleados",new Empleado());
        return mav;
    }
     
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("empleados") Empleado e, 
            BindingResult result,
            SessionStatus status
        )
    {
        
        //this.empleadoValidar.validate(u, result);
        //e.setPsw(Encriptacion.Encriptar(u.getPsw()));
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addEmpleado");
            mav.addObject("empleados",new Empleado());
            return mav;
        }else
        {
            
            String dui = obtenerDui().getDui();
            this.jdbcTemplate.update(
            "insert into empleado (cod_emp,dui,username,salario, puest_emp) values (?,?,?,?,?)",
            e.getCod_Emp(),dui, e.getUsername(),e.getSalario(),e.getPuest_Emp());
            return new ModelAndView("redirect:/empleados.htm");
        
            }
        }
        
       public Persona obtenerDui(){
        final Persona m=new Persona();
        String sql = "SELECT * FROM persona ORDER BY dui DESC LIMIT 1";
        return (Persona) this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            if(rs.next()){
                m.setDui(rs.getString("dui"));
            }
            return m;
        }); 
        }
        
    }
    
    
    
    
    

