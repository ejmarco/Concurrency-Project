package core.services.filterservice.impl;

import core.services.filterservice.AbstractFilterService;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class SocialsBeforeFeb extends AbstractFilterService {

    private static SocialsBeforeFeb socialsBeforeFeb;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private LocalDate thresholdDate = LocalDate.parse("2017-02-01 00:00:00", formatter);
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
        try {
            if (socialObject.has(filterKey)) {
                LocalDate socialDate = LocalDate.parse(socialObject.optString(filterKey, StringUtils.EMPTY), formatter);
                result = thresholdDate.isAfter(socialDate);
            }
        } catch(DateTimeParseException e){
            LOG.error("Could not parse the given date");
        }
        return result;
    }

}