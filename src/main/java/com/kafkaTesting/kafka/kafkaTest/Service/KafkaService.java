package com.kafkaTesting.kafka.kafkaTest.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafkaTesting.kafka.kafkaTest.mapper.KafkaMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaService {
	

	
	@Autowired
	private KafkaMapper kafkamapper;
	
	private final KafkaTemplate<String, String> kafkaTemplate;

	
	public ArrayList<HashMap<String , Object>> selectEmpList(HashMap<String,Object> map){
		log.debug("[selectEmpList][work]");
		log.debug("[selectEmpList][check map]:::{}"+map);
		ArrayList<HashMap<String , Object>> result=kafkamapper.selectEmpList();
		
		log.debug("[checkResult]"+result);
		
		this.kafkaTemplate.send("guntae",result.toString());
	
		
		return result;
		
	} 
	
	 @KafkaListener(topics = "guntae", groupId = "group-id-oing")
	    public void consume(String message) throws IOException {
		 	log.debug("csadsadsadsadsadsadsad");
		 	
		 	
		 	
	        log.debug("check:::::"+message);
	        
	        
	        
	        
	    }
	
}
