package core.services.task;

import java.util.TimerTask;

import core.services.urlreader.URLReaderService;
import core.services.urlreader.impl.SniperWallChallengeJSON;

public class SniperWallSocialsUpdaterTask extends TimerTask {

    @Override
    public void run() {
        URLReaderService socialsJSONReader = SniperWallChallengeJSON.getInstance();
        socialsJSONReader.updateSocials();
    }
}
