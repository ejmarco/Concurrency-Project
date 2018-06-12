package core.services.filtermanager.impl;

import core.services.filtermanager.FilterManagerService;
import core.services.filterservice.FilterService;
import core.services.filterservice.impl.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FilterManagerServiceImpl implements FilterManagerService {

    private static Map<Integer, FilterService> filterServices;
    static {
        Map<Integer, FilterService> filterMap = new HashMap<>();
        filterMap.put(0,new EftelingUsers());
        filterMap.put(1,new SocialsWithDisney());
        filterMap.put(2,new SocialsWithoutDisney());
        filterMap.put(3,new SocialsWithVideoContent());
        filterMap.put(4,new SocialsBeforeFeb());
        filterMap.put(5,new SocialsAfterFeb());
        filterMap.put(6,new FacebookSocials());
        filterServices = Collections.unmodifiableMap(filterMap);
    }

    @Override
    public FilterService getFilterService(int filterNumber) {
        return filterServices.get(filterNumber);
    }
}
