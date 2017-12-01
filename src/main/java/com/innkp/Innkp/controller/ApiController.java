package com.innkp.Innkp.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.innkp.Innkp.dto.CorpssDTO;
import com.innkp.Innkp.dto.VideoDTO;
import com.innkp.Innkp.dto.VideosDTO;
import com.innkp.Innkp.entity.User;
import com.innkp.Innkp.service.CorpsService;
import com.innkp.Innkp.service.DataService;
import com.innkp.Innkp.service.UserService;
import com.innkp.Innkp.service.VideoService;

/**
 * 
 * @author yangxue9
 *
 */
@RestController
@RequestMapping("/api")
public class ApiController {

	protected static Logger logger = LoggerFactory.getLogger(ApiController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private DataService dataService;
	@Autowired
	private VideoService videoService;
	@Autowired
	private CorpsService corpsService;

	@RequestMapping("/demo/{name}")
	@ResponseBody
	public String demoShowName(@PathVariable String name) {
		logger.debug("访问getUserByName,Name={}", name);
		return "name is " + name;
	}

	@RequestMapping("/initdata")
	@ResponseBody
	public String initData() {
		dataService.initData();
		return "success";
	}

	@RequestMapping("/getUserByLoginName/{loginName}")
	@ResponseBody
	public Map<String, Object> getUserByName(@PathVariable String loginName) {
		Map<String, Object> result = new HashMap<String, Object>();
		User user = userService.readByLoginName(loginName);
		Assert.notNull(user);
		result.put("name", user.getName());
		result.put("loginName", user.getLoginName());
		result.put("departmentName", user.getDepartment().getName());
		result.put("roleName", user.getRoleList().get(0).getName());
		return result;
	}

	@RequestMapping("/init")
	@ResponseBody
	public String initVideo() {
		videoService.initVideos();
		return "success";
	}

	@RequestMapping("/getvideobyname/{name}")
	@ResponseBody
	public VideoDTO getVideo(@PathVariable String name) {

		VideoDTO dto = videoService.getVideoByName(name);
		return dto;
	}

	@RequestMapping("/videos")
	@ResponseBody
	public VideosDTO getVideos() {
		VideosDTO dto = videoService.getVideos();
		return dto;
	}

	@RequestMapping("/getvideobyid")
	public VideoDTO greeting(@RequestParam(value = "id", defaultValue = "0") Long id) {
		System.out.println("value=" + id);
		VideoDTO dto = videoService.getVideoById(id);
		return dto;
	}

	@RequestMapping("/test")
	@ResponseBody
	public String initTest() {
		corpsService.initData();
		return "success";
	}

	@RequestMapping("/corpss")
	@ResponseBody
	public CorpssDTO getCorpss() {
		CorpssDTO dto = corpsService.getCorpssDTO();
		return dto;
	}

	@RequestMapping("/corps")
	@ResponseBody
	public CorpssDTO getCorps(@RequestParam(value = "id", defaultValue = "0") Long id) {
		CorpssDTO dto = corpsService.getCorpsById(id);
		return dto;
	}

	@PostMapping("/createcorps")
	public String createCorps(@RequestParam("name") String name, @RequestParam("captain") String captain,
			@RequestParam("label") String label, @RequestParam("details") String details) {
		corpsService.save(name, captain, label, details);
		return "success";
	}

	@GetMapping("/joincorps")
	public String joinCorps(@RequestParam("id") String corpsId) {
		System.out.println("corpsId=" + corpsId);
		corpsService.update(corpsId);
		// corpsService.save(name, captain, label, details);
		return "success";
	}

}
