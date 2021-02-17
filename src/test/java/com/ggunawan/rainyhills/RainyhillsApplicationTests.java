package com.ggunawan.rainyhills;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ggunawan.rainyhills.services.VolumeCalculatorServiceImpl;

@ExtendWith(MockitoExtension.class)
class RainyhillsApplicationTests {

	@InjectMocks
	private VolumeCalculatorServiceImpl service;

	@Test
	void when_hills_array_is_010210132121_then_volume_is_6() {
		int[] hills = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		Integer volume = service.calculateVolume(hills);
		assertTrue(volume == 6);
	}
	
	@Test
	void when_hills_height_is_less_than_3_then_volume_is_zero() {
		int[] hills = new int[] { 0, 1 };
		Integer volume = service.calculateVolume(hills);
		assertTrue(volume == 0);
	}

	@Test
	void when_hills_array_is_32412_then_volume_is_two() {
		int[] hills = new int[] { 3,2,4,1,2 };
		Integer volume = service.calculateVolume(hills);
		assertTrue(volume == 2);
	}
	
	@Test
	void when_hills_array_is_411023_then_volume_is_eight() {
		int[] hills = new int[] { 4,1,1,0,2,3 };
		Integer volume = service.calculateVolume(hills);
		assertTrue(volume == 8);
	}
}
