package core.services.filterservice.impl;

import java.util.Objects;

import org.json.JSONObject;

import core.services.filterservice.AbstractFilterService;

public class SocialsWithVideoContent extends AbstractFilterService {

    private static SocialsWithVideoContent socialsWithVideoContent;
    private static final String filterValue = "_VIDEO";
    private static final String filterKey = "socialType";

    private SocialsWithVideoContent() {}

    public static SocialsWithVideoContent getSocialsWithVideoContentFilter(){
        if(Objects.isNull(socialsWithVideoContent)){
            socialsWithVideoContent = new SocialsWithVideoContent();
        }
        return socialsWithVideoContent;
    }

    @Override
    protected boolean filterJSON(JSONObject socialObject) {
        return socialObject.has(filterKey) && socialObject.get(filterKey).toString().toUpperCase().endsWith(filterValue);
    }
}
