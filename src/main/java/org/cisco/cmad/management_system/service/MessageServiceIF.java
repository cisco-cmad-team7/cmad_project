package org.cisco.cmad.management_system.service;

import java.util.List;

import org.cisco.cmad.management_system.domain.Message;
import org.cisco.cmad.management_system.domain.Statistics;
import org.cisco.cmad.management_system.exceptions.InvalidDataException;
import org.cisco.cmad.management_system.exceptions.MessageNotFoundException;
import org.springframework.data.domain.Page;

public interface MessageServiceIF {
	
	Message postMessage(Message message) throws InvalidDataException;
	
	List<Message> getMessageList(int pageNumber,int numOfRecords,String sortBy) throws InvalidDataException;
	
	
	Message getMessage(int id) throws MessageNotFoundException;
	
	Statistics getStatistics();
	
	
}
