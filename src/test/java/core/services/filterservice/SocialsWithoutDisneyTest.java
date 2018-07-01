package core.services.filterservice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import core.services.filterservice.impl.SocialsWithoutDisney;

public class SocialsWithoutDisneyTest {

    private static final String filterValue = "this text contains disney";
    private static final String filterKey = "content";
    private static final String filterWrongValue = "this text doesnt contain dis-ney";
    private AbstractFilterService filter = SocialsWithoutDisney.getSocialsWithoutDisneyFilter();

    @Test
    public void SHOULD_RETURN_TRUE() {
        JSONObject eftelingObject = new JSONObject()
                .put(filterKey, filterWrongValue);
        assertTrue(filter.filterJSON(eftelingObject));

    }

    @Test
    public void SHOULD_RETURN_FALSE() {
        JSONObject eftelingObject = new JSONObject()
                .put(filterKey, filterValue);
        assertFalse(filter.filterJSON(eftelingObject));
    }

}