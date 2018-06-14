package core.services.urlreader.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Logger;

import core.services.urlreader.URLReaderService;
import org.json.JSONException;
import org.json.JSONObject;


public class SniperWallChallengeJSON implements URLReaderService {

    private static final Logger LOG = Logger.getLogger(SniperWallChallengeJSON.class.getName());
    private static final  String url = "https://s3-eu-west-1.amazonaws.com/snipperwall-challenge/socials.json";

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    @Override
    public JSONObject readJson() throws IOException {
        LOG.info("Reading JSON from url: " + url);
        InputStream is = new URL(url).openStream();
        JSONObject json = new JSONObject();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            json = new JSONObject(jsonText);
        }
        catch (JSONException e){
            System.out.println("An error has occurred, please try again");
           LOG.info("An error has occurred while creating the JSONObject:\n" + e.getMessage());
        }
        finally {
            is.close();
            return json;
        }
    }
}