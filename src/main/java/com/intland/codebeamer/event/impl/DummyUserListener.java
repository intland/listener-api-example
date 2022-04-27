package com.intland.codebeamer.event.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.intland.codebeamer.event.BaseEvent;
import com.intland.codebeamer.event.UserListener;
import com.intland.codebeamer.event.util.VetoException;
import com.intland.codebeamer.persistence.dto.UserDto;

@Component("dummyUserListener")
@SuppressWarnings("rawtypes")
public class DummyUserListener implements UserListener {

	private static final Logger logger = LogManager.getLogger(DummyUserListener.class);

	@Override
	public void userCreated(BaseEvent event) throws VetoException {
		UserDto user = getUser(event);
		if (event.isPreEvent()) {
			logger.info("'{}' user will be created", user.getName());			
		}
		
		if (event.isPostEvent()) {
			logger.info("'{}' user created",  user.getName());		
		}
	}

	@Override
	public void userUpdated(BaseEvent event) throws VetoException {
		UserDto user = getUser(event);
		if (event.isPreEvent()) {
			logger.info("'{}' user will be updated", user.getName());			
		}
		
		if (event.isPostEvent()) {
			logger.info("'{}' user updated",  user.getName());		
		}
	}

	@Override
	public void userDeleted(BaseEvent event) throws VetoException {
		UserDto user = getUser(event);
		if (event.isPreEvent()) {
			logger.info("'{}' user will be removed", user.getName());			
		}
		
		if (event.isPostEvent()) {
			logger.info("'{}' user removed",  user.getName());		
		}
	}
	
	private UserDto getUser(BaseEvent event) {
		if (event.getSource() instanceof UserDto) {
			return (UserDto) event.getSource();			
		}
		
		throw new IllegalStateException("Only UserDto type is supported. Currenty type is '" + event.getSource().getClass() +"'");
	}

}