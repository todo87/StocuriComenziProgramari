package ro.stefan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.stefan.model.Unit;

@Repository
public interface UnitRepo extends GenericRepo<Unit,Long> {

    @Query("select u from Unit u where u.unit = :unit")
    Unit findByName(@Param("unit") String unit);
}
