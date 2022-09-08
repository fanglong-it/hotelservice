package fiveman.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fiveman.hotelservice.entities.OverviewService;
import fiveman.hotelservice.service.OverviewServiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@Api(tags = "overview")
@RequestMapping("/api/v1/")
public class OverviewServiceController {

	@Autowired
	private OverviewServiceService overviewServiceService;
	
	@GetMapping("/overview/getOverviewServices")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public ResponseEntity<List<OverviewService>> getOverviewServices(){
		return new ResponseEntity<List<OverviewService>>(overviewServiceService.getAllOverviewService(), HttpStatus.OK);	
	}
	
	
	@GetMapping("/overview/getOverviewService/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public ResponseEntity<OverviewService> getOverviewService(@PathVariable long id){
		return new ResponseEntity<OverviewService>(overviewServiceService.getOverviewService(id), HttpStatus.OK);
	}

	@PostMapping("/overview/addOverviewService")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public ResponseEntity<OverviewService> addOverviewService(@RequestBody OverviewService overviewService){
		return new ResponseEntity<OverviewService>(overviewServiceService.addOverviewService(overviewService), HttpStatus.OK);
	}
}























