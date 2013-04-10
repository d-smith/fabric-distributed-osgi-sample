/*
 *    Copyright (c) 2011 XTRAC LLC. All Rights Reserved.
 *
 *    This software and all information contained herein is the property of
 *    XTRAC LLC.  Any dissemination, disclosure, use, or reproduction of this
 *    material for any reason inconsistent with express purpose for which it
 *    has been disclosed is strictly forbidden.
 */
package planimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plan.Plan;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class PlanImpl implements Plan {
    static Logger logger = LoggerFactory.getLogger(PlanImpl.class);
    static Map<String,String> planDB = new HashMap<String,String>();

    @Override
    public void updatePlan(String user, String plan) {
        logger.info(format("updatePlan called with %s -> %s", user, plan));
        planDB.put(user,plan);
    }

    @Override
    public String getPlan(String user) {
        logger.info(format("getPlan called for %s", user));
        String plan = planDB.get(user);
        if(plan == null) return ""; else return plan;
    }
}
