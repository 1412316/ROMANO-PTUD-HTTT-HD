package demo.dao;

import demo.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UnitOfWork<T> implements IUnitOfWork<T> {
    private Session session;
    private IRepository<T> repository;

    public UnitOfWork(Session session) {
        this.session = session;
    }

    public IRepository<T> Repository() {
        if (repository == null) {
            repository = new Repository<T>(session);
        }
        return repository;
    }

    public void Save() {
        session.getTransaction().commit();
        session.close();
    }

    public void Begin() {
        session.getTransaction().begin();
    }

    public void Rollback() {
        session.getTransaction().rollback();
        session.close();
    }
}
