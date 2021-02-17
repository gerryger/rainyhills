package com.ggunawan.rainyhills.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggunawan.rainyhills.models.HillsRequest;
import com.ggunawan.rainyhills.models.VolumeResponse;
import com.ggunawan.rainyhills.services.VolumeCalculatorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/*
 * Endpoint to calculate water volume in rainy hills problem.
 * Serves request under "/volume-service" endpoint
 */
@RestController
@RequestMapping("/volume-service")
public class RainyHillsController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@Autowired
	VolumeCalculatorService service;
	
	/*
	 * Endpoint for healthcheck
	 * 
	 * endpoint: /volume-service/health
	 * method: GET
	 * 
	 * @return string: Message which indicates that service is running
	 */
	@GetMapping("/health")
	public String health() {
		return "Volume service is running";
	}
	
	/*
	 * Endpoint for calculating water volume
	 * 
	 * endpoint: /volume-service/calculate
	 * method: POST
	 * 
	 * @param HillsRequest: json request body with key "hills" and value of array of integers
	 * @return VolumeResponse: json response with key "volume" and value of integer
	 */
	@PostMapping("/calculate")
	@ApiOperation(value = "Calculating volume of water on hills after rain")
	@ApiParam(value = "Endpoint to calculate volume of water on hills after rain")
	public ResponseEntity<VolumeResponse> calculate(@RequestBody HillsRequest request) {
		Integer volume = service.calculateVolume(request.getHills().stream().mapToInt(i -> i).toArray());
		VolumeResponse response = new VolumeResponse();
		response.setVolume(volume);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
