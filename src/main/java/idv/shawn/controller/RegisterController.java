package idv.shawn.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import idv.shawn.dto.RegisterDto;
import idv.shawn.service.RegisterService;

@RestController
public class RegisterController {

	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerApi(@RequestBody RegisterDto registerDto) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(registerDto);
		
		if(StringUtils.isAnyEmpty(registerDto.getMemberAccount(), registerDto.getMemberPassword())) {
			return ResponseEntity.badRequest().body(jsonString);
		} else if(registerService.addMember(registerDto) == 1) {
			return ResponseEntity.badRequest().body(jsonString);
		}
		
		return ResponseEntity.ok().body(jsonString);
	}
}
