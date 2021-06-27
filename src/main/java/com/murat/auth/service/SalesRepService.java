package com.murat.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.murat.auth.model.SalesRep;
import com.murat.auth.repository.SalesRepRepository;



@Service
@Transactional
public class SalesRepService {

	@Autowired
	SalesRepRepository sRepo;

	public void add(SalesRep salesRep) {
		sRepo.save(salesRep);
	}

	public List<SalesRep> listAll() {
		return (List<SalesRep>) sRepo.findAll();
	}

	public SalesRep get(Long id) {
		return sRepo.findById(id).get();
	}

	public void remove(Long id) {
		sRepo.deleteById(id);
	}

	public List<SalesRep> lookUp(String keyword) {
		return sRepo.search(keyword);
	}
}
