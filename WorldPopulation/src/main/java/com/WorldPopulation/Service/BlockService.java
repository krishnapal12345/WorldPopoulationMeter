package com.WorldPopulation.Service;

import org.springframework.stereotype.Service;

import com.WorldPopulation.Dto.BlockDto;
import com.WorldPopulation.Entity.BlockNumber;

@Service
public interface BlockService {

	BlockNumber save(BlockDto blockdto);

	BlockNumber getBlockNumberDetails(String countrycode, String statecode, int blockNumber);

	
}
