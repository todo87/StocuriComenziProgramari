package ro.stefan.serv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import ro.stefan.model.BaseEntity;
import ro.stefan.repo.GenericRepo;
import ro.stefan.serv.interfaces.GenericService;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class GenericServiceImpl<T extends BaseEntity, ID extends Serializable> implements GenericService<T,ID> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected Class<T> clazz;

    @Autowired
    GenericRepo<T, ID> genericRepo;

    public GenericServiceImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T findOne(ID id) {
        return genericRepo.findOne(id);
    }

    @Override
    public T findOne(Specification<T> spec) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return genericRepo.findAll();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<T> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<T> findAll(Iterable<ID> ids) {
        return null;
    }

    @Override
    public List<T> findAll(Specification<T> spec) {
        return null;
    }

    @Override
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        return null;
    }

    @Override
    public List<T> findAll(Specification<T> spec, Sort sort) {
        return null;
    }

    @Override
    public T save(T entity) {
        return genericRepo.save(entity);
    }

    @Override
    public List<T> save(Iterable<T> entities) {
        return null;
    }

    @Override
    public T saveAndFlush(T entity) {
        return genericRepo.saveAndFlush(entity);
    }

    @Override
    public void flush() {
        genericRepo.flush();
    }

    @Override
    public void deleteAll() {
        genericRepo.deleteAll();
    }

    @Override
    public void delete(ID id) {
        genericRepo.delete(id);
    }

    @Override
    public void delete(T entity) {
        genericRepo.delete(entity);
    }

    @Override
    public void delete(Iterable<T> entities) {

    }

    @Override
    public void deleteInBatch(Iterable<T> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public boolean exists(ID id) {
        return genericRepo.exists(id);
    }

    @Override
    public long count() {
        return genericRepo.count();
    }

    @Override
    public long count(Specification<T> spec) {
        return 0;
    }
}
