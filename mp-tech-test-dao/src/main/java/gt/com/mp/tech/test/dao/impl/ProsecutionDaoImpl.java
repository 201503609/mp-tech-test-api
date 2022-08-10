package gt.com.mp.tech.test.dao.impl;

import gt.com.mp.tech.test.dao.ProsecutionDao;
import gt.com.mp.tech.test.model.db.Prosecution;
import gt.com.mp.tech.test.model.to.ProsecutionTo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author diego
 */
public class ProsecutionDaoImpl implements ProsecutionDao {

    @PersistenceContext(unitName = "testPU")
    EntityManager emConnection;

    private static final Logger LOG = Logger.getLogger(ProsecutionDaoImpl.class.getName());

    public ProsecutionDaoImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return emConnection;
    }

    @Override
    public String testConnection() {
        return "ALIVE";
    }

    @Override
    public List<ProsecutionTo> getProsecutionHeadquarterList() {
        try {
            emConnection.clear();
            String querySelect = "SELECT ph.prosecution_id, ph.name, ph.location, ph.noTel \n"
                    + "FROM prosecution_headquarter ph\n"
                    + "WHERE status = 1";
            Query query = emConnection.createNativeQuery(querySelect, ProsecutionTo.class);
            return query.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(ProsecutionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public int registerProsecutionHeadquarter(Prosecution headquarter) {
        try {
            emConnection.persist(headquarter);
            emConnection.flush();
            return headquarter.getProsecutionId();
        } catch (Exception ex) {
            Logger.getLogger(ProsecutionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public boolean updateProsecutionHeadquarter(Prosecution headquarter) {
        try {
            emConnection.merge(headquarter);
            emConnection.flush();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProsecutionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Prosecution findProsecutionHeadquarterById(int codeProsecution) {
        try {
            emConnection.clear();
            String querySelect = "SELECT * "
                    + " FROM prosecution_headquarter  "
                    + " WHERE prosecution_id = ?1  "
                    + " and status = 1 ";

            Query query = emConnection.createNativeQuery(querySelect, Prosecution.class);
            query.setParameter(1, codeProsecution);
            return (Prosecution) query.getSingleResult();
        } catch (NoResultException ex) {
            Logger.getLogger(ProsecutionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Prosecution findProsecutionHeadquarterByLocation(String location) {
        try {
            emConnection.clear();
            String querySelect = "SELECT * "
                    + " FROM prosecution_headquarter  "
                    + " WHERE location like '%?1%'  "
                    + " and status = 1 ";

            Query query = emConnection.createNativeQuery(querySelect, Prosecution.class);
            query.setParameter(1, location);
            return (Prosecution) query.getSingleResult();
        } catch (NoResultException ex) {
            Logger.getLogger(ProsecutionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
