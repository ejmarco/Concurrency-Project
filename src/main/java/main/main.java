package main;

import static core.InformationManagement.InformationReader.readJsonFromUrl;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class main {
    public static void main(String[] args) throws IOException, JSONException {
        JSONObject json = readJsonFromUrl("https://graph.facebook.com/19292868552");
        System.out.println(json.toString());
        System.out.println(json.get("id"));
    }
}
