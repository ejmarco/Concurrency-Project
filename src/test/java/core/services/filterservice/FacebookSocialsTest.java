package core.services.filterservice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import core.services.filterservice.impl.FacebookSocials;

public class FacebookSocialsTest {

    private static final String filterValue = "FACEBOOK_POST";
    private static final String filterWrongValue = "NO_FACEBOOK_POST";
    private static final String filterKey = "socialType";
    private AbstractFilterService filter = FacebookSocials.getFacebookSocialsFilter();

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