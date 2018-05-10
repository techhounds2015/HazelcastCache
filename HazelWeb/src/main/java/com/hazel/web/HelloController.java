package com.hazel.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Controller
public class HelloController {

	@Autowired
	private SampleService sampleService;

	@RequestMapping("/hello")
	public String hello(ModelMap model) {
		
		// get the name from cache
		String name = sampleService.getCustomer(1);
		System.out.println("Get the name from Hazelcast Cache=" + name);
		
		//if cache is not avaiable get the name from db or service call etc.
		if (name == null) {
			// get data from DB
		}

		return "hello";
	}
}
