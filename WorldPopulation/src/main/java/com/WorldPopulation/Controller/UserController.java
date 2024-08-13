package com.WorldPopulation.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.WorldPopulation.Dto.BlockDto;
import com.WorldPopulation.Dto.UserDto;
import com.WorldPopulation.Entity.BlockNumber;
import com.WorldPopulation.Entity.Country;
import com.WorldPopulation.Entity.State;
import com.WorldPopulation.Repository.BlockRepository;
import com.WorldPopulation.Repository.CountryRepository;
import com.WorldPopulation.Repository.StateRepository;
import com.WorldPopulation.Service.BlockService;
import com.WorldPopulation.Service.CountryService;
import com.WorldPopulation.Service.StateService;
import com.WorldPopulation.Service.UserService;




@Controller
public class UserController {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private BlockRepository blockRepository;
	
	@Autowired
	private BlockService blockService;
	
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto,Model model,@RequestParam("role") String role) {
		userDto.setRole(role);
		userService.save(userDto);
		model.addAttribute("message","Registered successfully");
		return "redirect:/login";
	}
	
	@GetMapping("/home")
	public String HomePage() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "user";
	}
	@GetMapping("/admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		model.addAttribute("BlockNumber",new BlockDto());
	    // Add this line
		return "admin";
	}
	@PostMapping("/submit-data")
	public String SubmitData(@ModelAttribute("BlockNumber")BlockDto blockDto,@RequestParam ("country") String country,@RequestParam ("state") String state,@RequestParam("BlockNumber") int BlockNumber) {  
	    System.out.println("Country name:"+country);
	    System.out.println("state name:"+state);
	   
	    blockDto.setCountrycode(country);
	    blockDto.setStatecode(state);
	    blockDto.setblockNumber(BlockNumber);
	    
	    
	    blockService.save(blockDto);
	   
	   return "redirect:/admin-page";
	}
	@GetMapping("/fetch-data")
    public String getBlockNumberDetails(
            @RequestParam("country") String country, 
            @RequestParam("state") String state, 
            @RequestParam("BlockNumber") int BlockNumber,
            Model model) {
        
        BlockNumber blockNumberDetails = blockService.getBlockNumberDetails(country, state, BlockNumber);
        
        if (blockNumberDetails != null) {
            model.addAttribute("blockNumberDetails", blockNumberDetails);
        } else {
            model.addAttribute("error", "No data found for the given inputs.");
        }
        return "user";
    }
}
	

	
	
