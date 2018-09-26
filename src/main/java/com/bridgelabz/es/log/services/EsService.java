package com.bridgelabz.es.log.services;

import java.io.IOException;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EsService {
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private RestHighLevelClient client;

	public <T> void save(T object) throws IOException {
		String json = mapper.writeValueAsString(object);
		
		IndexRequest request = new IndexRequest("errorlog", "errorlog");
		request.source(json, XContentType.JSON);
		
		IndexResponse response = client.index(request, RequestOptions.DEFAULT);
		
		System.out.println("Saved at " + response.getId());
	}
}
