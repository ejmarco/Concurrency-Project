package core.services.filterservice;

import org.json.JSONArray;

/**Interface for filtering the json result*/
public interface FilterService {

    /**Method that will execute the filter and return the result as a JSONArray
     * @return the filtered result as a JSONArray*/
    JSONArray execute();

    // TODO IMPLEMENTED WITH OSGI Method that will return the number of the selected number, used for managing the filters
    //int getFilterNumber();
}
