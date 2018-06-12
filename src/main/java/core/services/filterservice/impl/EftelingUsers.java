package core.services.filterservice.impl;

import core.services.filterservice.AbstractFilterService;
import org.json.JSONArray;

public class EftelingUsers extends AbstractFilterService {

    @Override
    public JSONArray execute() {
        return super.getSocialsJSON();
    }
}
