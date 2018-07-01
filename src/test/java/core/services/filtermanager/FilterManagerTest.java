package core.services.filtermanager;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import core.services.filtermanager.impl.FilterManagerServiceImpl;
import core.services.filterservice.FilterService;
import core.services.filterservice.impl.EftelingUsers;
import core.services.filterservice.impl.FacebookSocials;
import core.services.filterservice.impl.SocialsAfterFeb;
import core.services.filterservice.impl.SocialsBeforeFeb;
import core.services.filterservice.impl.SocialsWithDisney;
import core.services.filterservice.impl.SocialsWithVideoContent;
import core.services.filterservice.impl.SocialsWithoutDisney;

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

    @Test
    public void SHOULD_RETURN_FACEBOOK_SOCIALS() {
        FilterService selectedFilter = service.getFilterService(6);
        assertEquals(selectedFilter.getClass(), FacebookSocials.class);
    }

    @Test
    public void SHOULD_RETURN_SOCIALS_AFTER_FEB() {
        FilterService selectedFilter = service.getFilterService(5);
        assertEquals(selectedFilter.getClass(), SocialsAfterFeb.class);
    }

    @Test
    public void SHOULD_RETURN_SOCIALS_BEFORE_FEB() {
        FilterService selectedFilter = service.getFilterService(4);
        assertEquals(selectedFilter.getClass(), SocialsBeforeFeb.class);
    }

    @Test
    public void SHOULD_RETURN_SOCIALS_WITH_DISNEY() {
        FilterService selectedFilter = service.getFilterService(1);
        assertEquals(selectedFilter.getClass(), SocialsWithDisney.class);
    }

    @Test
    public void SHOULD_RETURN_SOCIALS_WITHOUT_DISNEY() {
        FilterService selectedFilter = service.getFilterService(2);
        assertEquals(selectedFilter.getClass(), SocialsWithoutDisney.class);
    }

    @Test
    public void SHOULD_RETURN_SOCIALS_WITH_VIDEO_CONTENT() {
        FilterService selectedFilter = service.getFilterService(3);
        assertEquals(selectedFilter.getClass(), SocialsWithVideoContent.class);
    }

}