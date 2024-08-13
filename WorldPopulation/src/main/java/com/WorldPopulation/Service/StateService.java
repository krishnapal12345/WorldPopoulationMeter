package com.WorldPopulation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldPopulation.Entity.State;
import com.WorldPopulation.Repository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	public String getstatecodeByName(String statename) {
		
		State state=stateRepository.findBystatename(statename);
		if(state != null) {
			return state.getStatecode();
		}
		return null;
	}
}
