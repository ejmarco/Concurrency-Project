package main;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import core.services.filtermanager.FilterManagerService;
import core.services.filtermanager.impl.FilterManagerServiceImpl;
import core.services.filterservice.FilterService;
import core.services.parallelrequest.ParallelRequestService;
import core.services.task.SniperWallSocialsUpdaterTask;
import core.services.urlreader.impl.SniperWallChallengeJSON;

import org.apache.log4j.Logger;

public class Main {
    private static FilterManagerService filterService;
    private static final Logger LOG = Logger.getLogger(SniperWallChallengeJSON.class);

    public static void main(String[] args){
        init();
        startProgram();
    }

    private static void init(){
        filterService = new FilterManagerServiceImpl();
        scheduleJSONReader();
    }

    private static void startProgram(){
        boolean process = true;
        while(process) {
            Scanner in = new Scanner(System.in);
            System.out.println("Select an option:");
            filterService.printFilterOptions();
            int parallelOption = filterService.getNumberOfOptions();
            System.out.println(parallelOption + " - " + "Execute 20 parallel threads");
            System.out.println(parallelOption + 1 + " - " + "End Program");
            int option = in.nextInt();
            if(option == parallelOption + 1){
                process = false;
                endProgram();
            }
            else if (option == parallelOption){
                executeParallelOption();
            }
            else{
                showOption(option);
            }
        }
    }

    private static void executeParallelOption(){
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i = 0; i<20; i++){
            ParallelRequestService parallelService = new ParallelRequestService();
            es.execute(parallelService);
        }
        es.shutdown();
        try {
            //Wait until all threads are finished
            es.awaitTermination(1, TimeUnit.SECONDS);
        }
        catch (InterruptedException e){
            LOG.error("An error has occurred while waiting for all threads to finish");
        }
    }

    private static void endProgram(){
        System.exit(0);
    }

    private static void showOption(int option){
        FilterService service = filterService.getFilterService(option);
        service.printFilteredItems();
    }

    private static synchronized void scheduleJSONReader(){

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 2);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);

        // every night at 2am update the socials
        Timer timer = new Timer();
        timer.schedule(new SniperWallSocialsUpdaterTask(), today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
    }
}
