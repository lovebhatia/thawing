package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruncateDatabaseService {

    private EntityManager entityManager;

    @Autowired
    public TruncateDatabaseService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //@Transactional
    public void truncate(){
       // List<String> tableNames = new ArrayList();
       // Session session = entityManager.unwrap(Session.class);
        System.out.println("In Truncated method");
        //Map<String, ClassMetadata> hibernateMetadata = session.getSessionFactory().getMetamodel();

        /*for (ClassMetadata classMetadata : hibernateMetadata.values()) {
            AbstractEntityPersister aep = (AbstractEntityPersister) classMetadata;
            tableNames.add(aep.getTableName());
        }
*/
        //entityManager.flush();
        //entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();
        //tableNames.forEach(tableName -> entityManager.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate());
        //entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
    }

}