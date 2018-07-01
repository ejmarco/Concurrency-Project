package core.services.filterservice.impl;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import core.services.filterservice.AbstractFilterService;

public class SocialsWithoutDisney extends AbstractFilterService {

    private static SocialsWithoutDisney socialsWithoutDisney;
    private static final String filterValue = "disney";
    private static final String filterKey = "content";

    private SocialsWithoutDisney() {}

    public static SocialsWithoutDisney getSocialsWithoutDisneyFilter(){
        if(Objects.isNull(socialsWithoutDisney)){
            socialsWithoutDisney = new SocialsWithoutDisney();
        }
        return socialsWithoutDisney;
    }

    @Override
    protected boolean filterJSON(JSONObject socialObject) {
        return !socialObject.optString(filterKey, StringUtils.EMPTY).toLowerCase().contains(filterValue);
    }
}
