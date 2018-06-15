package main;

import java.io.IOException;

import core.services.filtermanager.FilterManagerService;
import core.services.filtermanager.impl.FilterManagerServiceImpl;
import org.json.JSONException;

public class main {
    private static FilterManagerService filterService = new FilterManagerServiceImpl();

    public static void main(String[] args) throws IOException, JSONException {
        filterService.getFilterService(4).execute();
    }
}
