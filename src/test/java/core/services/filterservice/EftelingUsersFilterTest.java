package core.services.filterservice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import core.services.filterservice.impl.EftelingUsers;

public class EftelingUsersFilterTest {

    private static final String filterValue = "efteling";
    private static final String filterWrongValue = "efteling3";
    private static final String filterKey = "username";
    private AbstractFilterService filter = EftelingUsers.getEftelingUsersFilter();

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