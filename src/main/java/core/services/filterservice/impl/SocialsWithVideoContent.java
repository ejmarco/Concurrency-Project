package core.services.filterservice.impl;

import core.services.filterservice.AbstractFilterService;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Objects;

public class SocialsWithVideoContent extends AbstractFilterService {

    private JSONArray filteredJSON;

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
            if(socialObject.get("socialType").toString().endsWith("_VIDEO")){
                filteredJSON.put(socialObject);
            }
        }
    }
}