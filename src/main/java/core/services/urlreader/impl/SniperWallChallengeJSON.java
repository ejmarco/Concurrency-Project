package core.services.urlreader.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Logger;

import core.services.urlreader.URLReaderService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SniperWallChallengeJSON implements URLReaderService {

    private final Logger LOG = Logger.getLogger(SniperWallChallengeJSON.class.getName());
    private final  String url = "https://s3-eu-west-1.amazonaws.com/snipperwall-challenge/socials.json";
    private static SniperWallChallengeJSON snipperWall;
    private LocalDate lastUpdated;
    private JSONArray socialsJSON;

    private SniperWallChallengeJSON(){}

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }


    private JSONObject readJson() throws IOException {
        LOG.info("Reading JSON from url: " + url);
        InputStream is = new URL(url).openStream();
        JSONObject json = new JSONObject();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            json = new JSONObject(jsonText);
            lastUpdated = LocalDate.now();
        }
        catch (JSONException e){
            System.err.println("An error has occurred, please try again");
           LOG.info("An error has occurred while creating the JSONObject:\n" + e.getMessage());
        }
        finally {
            is.close();
            return json;
        }
    }
    @Override
    public synchronized JSONArray getJSON(){

        if(!isSocialsUpdated()){
            LOG.info("Updating socials");
            updateSocials();
        }

        return socialsJSON;
    }

    private void updateSocials(){
        try {
            socialsJSON = (JSONArray)  readJson().get("socials");
        }
        catch (IOException e){
            System.err.println("An unexpected error has happened, please try again\n" + e.getMessage());
        }
    }

    public static SniperWallChallengeJSON getInstance(){
        if(Objects.isNull(snipperWall)){
            snipperWall = new SniperWallChallengeJSON();
        }
        return snipperWall;
    }

    public boolean isSocialsUpdated(){
        return !Objects.isNull(lastUpdated) && !LocalDate.now().minusDays(1).isAfter(lastUpdated);
    }

}