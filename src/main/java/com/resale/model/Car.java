package com.resale.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	@Id
	@Field("_id")
	private long id;
	private String make;
	private String model;

	@Field("year_model")
	private long yearModel;

	private Double price;
	private boolean licensed;

	@Field("date_added")
	private Date dateAdded = null;
	private String carLocation;
}