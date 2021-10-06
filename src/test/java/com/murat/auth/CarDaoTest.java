package com.murat.auth;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.murat.auth.model.Car;
import com.murat.auth.service.CarService;







@SpringBootTest
class CarDaoTest {
	
	@Autowired
	private CarService repo;

	@Before
	void setUp() throws Exception {
		List<Car> carList = repo.listAll();
		carList.stream()
		.forEach(car->{
			repo.delete(car.getVin());
		});
	}

	@After
	void tearDown() throws Exception {
		
		List<Car> carList= repo.listAll();
		carList.stream()
		.forEach(car ->{
			repo.delete(car.getVin());
		});
	}

	@Test
	 void testSaveCar() {
		
		Car car = new Car();
		
		car.setVin("es1d4f");
		car.setMake("bmw");
		car.setModel("m4");
		car.setColor("blue");
		car.setYear("2022");
		
		repo.save(car);
		assertNotNull(repo.get("es1d4f").getVin());
				
		}
	
	@Test
	public void testGetCar() {
		Car car = new Car();
		
		car.setVin("es1d4f");
		car.setMake("bmw");
		car.setModel("m4");
		car.setColor("blue");
		car.setYear("2022");
		
		Car car1 = repo.get(car.getVin());
		assertNull(car1);
	}
	
	@Test
	public void testDeleteCar () {
		Car car = new Car();
		
		car.setVin("es1d4f");
		car.setMake("bmw");
		car.setModel("m4");
		car.setColor("blue");
		car.setYear("2022");
		
		repo.delete(car.getVin());
		
	}
	
	
	


	@Test
	 void testListAllCar() {
		Car car =new Car();
		car.setVin("es1d4f");
		car.setMake("bmw");
		car.setModel("m4");
		car.setColor("blue");
		car.setYear("2022");
		car.setSalesRep(car.getSalesRep());
		
		car = repo.save(car);
		
		List<Car> carList= repo.listAll();
		
		assertTrue(carList.size()>1);
	}
	
	@Test
	void testSearchCar() {
		Car car =new Car();
		car.setVin("es1d4f");
		car.setMake("bmw");
		car.setModel("m4");
		car.setColor("blue");
		car.setYear("2022");
		
		
		car = repo.save(car);
		
		List<Car> carList= repo.search("bmw");
		
		assertEquals(1, carList.size());
        assertEquals(carList.get(0), car);
	}
	

}
