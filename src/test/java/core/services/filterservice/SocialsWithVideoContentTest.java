package core.services.filterservice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import core.services.filterservice.impl.SocialsWithVideoContent;

public class SocialsWithVideoContentTest {

    private static final String filterValue = "SOCIAL_WITH_VIDEO";
    private static final String filterKey = "socialType";
    private static final String filterWrongValue = "SOCIAL_WITH_NOVIDEO";
    private AbstractFilterService filter = SocialsWithVideoContent.getSocialsWithVideoContentFilter();

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