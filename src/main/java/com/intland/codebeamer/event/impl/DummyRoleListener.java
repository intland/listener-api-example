package com.intland.codebeamer.event.impl;

import org.springframework.stereotype.Component;

import com.intland.codebeamer.event.BaseEvent;
import com.intland.codebeamer.event.RoleListener;
import com.intland.codebeamer.event.util.VetoException;
import com.intland.codebeamer.manager.util.ActionData;
import com.intland.codebeamer.persistence.dto.ProjectDto;
import com.intland.codebeamer.persistence.dto.RoleDto;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Component("dummyRoleListener")
@SuppressWarnings("rawtypes") 
public class DummyRoleListener implements RoleListener {

	 private static final Logger logger = LogManager.getLogger(DummyRoleListener.class);
	
	@Override
	public void roleCreated(BaseEvent<RoleDto, ProjectDto, ActionData> event) throws VetoException {
		String roleName = getRoleName(event);
		String projectName = getProjectName(event);
		
		if (event.isPreEvent()) {
			logger.info("'{}' role will be created on '{}' project", roleName, projectName);			
		}
		
		if (event.isPostEvent()) {
			logger.info("'{}' role created on '{}' project", roleName, projectName);			
		}
	}
	
	@Override
	public void roleUpdated(BaseEvent<RoleDto, ProjectDto, RoleDto> event) throws VetoException {
		String roleName = getRoleName(event);
		String projectName = getProjectName(event);
		
		if (event.isPreEvent()) {
			logger.info("'{}' role will be updated on '{}' project", roleName, projectName);			
		}
		
		if (event.isPostEvent()) {
			logger.info("'{}' role updated on '{}' project", roleName, projectName);			
		}
	}
	
	@Override
	public void roleDeleted(BaseEvent<RoleDto, ProjectDto, ActionData> event) throws VetoException {
		String roleName = getRoleName(event);
		String projectName = getProjectName(event);
		
		if (event.isPreEvent()) {
			logger.info("'{}' role will be removed on '{}' project", roleName, projectName);			
		}
		
		if (event.isPostEvent()) {
			logger.info("'{}' role removed on '{}' project", roleName, projectName);			
		}
	}

	private String getProjectName(BaseEvent<RoleDto, ProjectDto, ?> event) {
		return event.getSecondarySource().getName();
	}

	private String getRoleName(BaseEvent<RoleDto, ProjectDto, ?> event) {
		return event.getSource().getName();
	}
	
}