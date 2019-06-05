package org.cisco.cmad.management_system.controller;


import java.util.List;

import org.cisco.cmad.management_system.domain.Message;
import org.cisco.cmad.management_system.domain.Statistics;
import org.cisco.cmad.management_system.exceptions.InvalidDataException;
import org.cisco.cmad.management_system.exceptions.MessageNotFoundException;
import org.cisco.cmad.management_system.service.MessageServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class MessageController {
	
	@Autowired
	private MessageServiceIF messageService;
	
	
	@PostMapping("/message")
	public ResponseEntity<Message> add(@RequestBody Message message, UriComponentsBuilder builder) throws InvalidDataException {
		message = messageService.postMessage(message);
		HttpHeaders headers = new HttpHeaders();

		headers.setLocation(builder.path("/message/{number}").buildAndExpand(message.getId()).toUri());

		return new ResponseEntity<Message>(message, headers, HttpStatus.CREATED);
	}
	
	@GetMapping("/message/{number}")
	public ResponseEntity<Message> getMessage(@PathVariable("number") int number) throws MessageNotFoundException {
		Message message = messageService.getMessage(number);
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@GetMapping("/message")
	public ResponseEntity<List<Message>> getMessageList(@RequestParam int pageNumber,@RequestParam int numOfRecords,@RequestParam String sortBy) throws InvalidDataException {
		List<Message> messages =  messageService.getMessageList(pageNumber, numOfRecords, sortBy);
		return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
	}
	
	@GetMapping("/statistics")
	public ResponseEntity<Statistics> getStatistics() {
		Statistics statistics = messageService.getStatistics();
		return new ResponseEntity<Statistics>(statistics, HttpStatus.OK);
	}

}
