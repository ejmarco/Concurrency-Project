package core.services.filterservice.impl;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
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
        return filterValue.equals(socialObject.optString(filterKey, StringUtils.EMPTY));
    }
}
