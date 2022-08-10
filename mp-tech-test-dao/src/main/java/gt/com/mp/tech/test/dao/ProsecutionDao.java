package gt.com.mp.tech.test.dao;

import gt.com.mp.tech.test.model.db.Prosecution;
import gt.com.mp.tech.test.model.to.ProsecutionTo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author diego
 */
public interface ProsecutionDao {

    public EntityManager getEntityManager();

    public String testConnection();

    public List<ProsecutionTo> getProsecutionHeadquarterList();

    public int registerProsecutionHeadquarter(Prosecution headquarter);

    public boolean updateProsecutionHeadquarter(Prosecution headquarter);

    public Prosecution findProsecutionHeadquarterById(int codeProsecution);

    public Prosecution findProsecutionHeadquarterByLocation(String location);

}
