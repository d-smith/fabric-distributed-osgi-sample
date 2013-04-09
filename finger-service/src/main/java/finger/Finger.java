/*
 *    Copyright (c) 2011 XTRAC LLC. All Rights Reserved.
 *
 *    This software and all information contained herein is the property of
 *    XTRAC LLC.  Any dissemination, disclosure, use, or reproduction of this
 *    material for any reason inconsistent with express purpose for which it
 *    has been disclosed is strictly forbidden.
 */
package finger;

import plan.Plan;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.HashMap;
import java.util.Map;

@Path("/finger")
public class Finger {

    private Plan planSvc;

    public void setPlan(Plan planSvc) {
        this.planSvc = planSvc;
    }


    @GET
    @Path("/plan/{user}/")
    public String getPlan(@PathParam("user") String user) {
        String plan = planSvc.getPlan(user);
        if(plan == null) return ""; else return ("The plan for " + user + ": " + plan);
    }

    @PUT
    @Path("/plan/{user}/")
    public void updatePlan(@PathParam("user") String user, String plan) {
        planSvc.updatePlan(user, plan);
    }


}
