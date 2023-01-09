package com.mukund.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mukund.bean.Entry;
import com.mukund.bean.Response;
import com.mukund.dto.PublicAPIResponseDTO;
import com.mukund.exception.EntryException;
import com.mukund.service.PublicAPIService;

@RestController
public class PublicAPIController {

	@Autowired
	private PublicAPIService pApiService;

	@GetMapping("/entries/{category}")
	public ResponseEntity<Response> getTitleAndDescpByCategory(@PathVariable("category") String category) throws EntryException {
		
		List<PublicAPIResponseDTO> res = pApiService.getTitleAndDescpByCategory(category);
		
		return ResponseEntity.ok(

				Response.builder()
				.timeStamp(LocalDateTime.now())
				.httpStatus(HttpStatus.FOUND)
				.statusCode(HttpStatus.FOUND.value())
				.message("List of Api Data...")
				.data(Map.of("Response", res))
				.build()

		);
	}
	
	@PostMapping("/entries")
	public ResponseEntity<Response> saveNewEntry(@RequestBody Entry entry) throws EntryException {
		
		Entry res = pApiService.saveNewEntry(entry);
		
		return ResponseEntity.ok(

				Response.builder()
				.timeStamp(LocalDateTime.now())
				.httpStatus(HttpStatus.FOUND)
				.statusCode(HttpStatus.FOUND.value())
				.message("New Entry Saved...")
				.data(Map.of("Response", res))
				.build()

		);
	}

}
