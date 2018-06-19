package core.services.urlreader;

import org.json.JSONArray;

import java.io.IOException;

/** Interface to Read the JSON from a URL*/
public interface URLReaderService {

    /**Method to read the JSON from the URL
     * @return the JSON object of the URL */
    JSONArray getJSON();

    /**Method to track if the information that the client have is updated
     * @return either if the json that the client have is updated or not*/
    boolean isSocialsUpdated();
}
