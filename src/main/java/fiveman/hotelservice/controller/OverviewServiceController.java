package fiveman.hotelservice.controller;

import java.util.List;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import fiveman.hotelservice.entities.OverviewService;
import fiveman.hotelservice.service.OverviewServiceService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@Api(tags = "overview")
@RequestMapping("/api/v1/")
public class OverviewServiceController {

	@Autowired
	private OverviewServiceService overviewServiceService;
	
	@GetMapping("/overview/getOverviewServices")
	@PreAuthorize("isAnonymous()")
	@ApiResponses(value = {//
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token")})
	public ResponseEntity<List<OverviewService>> getOverviewServices(){
		return new ResponseEntity<List<OverviewService>>(overviewServiceService.getAllOverviewService(), HttpStatus.OK);	
	}
	
	
	@GetMapping("/overview/getOverviewService/{id}")
	@PreAuthorize("isAnonymous()")
	@ApiResponses(value = {//
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token")})
	public ResponseEntity<OverviewService> getOverviewService(@PathVariable long id){
		return new ResponseEntity<OverviewService>(overviewServiceService.getOverviewService(id), HttpStatus.OK);
	}

	@PostMapping("/overview/addOverviewService")
	@PreAuthorize("isAnonymous()")
	@ApiModelProperty(required = true, name = "id")
	@ApiResponses(value = {//
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token")})
	public ResponseEntity<OverviewService> addOverviewService(@RequestBody OverviewService overviewService){
		return new ResponseEntity<OverviewService>(overviewServiceService.addOverviewService(overviewService), HttpStatus.OK);
	}

	@PostMapping("/overview/updateOverviewService")
	@PreAuthorize("isAnonymous()")
	@ApiResponses(value = {//
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token")})
	public ResponseEntity<OverviewService> updateOverviewService(@RequestBody OverviewService overviewService){
		return new ResponseEntity<OverviewService>(overviewServiceService.updateOverviewService(overviewService), HttpStatus.OK);
	}

	@DeleteMapping("/overview/deleteOverview/{id}")
	@PreAuthorize("isAnonymous()")
	@ApiResponses(value = {//
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token")})
	public ResponseEntity<String> deleteOverviewService(@PathVariable("id") Long id){
		return new ResponseEntity<String>(String.valueOf(overviewServiceService.deleteOverviewService(id)), HttpStatus.OK);
	}

}























