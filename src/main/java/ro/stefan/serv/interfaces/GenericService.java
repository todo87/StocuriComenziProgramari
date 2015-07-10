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
    
    public T findOne(Specification<T> spec);
    public List<T> findAll();
    public List<T> findAll(Sort sort);
    public List<T> findAll(Iterable<ID> ids);
    public <T> List<T> save(Iterable<T> entities);
    public void flush();
    public <T> T saveAndFlush(T entity);
    public void deleteInBatch(Iterable<T> entities);
    public void deleteAllInBatch();
    public T getOne(ID id);
    public Page<T> findAll(Pageable pageable);
    public <T> T save(T entity);
    public T findOne(ID id);
    public boolean exists(ID id);
    public long count();
    public void delete(ID id);
    public void delete(T entity);
    public void delete(Iterable<? extends T> entities);
    public void deleteAll();
    public List<T> findAll(Specification<T> spec);
    public Page<T> findAll(Specification<T> spec, Pageable pageable);
    public List<T> findAll(Specification<T> spec, Sort sort);
    public long count(Specification<T> spec);

}
