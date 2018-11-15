/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.dao;

import java.util.List;
import mx.enriquez.mysyfu.model.EstadoFinanciero;
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
public class EstadoFinancieroDAOImpl implements EstadoFinancieroDAO {

    private static final Logger logger = LoggerFactory.getLogger(EstadoFinancieroDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addEstadoFinanciero(EstadoFinanciero ef) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(ef);
    }

    @Override
    public void updateEstadoFinanciero(EstadoFinanciero ef) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(ef);
    }

    @Override
    public List<EstadoFinanciero> listEstadoFinancieros() {
        Session session = this.sessionFactory.getCurrentSession();
        List<EstadoFinanciero> estadosfList = session.createQuery("from Estado_financiero").list();
        for (EstadoFinanciero ef : estadosfList) {
            logger.info("EstadoFinanciero List::" + ef);
        }
        return estadosfList;
    }

    @Override
    public EstadoFinanciero getEstadoFinancieroById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        EstadoFinanciero ef = (EstadoFinanciero) session.load(EstadoFinanciero.class, new Integer(id));
        return ef;
    }

    @Override
    public void removeEstadoFinanciero(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        EstadoFinanciero ef = (EstadoFinanciero) session.load(EstadoFinanciero.class, new Integer(id));
        if (null != ef) {
            session.delete(ef);
        }
    }
}
