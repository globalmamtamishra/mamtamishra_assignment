package com.coding.all;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class publicController {
	
	@Autowired
	private ResultDao resultDao;
	
	@GetMapping("/callingPublicApi")
	public ResponseEntity<List<Result>> response(){
		
		
		String uri = "https://free-apis.github.io/#/categories/Anime";
		
		RestTemplate  restTemplate = new RestTemplate();
		
		List<Result> list = (List<Result>) restTemplate.getForObject(uri,Result.class);
		return new ResponseEntity<List<Result>>(list,HttpStatus.OK);
		
		
	}
	
	@PostMapping("/savenewPublicApi")
	public ResponseEntity<Result> save(){
		
		
		Result result = new Result();
		result.setTitle("something New");
		result.setDescription("successful set");
		
		Result save = resultDao.save(result);
		return new  ResponseEntity<Result> (HttpStatus.OK);
		
		
	
		
		
	}
	
	
	
	
	

}
