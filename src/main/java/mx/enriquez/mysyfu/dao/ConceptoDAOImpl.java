/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.dao;

import java.util.List;
import mx.enriquez.mysyfu.model.Concepto;
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
public class ConceptoDAOImpl implements ConceptoDAO {

    private static final Logger logger = LoggerFactory.getLogger(ConceptoDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addConcepto(Concepto c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
    }

    @Override
    public void updateConcepto(Concepto c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
    }

    @Override
    public List<Concepto> listConceptos() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Concepto> conceptoList = session.createQuery("from Concepto").list();
        for (Concepto p : conceptoList) {
            logger.info("Concepto List::" + p);
        }
        return conceptoList;
    }

    @Override
    public Concepto getConceptoById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Concepto c = (Concepto) session.load(Concepto.class, new Integer(id));
        return c;
    }

    @Override
    public void removeConcepto(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Concepto c = (Concepto) session.load(Concepto.class, new Integer(id));
        if (null != c) {
            session.delete(c);
        }
    }

}
