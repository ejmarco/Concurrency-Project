package core.services.urlreader;


/** Interface to Read the JSON from a URL*/
public interface URLReaderService {

    /**Method to update the socials, as this will be implemented over an Observer this will update all observers*/
    void updateSocials();
}
