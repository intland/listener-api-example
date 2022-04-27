package com.intland.codebeamer.event.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.intland.codebeamer.event.BaseEvent;
import com.intland.codebeamer.event.ProjectListener;
import com.intland.codebeamer.event.util.VetoException;
import com.intland.codebeamer.persistence.dto.ProjectDto;

@Component("dummyProjectListener")
public class DummyProjectListener implements ProjectListener {

	 private static final Logger logger = LogManager.getLogger(DummyProjectListener.class);
	
	@Override
	public void projectCreated(BaseEvent<ProjectDto, Void, Void> event) throws VetoException {
		String projectName = getProjectName(event);
		
		if (event.isPreEvent()) {
			logger.info("'{}' project will be created", projectName);			
		}
		
		if (event.isPostEvent()) {
			logger.info("'{}' project created", projectName);			
		}
	}

	@Override
	public void projectUpdated(BaseEvent<ProjectDto, ProjectDto, Void> event) throws VetoException {
		String projectName = getProjectName(event);
		
		if (event.isPreEvent()) {
			logger.info("'{}' project will be updated", projectName);			
		}
		
		if (event.isPostEvent()) {
			logger.info("'{}' project updated", projectName);			
		}
	}
	
	@Override
	public void projectDeleted(BaseEvent<ProjectDto, Void, Void> event) throws VetoException {
		String projectName = getProjectName(event);
		
		if (event.isPreEvent()) {
			logger.info("'{}' project will be removed", projectName);			
		}
		
		if (event.isPostEvent()) {
			logger.info("'{}' project removed", projectName);			
		}
	}
	
	private String getProjectName(BaseEvent<ProjectDto, ?, Void> event) {
		return event.getSource().getName();
	}
}