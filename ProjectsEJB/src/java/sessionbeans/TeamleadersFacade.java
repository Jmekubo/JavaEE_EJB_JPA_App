
package sessionbeans;

import entities.Teamleaders;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author John Mekubo
 */
@Stateless
public class TeamleadersFacade extends AbstractFacade<Teamleaders> {

    @PersistenceContext(unitName = "ProjectsEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeamleadersFacade() {
        super(Teamleaders.class);
    }
    
}
