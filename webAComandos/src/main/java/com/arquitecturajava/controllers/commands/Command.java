package com.arquitecturajava.controllers.commands;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {

	public void execute (HttpServletRequest request, HttpServletResponse response) throws Exception;
}
