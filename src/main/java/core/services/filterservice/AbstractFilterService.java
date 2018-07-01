package core.services.filterservice;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

import core.services.urlreader.impl.SniperWallChallengeJSON;

/**Abstract class to control all filter services*/
public abstract class AbstractFilterService implements FilterService, Observer {


    protected final static Logger LOG = Logger.getLogger(SniperWallChallengeJSON.class);
    private static String objectPlaceholder = "Item %d:\nMessage type: %s\nContent: %s\nUser: %s\n";
    private List<JSONObject> filteredData;

    protected abstract boolean filterJSON(JSONObject socialObject);

    @Override
    public void update(Observable o, Object arg) {
        LOG.debug("Updating socials for class " + getFilterName());
        List<JSONObject> socialsItems = (List<JSONObject>) arg;
        filteredData = socialsItems
                .stream()
                .filter(this::filterJSON)
                .collect(Collectors.toList());
    }

    @Override
    public String getFilterName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void printFilteredItems() {
        if (Objects.isNull(filteredData)) {
            System.out.println("There are no socials for " + getFilterName());
        } else {
            printObjects();
        }
    }

    @Override
    public synchronized void printNumberOfFilteredItems() {
        System.out.println(filteredData.size() + " Results for the filter " + getFilterName());
    }

    public List<JSONObject> getFilteredItems(){
        return filteredData;
    }

    private void printObjects(){
        for(int i = 0; i < filteredData.size(); i++){
            JSONObject item = filteredData.get(i);
            System.out.println(String.format(objectPlaceholder,i,
                    item.optString("socialType", "No Social Type"),
                    item.optString("content", "No Content"),
                    item.optString("username", "No Username")));
        }
    }

}
