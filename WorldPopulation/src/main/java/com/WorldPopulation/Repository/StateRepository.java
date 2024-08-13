package com.WorldPopulation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WorldPopulation.Entity.State;



@Repository
public interface StateRepository extends JpaRepository<State,Integer>{

	State findBystatename(String statename);
}
