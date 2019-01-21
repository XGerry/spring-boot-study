package x.gerry;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import x.gerry.dao.RoleDao;
import x.gerry.model.Role;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //  SpringApplication.run(App.class, args);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        RoleDao roleDao = new RoleDao(jdbcTemplate);
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("admin");
        role.setNote("管理员");
       // roleDao.insertRole(role);
        roleDao.findRole();
        roleDao.deleteRole(role.id);

    }
}
