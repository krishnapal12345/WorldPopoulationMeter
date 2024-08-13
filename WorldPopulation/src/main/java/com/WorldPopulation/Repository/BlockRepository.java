package com.WorldPopulation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WorldPopulation.Entity.BlockNumber;

@Repository
public interface BlockRepository extends JpaRepository<BlockNumber,Integer>{
	BlockNumber findByCountrycodeAndStatecodeAndBlockNumber(String countrycode, String statecode, int blockNumber);
	
}
