//package ro.stefan.serv;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//
//import javax.persistence.EntityManager;
//import java.io.Serializable;
//
//public class BaseService<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> {
//
//    @Autowired
//    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;
//
////    @Autowired
////    ApplicationContext appContext;
////
////    EntityManager em = appContext.getBean();
//
//    private EntityManager entityManager = (EntityManager) localContainerEntityManagerFactoryBean.getObject();
//
//    public BaseService(Class t ) {
//        super(t, entityManager);
//    }
//}
