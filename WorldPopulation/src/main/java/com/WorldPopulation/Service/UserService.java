package com.WorldPopulation.Service;

import com.WorldPopulation.Dto.UserDto;
import com.WorldPopulation.Entity.User;

public interface UserService {

	User save(UserDto userDto);
	
}
