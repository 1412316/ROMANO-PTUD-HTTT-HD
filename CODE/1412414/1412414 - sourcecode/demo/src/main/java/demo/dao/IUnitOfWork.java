package demo.dao;

public interface IUnitOfWork<T> {
    IRepository<T> Repository();
    void Save();
    void Begin();
    void Rollback();
}
