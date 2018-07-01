package core.services.filterservice;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**Interface for filtering the json result*/
public interface FilterService {

    /**Method that will getFilteredItems the filter and return the result as a JSONArray
     * @return the filtered result as a JSONArray*/
    List<JSONObject> getFilteredItems();

    /**Method that returns the name of the class
     * @return class simple name*/
    String getFilterName();

    /**Method that prints all items on the list*/
    void printFilteredItems();

    /**Method that prints the number of the items on the list*/
    void printNumberOfFilteredItems();

    // TODO IMPLEMENTED WITH OSGI Method that will return the number of the selected number, used for managing the filters
    //int getFilterNumber();
}
