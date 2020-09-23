package com.ing.resale.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WareHouse {

	@Id
	private int id;
	private String name;
	private Location location;
	private List<Car> carList;

}
