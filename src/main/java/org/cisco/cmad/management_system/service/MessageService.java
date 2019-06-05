package org.cisco.cmad.management_system.service;

import java.util.List;

import org.cisco.cmad.management_system.domain.Message;
import org.cisco.cmad.management_system.domain.Statistics;
import org.cisco.cmad.management_system.exceptions.InvalidDataException;
import org.cisco.cmad.management_system.exceptions.MessageNotFoundException;
import org.cisco.cmad.management_system.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class MessageService implements MessageServiceIF{
	
	@Autowired
	private MessageRepo messageRepo;

	public Message postMessage(Message message) throws InvalidDataException {
		
		messageRepo.save(message);
		return message;
	}

	public List<Message> getMessageList(int pageNumber,int numOfRecords,String sortBy) {
		
		PageRequest page = 
				  PageRequest.of(pageNumber, numOfRecords, Sort.by(sortBy));
		
		List<Message> messages = messageRepo.findAll(page).getContent();
		
		return messages;
	}

	public Statistics getStatistics() {
		// TODO Auto-generated method stub
		List<Message> error_messages = messageRepo.findAllBySeverity("error");
		List<Message> warn_messages = messageRepo.findAllBySeverity("warn");
		List<Message> info_messages = messageRepo.findAllBySeverity("info");
		List<Message> debug_messages = messageRepo.findAllBySeverity("debug");
		Statistics statistics = new Statistics();
		statistics.setErrorMessages(error_messages.size());
		statistics.setInfoMessages(info_messages.size());
		statistics.setWarnMessages(warn_messages.size());
		statistics.setDebugMessages(debug_messages.size());
		int totalMessagesCount = error_messages.size() + info_messages.size() + warn_messages.size() + debug_messages.size();
		statistics.setTotalMessages(totalMessagesCount);
		return statistics;
	}

	public Message getMessage(int id) throws MessageNotFoundException {
		
		Message message = messageRepo.findById(id).orElseThrow(() -> new MessageNotFoundException());
		return message;
	}

	
	

}
