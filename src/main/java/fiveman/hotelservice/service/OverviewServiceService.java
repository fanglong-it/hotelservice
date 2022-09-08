package fiveman.hotelservice.service;

import java.util.List;

import fiveman.hotelservice.entities.OverviewService;

public interface OverviewServiceService {
	List<OverviewService> getAllOverviewService();
	OverviewService getOverviewService(long id);
	OverviewService addOverviewService(OverviewService overviewService);
	boolean updateOverviewService(OverviewService overviewService);
	boolean deleteOverviewService(long id);
	
}