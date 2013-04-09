/*
 *    Copyright (c) 2011 XTRAC LLC. All Rights Reserved.
 *
 *    This software and all information contained herein is the property of
 *    XTRAC LLC.  Any dissemination, disclosure, use, or reproduction of this
 *    material for any reason inconsistent with express purpose for which it
 *    has been disclosed is strictly forbidden.
 */
package finger;


import org.junit.Before;
import org.junit.Test;
import plan.Plan;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FingerTest {

    private Finger finger;
    private Plan planSvc;

    @Before
    public void setUp() {
        finger = new Finger();
        planSvc = mock(Plan.class);
        finger.setPlan(planSvc);
    }

    @Test
    public void setValue_returnsValue() {
        String plan = "a plan";
        String user = "user";

        when(planSvc.getPlan(user)).thenReturn(plan);

        finger.updatePlan(user, plan);
        assertTrue(finger.getPlan(user).indexOf(plan) >= 0);

        verify(planSvc).updatePlan(user,plan);
    }

}
