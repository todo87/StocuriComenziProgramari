package ro.stefan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.stefan.model.Role;

@Repository
public interface RoleRepo extends GenericRepo<Role,Long>{

    @Query("select r from Role r where r.role = :role")
    Role findByRole(@Param("role") String role);
}
