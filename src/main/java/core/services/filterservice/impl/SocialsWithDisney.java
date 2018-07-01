package core.services.filterservice.impl;

import java.util.Objects;

import org.json.JSONObject;

import core.services.filterservice.AbstractFilterService;

public class SocialsWithDisney extends AbstractFilterService {

    private static SocialsWithDisney socialsWithDisney;
    private static final String filterValue = "disney";
    private static final String filterKey = "content";

    private SocialsWithDisney() {}

    public static SocialsWithDisney getSocialsWithDisneyFilter(){
        if(Objects.isNull(socialsWithDisney)){
            socialsWithDisney = new SocialsWithDisney();
        }
        return socialsWithDisney;
    }

    @Override
    protected boolean filterJSON(JSONObject socialObject) {
        return socialObject.has(filterKey) && socialObject.get(filterKey).toString().toLowerCase().contains(filterValue);
    }
}
