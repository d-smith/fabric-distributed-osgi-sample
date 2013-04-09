package planimpl;

import org.junit.Before;
import org.junit.Test;
import plan.Plan;

import static org.junit.Assert.assertEquals;

public class PlanImplTest {

    private Plan planSvc;

    @Before
    public void setUp() {
        planSvc = new PlanImpl();
    }

    @Test
    public void updateAndReturnPlan() {
        String user = "user";
        String plan = "the plan";
        planSvc.updatePlan(user, plan);
        assertEquals(planSvc.getPlan(user), plan);
    }


}
