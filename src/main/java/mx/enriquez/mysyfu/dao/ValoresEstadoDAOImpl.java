/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.dao;

import java.util.List;
import mx.enriquez.mysyfu.model.Valores;
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
public class ValoresEstadoDAOImpl implements ValoresEstadoDAO {

    private static final Logger logger = LoggerFactory.getLogger(ValoresEstadoDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addValorEstado(Valores ve) {
        Session session = this.sessionFactory.getCurrentSession();
            session.save(ve);
    }

    @Override
    public void updateValorEstado(Valores ve) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(ve);
    }

    @Override
    public List<Valores> listValorEstados() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Valores");
        List<Valores> valorEstadoList = query.list();
        for (Valores ef : valorEstadoList) {
            logger.info("valorEstadoList List::" + ef);
        }
        return valorEstadoList;
    }

    @Override
    public Valores getValorEstadoById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Valores ve = (Valores) session.load(Valores.class, new Integer(id));
        return ve;
    }

    @Override
    public void removeValorEstado(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Valores ve = (Valores) session.load(Valores.class, new Integer(id));
        if (null != ve) {
            session.delete(ve);
        }
    }

    @Override
    public List<Valores> listValorEstadosByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
