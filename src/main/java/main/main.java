package main;

import java.io.IOException;

import core.services.filtermanager.FilterManagerService;
import core.services.filtermanager.impl.FilterManagerServiceImpl;
import core.services.filterservice.FilterService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class main {
    private static FilterManagerService filterService = new FilterManagerServiceImpl();
    private static String objectPlaceholder = "Item %d:\nMessage type: %s\nContent: %s\nUser: %s\n";

    public static void main(String[] args) throws IOException, JSONException {
        FilterService service = filterService.getFilterService(4);
        JSONArray test =  service.execute();
        System.out.println(test.length() + " Result for the filter " + service.getClass().getSimpleName());
        printObjects(test);
    }

    private static void printObjects(JSONArray objectsToPrint){
        for(int i = 0; i < objectsToPrint.length(); i++){
            JSONObject item = (JSONObject) objectsToPrint.get(i);
            //TODO We could add an enumeration for each type of socialtype so it can be pretty printed depending on social types..
            System.out.println(String.format(objectPlaceholder,i,item.get("socialType"),item.get("content"),item.get("username")));
        }
    }
}
