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
