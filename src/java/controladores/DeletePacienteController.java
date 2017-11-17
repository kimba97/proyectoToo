
package controladores;

import Sistema.Clinica;
import Sistema.Conectar;
import Sistema.Paciente;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class DeletePacienteController {
    
    private JdbcTemplate jdbcTemplate;
    
    public DeletePacienteController() 
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    @RequestMapping("deletePaciente.htm")
   public ModelAndView pacientes(HttpServletRequest request)
   {
       String cod_pac = (request.getParameter("id"));
       Paciente c = obtenerPaciente(cod_pac);
       this.jdbcTemplate.update(
       
               "delete from expediente "
            + "where "
            +  "cod_pac=? ",
       cod_pac);
       this.jdbcTemplate.update(
       
               "delete from paciente "
            + "where "
            +  "cod_pac=? ",
       cod_pac);
       this.jdbcTemplate.update(
       
               "delete from persona "
            + "where "
            +  "dui=? ",
       c.getDui());
       return new ModelAndView("redirect:/pacientes.htm");
   }
   
   public Paciente obtenerPaciente(String cod_pac){
       final Paciente m=new Paciente();
        String sql = "SELECT * FROM paciente WHERE cod_pac='" +cod_pac+"'";
        return (Paciente) this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            if(rs.next()){
                m.setCod_Pac(rs.getString("cod_pac"));
                m.setDui(rs.getString("dui"));
            }
            return m;
        });
   }
}
