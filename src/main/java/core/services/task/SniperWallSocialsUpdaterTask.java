package core.services.task;

import java.util.TimerTask;

import core.services.urlreader.URLReaderService;
import core.services.urlreader.impl.SniperWallChallengeJSON;

/**Timer Task Class to update the socials. This is used to schedule the update of the socials every day at 2am*/
public class SniperWallSocialsUpdaterTask extends TimerTask {

    @Override
    public void run() {
        URLReaderService socialsJSONReader = SniperWallChallengeJSON.getInstance();
        socialsJSONReader.updateSocials();
    }
}
