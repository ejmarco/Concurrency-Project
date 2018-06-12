package core.services.filtermanager;

import core.services.filterservice.FilterService;

/**Interface that will manage all FilterServices and will return the selected one*/
public interface FilterManagerService {

    /**Method that will return the selected service
     * @param filterNumber number of the selected filter
     * @return the selected filter*/
    FilterService getFilterService(int filterNumber);
}
