/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Sistema.Conectar;
import Sistema.Encriptacion;
import Sistema.Empleado;
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
@RequestMapping("editUser.htm")
public class EditEmpleadoController {
    
    //EmpleadoAddValidar empleadosValidar;
    private JdbcTemplate jdbcTemplate;

    public EditEmpleadoController() 
    {
        //this.empleadosValidar = new EmpleadoAddValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
     @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        String cod_empleado=(request.getParameter("id"));
        Empleado datos=this.selectEmpleado(cod_empleado);
        mav.setViewName("editEmpleado");
        mav.addObject("empleados",new Empleado(cod_empleado, datos.getUsername(),datos.getPuest_Emp(),datos.getSalario()));
        return mav;
    }
    
   @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("empleados") Empleado e,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        
        //this.empleadosValidar.validate(u, result);
        //u.setPsw(Encriptacion.Encriptar(u.getPsw()));
        if(result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            String cod_empleado=(request.getParameter("id"));
            Empleado datos=this.selectEmpleado(cod_empleado);
            mav.setViewName("editEmpleado");
            mav.addObject("empleados",new Empleado(cod_empleado, datos.getUsername(), datos.getPuest_Emp(),datos.getSalario()));
            return mav;
        }else
        {
            String cod_empleado=(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "update empleado "
                + "set salario=?,"
                + "username=?,"
                + "puest_emp=? "
                + "where "
                + "cod_emp=? ",
                
         e.getSalario(),e.getUsername(),e.getPuest_Emp(),cod_empleado);
         return new ModelAndView("redirect:/empleados.htm");
        }
       
    }
    
    public Empleado selectEmpleado(String cod_empleado) 
    {
        final Empleado empleado = new Empleado();
        String quer = "SELECT E.cod_emp,E.username,E.puest_emp, E.salario,P.dui FROM empleado E JOIN persona P ON E.dui = P.dui WHERE cod_emp='" + cod_empleado+"'";
        return (Empleado) jdbcTemplate.query
        (
                quer, new ResultSetExtractor<Empleado>() 
            {
                public Empleado extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        empleado.setCod_Emp(rs.getString("cod_emp"));
                        empleado.setUsername(rs.getString("username"));
                        empleado.setDui(rs.getString("dui"));
                        empleado.setPuest_Emp(rs.getString("puest_Emp"));
                        empleado.setSalario(rs.getDouble("salario"));
                    }
                    return empleado;
                }


            }
        );
    }
   
}
