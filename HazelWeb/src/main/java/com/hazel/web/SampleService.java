package com.hazel.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.core.IMap;

@Service
public class SampleService implements InitializingBean {
	
	@Autowired
	private HazelcastController hazelcastController;

	protected IMap<Integer, String> customersMap;
	
	public String getCustomer(int key) {
		return customersMap.get(key);
	}

	public void afterPropertiesSet() throws Exception {
		customersMap = hazelcastController.getHZInstance().getMap("customers");
	}
}
