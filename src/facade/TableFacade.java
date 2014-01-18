package facade;

import entity.Table1;
import entity.Table2;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Stateless
public class TableFacade extends AbstractFacade<Table1>{
    @PersistenceContext(unitName = "OrdersPU")
    private EntityManager em;

    @EJB
    private Table2Facade table2Facade;

    public EntityManager getEntityManager() {
        return em;
    }

    public TableFacade() {
        super(Table1.class);
    }
    public Table1 findName(String name) {
        try{
            javax.persistence.criteria.CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
            javax.persistence.criteria.CriteriaQuery cq = criteriaBuilder.createQuery(Table1.class);
            Root<Table1> root = cq.from(Table1.class);
            Predicate user = criteriaBuilder.equal(root.get("name"), name);
            cq.select(root).where(user);
            return (Table1)getEntityManager().createQuery(cq).getSingleResult();
        }catch(NoResultException e) {
            Table2 table2 = new Table2(name);
            table2Facade.create(table2);
            return null;
        }
    }
}
