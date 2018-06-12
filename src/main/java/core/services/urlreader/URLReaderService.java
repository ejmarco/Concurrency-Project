package core.services.urlreader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/** Interface to Read the JSON from a URL*/
public interface URLReaderService {

    /**Method to read the JSON from the URL
     * @return the JSON object of the URL */
    JSONObject readJson() throws IOException;
}
