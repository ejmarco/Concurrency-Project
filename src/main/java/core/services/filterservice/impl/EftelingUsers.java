package core.services.filterservice.impl;

import core.services.filterservice.AbstractFilterService;
import org.json.JSONArray;

import java.util.Objects;

public class EftelingUsers extends AbstractFilterService {

    private JSONArray filteredJSON;

    @Override
    public JSONArray execute() {
        if(!super.isDataUpdated() || Objects.isNull(filteredJSON)){
            filterJSON(super.getSocialsJSON());
        }
        return filteredJSON;
    }

    private void filterJSON(JSONArray socialsJSON){
    }

}
