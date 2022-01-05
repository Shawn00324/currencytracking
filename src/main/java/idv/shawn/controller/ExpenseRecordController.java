package idv.shawn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import idv.shawn.entity.ExpenseRecord;
import idv.shawn.service.ExpenseRecordService;

@RestController
@RequestMapping("/expense_record")
public class ExpenseRecordController {
	
	@Autowired
	private ExpenseRecordService expenseRecordService;

	@GetMapping(value="{memberId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ExpenseRecord> get(@PathVariable Long memberId) throws JsonProcessingException {
		return expenseRecordService.findByMemberId(memberId);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> post(@RequestBody ExpenseRecord record) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(expenseRecordService.addRecord(record));
		
		return ResponseEntity.ok().body(jsonString);
	}
	
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@RequestBody ExpenseRecord record) throws JsonProcessingException  {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(expenseRecordService.deleteByPK(record.getExpenseId(), record.getMemberId()));
		return ResponseEntity.ok().body(jsonString);
	}
}
