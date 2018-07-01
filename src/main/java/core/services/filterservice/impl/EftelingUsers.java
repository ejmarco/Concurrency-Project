package core.services.filterservice.impl;

import core.services.filterservice.AbstractFilterService;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.util.Objects;

public class EftelingUsers extends AbstractFilterService {

    private static EftelingUsers eftelingUsers;
    private static final String filterValue = "efteling";
    private static final String filterKey = "username";

    private EftelingUsers () {}

    public static EftelingUsers getEftelingUsersFilter(){
        if(Objects.isNull(eftelingUsers)){
            eftelingUsers = new EftelingUsers();
        }
        return eftelingUsers;
    }

    @Override
    protected boolean filterJSON(JSONObject socialObject) {
        return filterValue.equals(socialObject.optString(filterKey, StringUtils.EMPTY));
    }
}
