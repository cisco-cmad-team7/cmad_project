package org.cisco.cmad.management_system.repo;

import java.util.List;

import org.cisco.cmad.management_system.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {

	List<Message> findAllBySeverity(String sev);

}
