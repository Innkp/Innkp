package com.innkp.Innkp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
class IndexController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
