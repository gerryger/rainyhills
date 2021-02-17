package com.ggunawan.rainyhills.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggunawan.rainyhills.models.HillsRequest;
import com.ggunawan.rainyhills.models.VolumeResponse;
import com.ggunawan.rainyhills.services.VolumeCalculatorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/volume-service")
public class RainyHillsController {

	@Autowired
	VolumeCalculatorService service;
	
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
