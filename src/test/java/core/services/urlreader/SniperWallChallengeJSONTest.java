package core.services.urlreader;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import core.services.urlreader.impl.SniperWallChallengeJSON;

@RunWith(PowerMockRunner.class)
@PrepareForTest(URL.class)
public class SniperWallChallengeJSONTest {
    private SniperWallChallengeJSON service = SniperWallChallengeJSON.getInstance();
    private final String url = "https://s3-eu-west-1.amazonaws.com/snipperwall-challenge/socials.json";

    @Test
    public void shouldRequestSnipperWallURL(){
        URL mockUrl = mock(URL.class);
        //spy()
        //whenNew(URL.class).withArguments(url).thenReturn(null);
        SniperWallChallengeJSON mock = mock(SniperWallChallengeJSON.class);
        mock.updateSocials();
        verify(mock, times(1)).notifyObservers(any(JSONArray.class));
    }

}
