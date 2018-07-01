package core.services.filterservice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import core.services.filterservice.impl.SocialsWithDisney;

public class SocialsWithDisneyTest {

    private static final String filterValue = "this text contains disney";
    private static final String filterKey = "content";
    private static final String filterWrongValue = "this text doesnt contain dis-ney";
    private AbstractFilterService filter = SocialsWithDisney.getSocialsWithDisneyFilter();

    @Test
    public void SHOULD_RETURN_TRUE() {
        JSONObject eftelingObject = new JSONObject()
                .put(filterKey, filterValue);
        assertTrue(filter.filterJSON(eftelingObject));

    }

    @Test
    public void SHOULD_RETURN_FALSE() {
        JSONObject eftelingObject = new JSONObject()
                .put(filterKey, filterWrongValue);
        assertFalse(filter.filterJSON(eftelingObject));
    }

}