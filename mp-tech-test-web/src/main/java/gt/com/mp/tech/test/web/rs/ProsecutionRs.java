/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.mp.tech.test.web.rs;

import gt.com.mp.tech.test.svc.prosecution.ProsecutionSvc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gt.com.mp.tech.test.model.to.ProsecutionTo;
import gt.com.mp.tech.test.model.util.ResultResponse;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author diego
 */
@Path("/v1")
@Singleton
public class ProsecutionRs {

    @Inject
    private ProsecutionSvc proSvc;

    private static final Logger LOG = Logger.getLogger(ProsecutionRs.class.getName());

    public ProsecutionRs() {
    }

    @GET
    @Path("/livenessprobe")
    public String getTest() {
        return proSvc.testConnection();
    }

    @GET
    @Path("/prosecutions-list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProsecutionHeadquarterList() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<ProsecutionTo> result = proSvc.getProsecutionHeadquarterList();

        String json = gson.toJson(result);
        return json;
    }

    @POST
    @Path("/register-prosecution")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultResponse registerProsecutionHeadquarter(ProsecutionTo request) {
        return proSvc.registerProsecutionHeadquarter(request);
    }

    @PUT
    @Path("/prosecution")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultResponse updateProsecutionHeadquarter(ProsecutionTo request) {
        return proSvc.updateProsecutionHeadquarter(request, 0, false);
    }

    @PUT
    @Path("/prosecution-disable")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultResponse disableProsecutionHeadquarterStatus(ProsecutionTo request) {
        return proSvc.updateProsecutionHeadquarter(request, 2, false);
    }

    @PUT
    @Path("/prosecution-enable")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultResponse enableProsecutionHeadquarterStatus(ProsecutionTo request) {
        return proSvc.updateProsecutionHeadquarter(request, 2, true);
    }

}
