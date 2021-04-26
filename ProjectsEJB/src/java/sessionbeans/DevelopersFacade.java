
package sessionbeans;

import entities.Developers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author John Mekubo
 */
@Stateless
public class DevelopersFacade extends AbstractFacade<Developers> {

    @PersistenceContext(unitName = "ProjectsEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DevelopersFacade() {
        super(Developers.class);
    }
    
}
