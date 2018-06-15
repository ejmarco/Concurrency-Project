package core.services.filterservice.impl;

import core.services.filterservice.AbstractFilterService;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.Objects;

public class SocialsAfterFeb extends AbstractFilterService {

    private JSONArray filteredJSON;
    private LocalDate thresholdDate = LocalDate.parse("2017-02-01");

    @Override
    public JSONArray execute() {
        if(!super.isSocialsUpdated() || Objects.isNull(filteredJSON)){
            filterJSON(super.getSocialsJSON());
        }
        return filteredJSON;
    }

    private void filterJSON(JSONArray socialsJSON){
        filteredJSON = new JSONArray();
        for(int i = 0; i < socialsJSON.length(); i++){
            JSONObject socialObject = socialsJSON.getJSONObject(i);
            LocalDate socialDate = LocalDate.parse(socialObject.get("timestamp").toString());
            if(thresholdDate.isAfter(socialDate)){
                filteredJSON.put(socialObject);
            }
        }
    }
}