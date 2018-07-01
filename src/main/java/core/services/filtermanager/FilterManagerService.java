package core.services.filtermanager;

import java.util.Map;

import core.services.filterservice.AbstractFilterService;
import core.services.filterservice.FilterService;

/**Interface that will manage all FilterServices and will return the selected one*/
public interface FilterManagerService {

    /**Method that will return the selected service
     * @param filterNumber number of the selected filter
     * @return the selected filter*/
    FilterService getFilterService(int filterNumber);

    /**Method that prints all the available options*/
    void printFilterOptions();

    /**Returns the number of available options*/
    int getNumberOfOptions();
}
