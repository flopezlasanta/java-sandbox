package org.teraflopx.jsandboox.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teraflopx.jsandboox.Application;

@RestController
public class IndexResource implements ErrorController {

	private static final String INDEX_PATH = "/";
	private static final String ERROR_PATH = "/error";

	private final Logger log = LoggerFactory.getLogger(Application.class);

	@RequestMapping(value = INDEX_PATH)
	public String home() {
		log.debug("Touching home!");
		
		return "Welcome to JSandBoox!";
	}

	@RequestMapping(value = ERROR_PATH)
	public String error() {
		log.debug("Touching error!");
		
		return "Ups!";
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
