
package sessionbeans;

import entities.Projects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author John Mekubo
 */
@Stateless
public class ProjectsFacade extends AbstractFacade<Projects> {

    @PersistenceContext(unitName = "ProjectsEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProjectsFacade() {
        super(Projects.class);
    }
    
}
