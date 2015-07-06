package ro.stefan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.stefan.model.Users;

@Repository
public interface UsersRepo extends GenericRepo<Users,Long>{

    @Query("select u from Users u where u.username = :userName")
    Users findByUserName(@Param("userName") String userName);

}
