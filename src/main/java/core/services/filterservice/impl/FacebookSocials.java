package core.services.filterservice.impl;

import java.util.Objects;

import org.json.JSONObject;

import core.services.filterservice.AbstractFilterService;

public class FacebookSocials extends AbstractFilterService {

    private static FacebookSocials facebookSocials;

    private static final String filterValue = "FACEBOOK_POST";
    private static final String filterKey = "socialType";

    private FacebookSocials() {}

    public static FacebookSocials getFacebookSocialsFilter(){
        if(Objects.isNull(facebookSocials)){
            facebookSocials = new FacebookSocials();
        }
        return facebookSocials;
    }

    @Override
    protected boolean filterJSON(JSONObject socialObject) {
        return socialObject.has(filterKey) && filterValue.equals(socialObject.getString(filterKey));
    }
}
