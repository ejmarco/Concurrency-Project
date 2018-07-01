package core.services.filterservice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import core.services.filterservice.impl.SocialsAfterFeb;

public class SocialsAfterFebTest {

    private static final String filterValue = "2017-02-19 17:46:25";
    private static final String filterWrongValue = "2017-01-02 00:00:00";
    private static final String filterKey = "timestamp";
    private AbstractFilterService filter = SocialsAfterFeb.getSocialsAfterFebFilter();

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