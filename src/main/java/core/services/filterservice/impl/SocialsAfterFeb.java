package core.services.filterservice.impl;

import core.services.filterservice.AbstractFilterService;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Observable;

public class SocialsAfterFeb extends AbstractFilterService {

    private static SocialsAfterFeb socialsAfterFeb;
    private LocalDate thresholdDate = LocalDate.parse("2017-02-01");
    private static final String filterKey = "timestamp";

    private SocialsAfterFeb(){}

    public static SocialsAfterFeb getSocialsAfterFebFilter(){
        if(Objects.isNull(socialsAfterFeb)){
            socialsAfterFeb = new SocialsAfterFeb();
        }
        return socialsAfterFeb;
    }


    @Override
    protected boolean filterJSON(JSONObject socialObject) {
        boolean result = false;
        if(socialObject.has(filterKey)){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDate socialDate = LocalDate.parse(socialObject.get(filterKey).toString(), formatter);
            result = thresholdDate.isAfter(socialDate);
        }
        return result;
    }
}