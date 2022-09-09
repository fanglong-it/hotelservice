package fiveman.hotelservice.service;

import fiveman.hotelservice.entities.OverviewService;

import java.util.List;

public interface OverviewServiceService {
    List<OverviewService> getAllOverviewService();

    OverviewService getOverviewService(long id);

    OverviewService addOverviewService(OverviewService overviewService);

    OverviewService updateOverviewService(OverviewService overviewService);

    boolean deleteOverviewService(long id);
}
