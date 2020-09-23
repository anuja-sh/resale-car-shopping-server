package com.ing.resale.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ing.resale.model.Car;
import com.ing.resale.model.Location;
import com.ing.resale.model.WareHouse;
import com.ing.resale.repository.ICarRepo;
import com.ing.resale.repository.IWareHouseRepo;
import com.ing.resale.service.ICarService;

@Service
public class CarServiceImpl implements ICarService {

	@Autowired
	private ICarRepo carRepo;

	@Autowired
	private IWareHouseRepo wareHouseRepo;

	public List<Car> getListOfCars(String order, String property) {

		if ("desc".equalsIgnoreCase(order))
			return carRepo.findAll(Sort.by(Order.desc(property)));
		else
			return carRepo.findAll(Sort.by(Order.asc(property)));
	}


	public ResponseEntity<String> loadData(String data) throws ParseException {

		JSONParser jsonParser = new JSONParser();
		// Read JSON file
		Object obj;
		obj = jsonParser.parse(data);

		/*
		 * Following code parse through the nested json to store the data model in the
		 * database
		 */
		JSONArray wareHouses = (JSONArray) obj;
		for (Object wareHouseData : wareHouses) {
			JSONObject wareHouseObject = (JSONObject) wareHouseData;
			JSONObject locationObject = (JSONObject) wareHouseObject.get("location");

			String longitude = (String) locationObject.get("long");
			String latitude = (String) locationObject.get("lat");

			Location location = new Location(longitude, latitude);

			int wareHouseId = Integer.parseInt((String) wareHouseObject.get("_id"));
			String wareHouseName = (String) wareHouseObject.get("name");

			JSONObject cars = (JSONObject) wareHouseObject.get("cars");
			String carLocation = (String) cars.get("location");
			JSONArray carList = (JSONArray) cars.get("vehicles");
			List<Car> list = new ArrayList<Car>();
			for (Object carObject : carList) {
				JSONObject carJSON = (JSONObject) carObject;

				long carId = (Long) carJSON.get("_id");
				String maker = (String) carJSON.get("make");
				String model = (String) carJSON.get("model");
				long year = (Long) carJSON.get("year_model");
				boolean licensed = (Boolean) carJSON.get("licensed");
				Date dateAdded = getParsedDate(carJSON);
				Double price = new Double(String.valueOf(carJSON.get("price")));

				Car car = new Car(carId, maker, model, year, price, licensed, dateAdded, carLocation);
				/* saving in the database */
				carRepo.save(car);
				list.add(car);

			}
			WareHouse wareHouse = new WareHouse(wareHouseId, wareHouseName, location, list);

			/* saving in the database */
			wareHouseRepo.save(wareHouse);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	private Date getParsedDate(JSONObject carJSON) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse((String) carJSON.get("date_added"));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
