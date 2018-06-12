package core.services.filterservice;

import core.services.urlreader.URLReaderService;
import core.services.urlreader.impl.SniperWallChallengeJSON;
import org.json.JSONArray;

import java.io.IOException;

public abstract class AbstractFilterService implements FilterService{

    private final URLReaderService jsonService = new SniperWallChallengeJSON();
    private int lastUpdated;
    private JSONArray socialsJSON;

    private int getLastUpdated(){
        return lastUpdated;
    }

    protected JSONArray getSocialsJSON(){

        if(lastUpdated == 0){
            updateSocials();
        }

        return socialsJSON;
    }

    private void updateSocials(){
        try {
            lastUpdated = 1;
            socialsJSON = (JSONArray)  jsonService.readJson().get("social");
        }
        catch (IOException e){
            System.out.println("An unexpected error has happened, please try again\n" + e.getMessage());
        }
    }

}
