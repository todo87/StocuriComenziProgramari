package ro.stefan.serv.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ro.stefan.model.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface GenericService<T extends BaseEntity, ID extends Serializable>{

    T findOne(ID id);
    T findOne(Specification<T> spec);
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    List<T> findAll(Sort sort);
    List<T> findAll(Iterable<ID> ids);
    List<T> findAll(Specification<T> spec);
    Page<T> findAll(Specification<T> spec, Pageable pageable);
    List<T> findAll(Specification<T> spec, Sort sort);

    T save(T entity);
    List<T> save(Iterable<T> entities);
    T saveAndFlush(T entity);
    void flush();

    void deleteAll();
    void delete(ID id);
    void delete(T entity);
    void delete(Iterable<T> entities);
    void deleteInBatch(Iterable<T> entities);
    void deleteAllInBatch();

    boolean exists(ID id);
    long count();

    long count(Specification<T> spec);

}
