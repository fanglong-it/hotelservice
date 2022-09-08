package fiveman.hotelservice.service.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.helpers.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import fiveman.hotelservice.entities.Device;
import fiveman.hotelservice.entities.OverviewService;
import fiveman.hotelservice.exception.AppException;
import fiveman.hotelservice.repository.OverviewServiceRepository;
import fiveman.hotelservice.service.OverviewServiceService;
import fiveman.hotelservice.utils.Common;
import fiveman.hotelservice.utils.Utilities;

@Service
public class OverviewServiceServiceImpl implements OverviewServiceService{

	@Autowired
	OverviewServiceRepository overviewServiceRepository;

	@Override
	public List<OverviewService> getAllOverviewService() {
		return overviewServiceRepository.findAll();
	}

	@Override
	public OverviewService getOverviewService(long id) {
		Optional<OverviewService> overviewService = overviewServiceRepository.findById(id);
		if(overviewService != null) {
			OverviewService dto = overviewService.orElseGet(null);
			if(dto == null) {			
				throw new AppException(HttpStatus.NOT_FOUND.value(), "Not found id = "+id);   
			}
			return dto;
		}
		return null;
	}

	@Override
	public OverviewService addOverviewService(OverviewService overviewService) {
		String title = Utilities.checkEmptyString(overviewService.getTitle()) ? overviewService.getTitle() : Common.OVERVIEW_TITLE;
		String imageUrl =  Utilities.checkEmptyString(overviewService.getImageUrl()) ? overviewService.getImageUrl() : Common.OVERVIEW_IMAGE_URL;
		String description =  Utilities.checkEmptyString(overviewService.getDescription()) ? overviewService.getDescription() : Common.OVERVIEW_DESCRIPTION;
		
		OverviewService dto = new OverviewService(overviewService.getId(), title, imageUrl, description);
		overviewServiceRepository.save(dto);
		
		return dto;
	}

	@Override
	public boolean updateOverviewService(OverviewService overviewService) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOverviewService(long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
