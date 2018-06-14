package core.services.filterservice;

import core.services.urlreader.URLReaderService;
import core.services.urlreader.impl.SniperWallChallengeJSON;
import org.json.JSONArray;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Logger;

public abstract class AbstractFilterService implements FilterService{

    private static final Logger LOG = Logger.getLogger(AbstractFilterService.class.getName());
    private final URLReaderService jsonService = new SniperWallChallengeJSON();
    private LocalDate lastUpdated;
    private JSONArray socialsJSON;

    private LocalDate  getLastUpdated(){
        return lastUpdated;
    }

    protected JSONArray getSocialsJSON(){

        if(!isDataUpdated()){
            LOG.info("Updating socials");
            updateSocials();
        }

        return socialsJSON;
    }

    private void updateSocials(){
        try {
            lastUpdated = LocalDate.now();
            socialsJSON = (JSONArray)  jsonService.readJson().get("socials");
        }
        catch (IOException e){
            System.out.println("An unexpected error has happened, please try again\n" + e.getMessage());
        }
    }

    protected boolean isDataUpdated(){
        return !Objects.isNull(lastUpdated) && !LocalDate.now().minusDays(1).isAfter(lastUpdated);
    }

}
