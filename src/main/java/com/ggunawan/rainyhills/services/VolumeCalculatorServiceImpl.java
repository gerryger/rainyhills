package com.ggunawan.rainyhills.services;

import org.springframework.stereotype.Service;

@Service
public class VolumeCalculatorServiceImpl implements VolumeCalculatorService {

	@Override
	public Integer calculateVolume(int[] hills) {
		
		int n = hills.length;
		int volume = 0;
		
		if (n < 3) {
			return 0;
		}
		
		int[] maxLeft = new int[n];
		int[] maxRight = new int[n];
		
		maxLeft[0] = hills[0];
		for(int i = 1 ; i < n ; i++) {
			maxLeft[i] = Math.max(maxLeft[i-1], hills[i]);
		}
		
		maxRight[n-1] = hills[n-1];
		for(int j = n - 2 ; j >= 0 ; j--) {
			maxRight[j] = Math.max(maxRight[j+1], hills[j]);
		}
		
		for(int k = 0 ; k < n ; k++) {
			volume += Math.min(maxLeft[k], maxRight[k]) - hills[k];
		}
		
		return volume;
	}

}
