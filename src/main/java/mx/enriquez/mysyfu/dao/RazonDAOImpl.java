/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.dao;

import java.util.List;
import mx.enriquez.mysyfu.model.Razon;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ISC. Cristian Enríquez
 */
@Repository
public class RazonDAOImpl implements RazonDAO {

    private static final Logger logger = LoggerFactory.getLogger(RazonDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addRazon(Razon r) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(r);
    }

    @Override
    public void updateRazon(Razon r) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(r);
    }

    @Override
    public List<Razon> listRazones() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Razon> razonList = session.createQuery("from Razon").list();
        for (Razon ef : razonList) {
            logger.info("Razon List::" + ef);
        }
        return razonList;
    }

    @Override
    public Razon getRazonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Razon r = (Razon) session.load(Razon.class, new Integer(id));
        return r;
    }

    @Override
    public void removeRazon(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Razon r = (Razon) session.load(Razon.class, new Integer(id));
        if (null != r) {
            session.delete(r);
        }
    }

    @Override
    public List<Razon> listRazonesById(int idf) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT * FROM razon WHERE _idestadof =" + idf);
        List<Razon> razonList = query.list();
        for (Razon ef : razonList) {
            logger.info("Razon List::" + ef);
        }
        return razonList;
    }
}
