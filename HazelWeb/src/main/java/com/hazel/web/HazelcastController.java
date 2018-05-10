package com.hazel.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Component
public class HazelcastController {
	
	private HazelcastInstance hazelcastInstance;

	public HazelcastInstance getHZInstance() {
		ClientConfig clientConfig = new ClientConfig();
		if (hazelcastInstance == null) {
			List<String> address = new ArrayList<String>();
			address.add("192.168.0.197");
			clientConfig.getNetworkConfig().setAddresses(address);

			GroupConfig gcfg = new GroupConfig();
			gcfg.setName("dev");
			gcfg.setPassword("dev-pass");
			clientConfig.setGroupConfig(gcfg);

			HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
			IMap map = client.getMap("customers");
			System.out.println("Map Size:" + map.size());
			return client;
		}
		return hazelcastInstance;
	}	
}
