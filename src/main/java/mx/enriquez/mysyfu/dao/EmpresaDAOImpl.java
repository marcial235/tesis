/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.dao;

import java.util.List;
import mx.enriquez.mysyfu.model.Empresa;
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
public class EmpresaDAOImpl implements EmpresaDAO {

    private static final Logger logger = LoggerFactory.getLogger(EmpresaDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addEmpresa(Empresa e) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(e);
    }

    @Override
    public void updateEmpresa(Empresa e) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(e);
    }

    @Override
    public List<Empresa> listEmpresas() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Empresa> empresaList = session.createQuery("from Empresa").list();
        for (Empresa p : empresaList) {
            logger.info("Empresa List::" + p);
        }
        return empresaList;
    }

    @Override
    public Empresa getEmpresaById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Empresa e = (Empresa) session.load(Empresa.class, new Integer(id));
        return e;
    }

    @Override
    public void removeEmpresa(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Empresa e = (Empresa) session.load(Empresa.class, new Integer(id));
        if (null != e) {
            session.delete(e);
        }
    }
}
