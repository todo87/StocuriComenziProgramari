//package ro.stefan.serv;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.io.Serializable;
//
//public class BaseService<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> {
//
//    @PersistenceContext
//    private static EntityManager em;
//
//    public BaseService(Class T ) {
//        super(T, em);
//    }
//}
