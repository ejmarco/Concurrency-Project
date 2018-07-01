package core.services.filtermanager;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import core.services.filtermanager.impl.FilterManagerServiceImpl;
import core.services.filterservice.FilterService;
import core.services.filterservice.impl.EftelingUsers;

public class FilterManagerTest {

    private FilterManagerService service = new FilterManagerServiceImpl();

    @Test
    public void SHOULD_RETURN_7_ITEMS() {
        int value = service.getNumberOfOptions();
        assertEquals(value, 7);
    }

    @Test
    public void SHOULD_RETURN_EFTELING_FILTER() {
        FilterService selectedFilter = service.getFilterService(0);
        assertEquals(selectedFilter.getClass(), EftelingUsers.class);
    }

}