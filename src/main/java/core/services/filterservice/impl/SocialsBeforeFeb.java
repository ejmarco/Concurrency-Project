package core.services.filterservice.impl;

import core.services.filterservice.AbstractFilterService;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class SocialsBeforeFeb extends AbstractFilterService {

    private static SocialsBeforeFeb socialsBeforeFeb;
    private LocalDate thresholdDate = LocalDate.parse("2017-02-01");
    private static final String filterKey = "timestamp";

    private SocialsBeforeFeb(){}

    public static SocialsBeforeFeb getSocialsBeforeFebFilter(){
        if(Objects.isNull(socialsBeforeFeb)){
            socialsBeforeFeb = new SocialsBeforeFeb();
        }
        return socialsBeforeFeb;
    }


    @Override
    protected boolean filterJSON(JSONObject socialObject) {
        boolean result = false;
        if(socialObject.has(filterKey)){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDate socialDate = LocalDate.parse(socialObject.get(filterKey).toString(), formatter);
            result = thresholdDate.isBefore(socialDate);
        }
        return result;
    }

}