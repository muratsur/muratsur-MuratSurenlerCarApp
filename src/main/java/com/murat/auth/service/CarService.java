package com.murat.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.murat.auth.model.Car;
import com.murat.auth.model.SalesRep;
import com.murat.auth.repository.CarRepository;
import com.murat.auth.repository.SalesRepRepository;


@Service
@Transactional
public class CarService {
	
	private CarRepository repo;
    private SalesRepRepository repRepo;
    
    @Autowired
    public CarService(CarRepository repo, SalesRepRepository repRepo) {
    	this.repo = repo;
    	this.repRepo = repRepo;
    }
     
    public Car save(Car car) {
        return repo.save(car);
    }
     
    public List<Car> listAll() {
        return (List<Car>) repo.findAll();
    }
     
    public Car get(String vin) {
    	 if (vin == null) {
    	        return null;
    	    }
    	    return repo.findById(vin).isPresent() ? 
    	        repo.findById(vin).get(): null;
    }
     
    public void delete(String vin) {
        repo.deleteById(vin);
    }
    
    public List<Car> search(String keyword) {
        return repo.search(keyword);
    }
    
    @Transactional
	public void assignSalesRep(String vin, Long id) {
    	Car car = repo.findById(vin).get();
		SalesRep rep = repRepo.findById(id).get();
		car.setSalesRep(rep);
	}
     
}

