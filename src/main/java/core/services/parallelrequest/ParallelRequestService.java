package core.services.parallelrequest;

import java.util.Random;

import core.services.filtermanager.FilterManagerService;
import core.services.filtermanager.impl.FilterManagerServiceImpl;

/** Class that will run the filter request in parallel */
public class ParallelRequestService implements Runnable {

    @Override
    public void run() {
        FilterManagerService filtersManager = new FilterManagerServiceImpl();
        Random ran = new Random();
        int maxNumber = 6;
        int minNumber = 0;
        int randomOption = ran.nextInt((maxNumber - minNumber) + 1) + minNumber;
        filtersManager.getFilterService(randomOption).printNumberOfFilteredItems();
    }
}
