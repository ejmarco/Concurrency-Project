package core.services.filtermanager;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import core.services.filtermanager.impl.FilterManagerServiceImpl;
import core.services.filterservice.FilterService;
import core.services.filterservice.impl.EftelingUsers;

public class FilterManagerTest {

    private FilterManagerService service = new FilterManagerServiceImpl();

    @Test
    public void shouldReturn7Items() {
        int value = service.getNumberOfOptions();
        assertEquals(value, 7);
    }

    @Test
    public void shouldReturnEftelingFilter() {
        FilterService selectedFilter = service.getFilterService(0);
        assertEquals(selectedFilter.getClass(), EftelingUsers.class);
    }

}