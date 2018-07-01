package core.services.filtermanager.impl;

import core.services.filtermanager.FilterManagerService;
import core.services.filterservice.AbstractFilterService;
import core.services.filterservice.FilterService;
import core.services.filterservice.impl.*;
import core.services.urlreader.impl.SniperWallChallengeJSON;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Services that applies the adapter factory pattern
 */
public final class FilterManagerServiceImpl implements FilterManagerService {

    private static final Logger LOG = Logger.getLogger(SniperWallChallengeJSON.class);
    private static Map<Integer, AbstractFilterService> filterServices;

    static {
        Map<Integer, AbstractFilterService> filterMap = new HashMap<>();
        filterMap.put(0, EftelingUsers.getEftelingUsersFilter());
        filterMap.put(1, SocialsWithDisney.getSocialsWithDisneyFilter());
        filterMap.put(2, SocialsWithoutDisney.getSocialsWithoutDisneyFilter());
        filterMap.put(3, SocialsWithVideoContent.getSocialsWithVideoContentFilter());
        filterMap.put(4, SocialsBeforeFeb.getSocialsBeforeFebFilter());
        filterMap.put(5, SocialsAfterFeb.getSocialsAfterFebFilter());
        filterMap.put(6, FacebookSocials.getFacebookSocialsFilter());
        filterServices = Collections.unmodifiableMap(filterMap);
    }

    public FilterManagerServiceImpl() {
        SniperWallChallengeJSON socialsJSONReader = SniperWallChallengeJSON.getInstance();
        LOG.debug("Adding all observers from the list");
        filterServices.entrySet()
                .stream()
                .map(k -> k.getValue())
                .forEach(service -> socialsJSONReader.addObserver(service));

    }

    @Override
    public FilterService getFilterService(int filterNumber) {
        return filterServices.get(filterNumber);
    }

    @Override
    public void printFilterOptions() {
        filterServices.entrySet()
                .stream()
                .forEach(option -> System.out.println(option.getKey() + " - " + option.getValue().getFilterName()));
    }

    @Override
    public int getNumberOfOptions() {
        return filterServices.size();
    }
}
