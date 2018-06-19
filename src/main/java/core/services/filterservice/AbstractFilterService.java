package core.services.filterservice;

import core.services.urlreader.URLReaderService;
import core.services.urlreader.impl.SniperWallChallengeJSON;
import org.json.JSONArray;

import java.util.logging.Logger;

/**Abstract class to control all filter services*/
public abstract class AbstractFilterService implements FilterService{

    private static final Logger LOG = Logger.getLogger(AbstractFilterService.class.getName());
    private final URLReaderService jsonService = SniperWallChallengeJSON.getInstance();

    protected JSONArray getSocialsJSON(){
        return jsonService.getJSON();
    }
    protected boolean isSocialsUpdated(){
        return jsonService.isSocialsUpdated();
    }

}
