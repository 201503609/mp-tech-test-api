package gt.com.mp.tech.test.svc.prosecution;

import gt.com.mp.tech.test.model.to.ProsecutionTo;
import gt.com.mp.tech.test.model.util.ResultResponse;
import java.util.List;

/**
 *
 * @author diego
 */
public interface ProsecutionSvc {

    public String testConnection();

    public List<ProsecutionTo> getProsecutionHeadquarterList();

    public ResultResponse registerProsecutionHeadquarter(ProsecutionTo request);

    public ResultResponse updateProsecutionHeadquarter(ProsecutionTo request, int typeUpdate, boolean availability);

}
