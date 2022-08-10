package gt.com.mp.tech.test.svc.prosecution.impl;

import gt.com.mp.tech.test.dao.ProsecutionDao;
import gt.com.mp.tech.test.model.db.Prosecution;
import gt.com.mp.tech.test.model.to.ProsecutionTo;
import gt.com.mp.tech.test.model.util.DefaultResponseUtil;
import gt.com.mp.tech.test.model.util.MessageResult;
import gt.com.mp.tech.test.model.util.ResultResponse;
import gt.com.mp.tech.test.svc.prosecution.ProsecutionSvc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author diego
 */
public class ProsecutionSvcImpl implements ProsecutionSvc {

    @Inject
    private ProsecutionDao dao;

    private static final Logger LOG = Logger.getLogger(ProsecutionSvcImpl.class.getName());
    public static String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
    Date date;

    public ProsecutionSvcImpl() {
    }

    @Override
    public String testConnection() {
        return dao.testConnection();
    }

    @Override
    public List<ProsecutionTo> getProsecutionHeadquarterList() {
        return dao.getProsecutionHeadquarterList();
    }

    @Override
    public ResultResponse registerProsecutionHeadquarter(ProsecutionTo request) {
        ResultResponse response = new ResultResponse();

        try {

            if (validateRequestBody(request)) {
                response.getMessages().add(DefaultResponseUtil.INVALID_BODY);
                return response;
            }

            //------------------------------- INSERT 
            Prosecution headquarter = new Prosecution();
            date = new SimpleDateFormat(DATE_FORMAT).parse(dtf.format(LocalDateTime.now()));
            headquarter.setName(request.getName() == null ? "" : request.getName());
            headquarter.setLocation(request.getLocation());
            headquarter.setNoTel(request.getNoTel());
            headquarter.setCreationDate(date);
            headquarter.setStatus(true);

            int headquarterId = dao.registerProsecutionHeadquarter(headquarter);

            if (headquarterId < 1) {
                response.getMessages().add(DefaultResponseUtil.SERVER_ERROR);
                return response;
            }

            response.getMessages().add(DefaultResponseUtil.OK_REGISTER);
            return response;

        } catch (NumberFormatException | ParseException ex) {
            Logger.getLogger(ProsecutionSvcImpl.class.getName()).log(Level.SEVERE, null, ex);
            response.getMessages().add(new MessageResult(DefaultResponseUtil.ERROR_CODE, ex.getMessage()));
            return response;
        }
    }

    @Override
    public ResultResponse updateProsecutionHeadquarter(ProsecutionTo request, int typeUpdate, boolean availability) {
        ResultResponse response = new ResultResponse();

        try {

            if (validateRequestBody(request)) {
                response.getMessages().add(DefaultResponseUtil.INVALID_BODY);
                return response;
            }

            Prosecution headQrtr = dao.findProsecutionHeadquarterById(request.getProsecution_id());
            if (headQrtr == null) {
                response.getMessages().add(DefaultResponseUtil.NO_EADQUARTER);
                return response;
            }
            
            date = new SimpleDateFormat(DATE_FORMAT).parse(dtf.format(LocalDateTime.now()));
            if (typeUpdate == 0) {
                headQrtr.setName(request.getName() == null ? "" : request.getName());
                headQrtr.setLocation(request.getLocation());
                headQrtr.setNoTel(request.getNoTel());
            } else {
                headQrtr.setStatus(availability);
            }
            headQrtr.setUpdateDate(date);

            dao.updateProsecutionHeadquarter(headQrtr);

            response.getMessages().add(DefaultResponseUtil.OK_UPDATE);
            return response;

        } catch (NumberFormatException | ParseException ex) {
            Logger.getLogger(ProsecutionSvcImpl.class.getName()).log(Level.SEVERE, null, ex);
            response.getMessages().add(new MessageResult(DefaultResponseUtil.ERROR_CODE, ex.getMessage()));
            return response;
        }
    }

    private boolean validateRequestBody(ProsecutionTo request) {
        return (request == null || request.getLocation() == null
                || request.getNoTel() == null);
    }
}
