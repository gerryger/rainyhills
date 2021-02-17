package com.ggunawan.rainyhills.models;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HillsRequest {
	@ApiModelProperty(value = "Hills represented by array of integers", example = "[ 3, 0, 3 ]", dataType = "List")
	private List<Integer> hills;
}
