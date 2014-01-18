package facade;

import entity.Table2;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Table2Facade extends AbstractFacade<Table2>{
    @PersistenceContext(unitName = "OrdersPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }
    public Table2Facade() {
        super(Table2.class);
    }
}
