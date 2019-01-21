package x.gerry.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import x.gerry.model.Role;

import java.util.List;

public class RoleDao {
    private JdbcTemplate jdbcTemplate;

    public RoleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertRole(Role role) {
        String sql = "insert into role(Id,RoleName,Note)values(?,?,?)";
        return jdbcTemplate.update(sql, role.id, role.roleName, role.note);
    }

    public int deleteRole(Long id) {
        String sql = "delete from role where Id=?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateRole(Role role) {
        String sql = "update role set RoleName=?,Note=? where Id=?";
        return jdbcTemplate.update(sql, role.roleName, role.note, role.id);
    }

    public List<Role> findRole() {
        String sql = "SELECT Id,RoleName,Note FROM role";

        List<Role> result = jdbcTemplate.query(sql, (resultSet, i) -> {
            Role role = new Role();
            role.setId(resultSet.getLong("Id"));
            role.setRoleName(resultSet.getString("RoleName"));
            role.setNote(resultSet.getString("Note"));
            return role;
        });

        return result;
    }
}
