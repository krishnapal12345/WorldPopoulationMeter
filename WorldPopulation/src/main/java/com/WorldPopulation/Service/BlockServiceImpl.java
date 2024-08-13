package com.WorldPopulation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation.Dto.BlockDto;
import com.WorldPopulation.Entity.BlockNumber;
import com.WorldPopulation.Repository.BlockRepository;

@Service
public class BlockServiceImpl implements BlockService {

	@Autowired 
	private BlockRepository blockRepository;
	
	@Override
	public  BlockNumber save(BlockDto blockDto) {
		BlockNumber block=new BlockNumber(blockDto.getblockNumber(),blockDto.getStatecode(),blockDto.getCountrycode(),blockDto.getTotalPopulation(),blockDto.getMalePopulation(),blockDto.getFemalePopulation(),blockDto.getTotalEducated(),blockDto.getMaleEducated(),blockDto.getFemaleEducated(),blockDto.getAvgAge());
		
		 return blockRepository.save(block);
	}
	
	public BlockNumber getBlockNumberDetails(String countrycode, String statecode, int blockNumber) {
		System.out.println("Blocknumber:"+blockNumber);
        return blockRepository.findByCountrycodeAndStatecodeAndBlockNumber(countrycode, statecode, blockNumber);
    }

}
