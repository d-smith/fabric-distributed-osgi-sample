/*
 *    Copyright (c) 2011 XTRAC LLC. All Rights Reserved.
 *
 *    This software and all information contained herein is the property of
 *    XTRAC LLC.  Any dissemination, disclosure, use, or reproduction of this
 *    material for any reason inconsistent with express purpose for which it
 *    has been disclosed is strictly forbidden.
 */
package planimpl;

import plan.Plan;

import java.util.HashMap;
import java.util.Map;

public class PlanImpl implements Plan {
    static Map<String,String> planDB = new HashMap<String,String>();

    @Override
    public void updatePlan(String user, String plan) {
        planDB.put(user,plan);
    }

    @Override
    public String getPlan(String user) {
        String plan = planDB.get(user);
        if(plan == null) return ""; else return plan;
    }
}
