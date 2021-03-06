package controladores;


import Sistema.Conectar;
import Sistema.Doctor;
import Sistema.DoctorAddValidar;
import Sistema.Empleado;
import Sistema.Encriptacion;
import java.sql.ResultSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("addDoctor.htm")
public class AddDoctorController {
    
    private JdbcTemplate jdbcTemplate;
    DoctorAddValidar validar;
    public AddDoctorController() {
        this.validar = new DoctorAddValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addDoctor");
        mav.addObject("doctores",new Doctor());
        return mav;
    }
     
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("doctores") Doctor d, 
            BindingResult result,
            SessionStatus status
        )
    {
        validar.validate(d, result);
        //this.empleadoValidar.validate(u, result);
        //e.setPsw(Encriptacion.Encriptar(u.getPsw()));
        if(result.hasErrors())
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addDoctor");
            mav.addObject("doctores",new Doctor());
            return mav;
        }else
        {
            
            String empleado = obtenerEmpleado().getCod_Emp();
            this.jdbcTemplate.update(
            "insert into doctor (cod_esp, cod_emp, nom_esp) values (?,?,?)",
            d.getCod_Esp(), empleado, d.getNom_Esp());
            return new ModelAndView("redirect:/doctores.htm");
        
            }
        }
       
       public Empleado obtenerEmpleado(){
        final Empleado m=new Empleado();
        String sql = "SELECT * FROM empleado ORDER BY cod_emp DESC LIMIT 1";
        return (Empleado) this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            if(rs.next()){
                m.setCod_Emp(rs.getString("cod_emp"));
            }
            return m;
        }); 
        }
        
    }
    