package core.services.urlreader.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

import core.services.urlreader.URLReaderService;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SniperWallChallengeJSON extends Observable implements URLReaderService {

    private final static Logger LOG = Logger.getLogger(SniperWallChallengeJSON.class);
    private final String url = "https://s3-eu-west-1.amazonaws.com/snipperwall-challenge/socials.json";
    private JSONArray socialsJSON;
    private static SniperWallChallengeJSON instance;

    private SniperWallChallengeJSON(){}

    public static SniperWallChallengeJSON getInstance() {
        if(Objects.isNull(instance)){
            instance = new SniperWallChallengeJSON();
        }
        return instance;
    }

    @Override
    public void updateSocials() {
        try {
            socialsJSON = (JSONArray) readJson().get("socials");
            List<JSONObject> socials = convertJSONArraytoList(socialsJSON);
            setChanged();
            notifyObservers(socials);
        } catch (IOException e) {
            System.err.println("An unexpected error has happened, please try again\n" + e.getMessage());
        }
    }

    private synchronized JSONObject readJson() throws IOException {
        LOG.info("Reading JSON from url: " + url);
        InputStream is = new URL(url).openStream();
        JSONObject json = new JSONObject();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            json = new JSONObject(jsonText);
        } catch (JSONException e) {
            System.err.println("An error has occurred, please try again");
            LOG.info("An error has occurred while creating the JSONObject:\n" + e.getMessage());
        } finally {
            is.close();
            return json;
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private List<JSONObject> convertJSONArraytoList(JSONArray jsonArray) {
        List<JSONObject> result = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            result.add((JSONObject) jsonArray.get(i));
        }
        return result;
    }
}