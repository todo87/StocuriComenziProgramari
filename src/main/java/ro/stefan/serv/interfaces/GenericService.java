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

    public T findOne(ID id);
    public T findOne(Specification<T> spec);
    public List<T> findAll();
    public Page<T> findAll(Pageable pageable);
    public List<T> findAll(Sort sort);
    public List<T> findAll(Iterable<ID> ids);
    public List<T> findAll(Specification<T> spec);
    public Page<T> findAll(Specification<T> spec, Pageable pageable);
    public List<T> findAll(Specification<T> spec, Sort sort);

    public T save(T entity);
    public List<T> save(Iterable<T> entities);
    public T saveAndFlush(T entity);
    public void flush();

    public void deleteAll();
    public void delete(ID id);
    public void delete(T entity);
    public void delete(Iterable<T> entities);
    public void deleteInBatch(Iterable<T> entities);
    public void deleteAllInBatch();

    public boolean exists(ID id);
    public long count();

    public long count(Specification<T> spec);

}
