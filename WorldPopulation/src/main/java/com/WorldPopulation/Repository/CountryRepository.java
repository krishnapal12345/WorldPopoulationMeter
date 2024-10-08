package com.WorldPopulation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WorldPopulation.Entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer>{

	Country findByName(String name);
}
