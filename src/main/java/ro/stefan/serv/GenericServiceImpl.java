package ro.stefan.serv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    protected GenericRepo<T, ID> genericRepo;

    public GenericServiceImpl(GenericRepo<T, ID> genericRepo) {
        this.genericRepo = genericRepo;
    }

    @Override
    public T findOne(Specification<T> spec) {
        return null;
    }

    @Override
    public List<T> findAll() {
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
    public <T> List<T> save(Iterable<T> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <T> T saveAndFlush(T entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<T> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public T getOne(ID id) {
        return null;
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <T> T save(T entity) {
        return null;
    }

    @Override
    public T findOne(ID id) {
        return null;
    }

    @Override
    public boolean exists(ID id) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(ID id) {

    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void delete(Iterable<? extends T> entities) {

    }

    @Override
    public void deleteAll() {

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
    public long count(Specification<T> spec) {
        return 0;
    }
}
