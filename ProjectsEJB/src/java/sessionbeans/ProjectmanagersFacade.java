
package sessionbeans;

import entities.Projectmanagers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author John Mekubo
 */
@Stateless
public class ProjectmanagersFacade extends AbstractFacade<Projectmanagers> {

    @PersistenceContext(unitName = "ProjectsEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProjectmanagersFacade() {
        super(Projectmanagers.class);
    }
    
}
