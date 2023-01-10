package com.kafkaTesting.kafka.kafkaTest.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.parser.ParseException;
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

	private final KafkaMapper kafkamapper;

	private final KafkaTemplate<String, Object> kafkaTemplate;


	public ArrayList<HashMap<String , Object>> selectEmpList(HashMap<String,Object> map) throws ParseException{
		log.debug("[selectEmpList][work]");
		log.debug("[selectEmpList][check map]:::{}"+map);
		ArrayList<HashMap<String , Object>> result=kafkamapper.selectEmpList();
		log.debug("[checkResult]"+result);
		
		this.kafkaTemplate.send("guntae","group-id-oing",result.toString());
		this.kafkaTemplate.send("guntae3","group-id-guning",result.toString());
		
		//for(HashMap<String , Object> res : result) {
			
		//	JSONObject json = new JSONObject(res);
		//	log.debug("check:::"+json);
		//	this.kafkaTemplate.send("guntae",json.toString());
		//}
	
		//this.kafkaTemplate.send("guntae2",result.toString());

		return result;
		
	}
	
	@KafkaListener(topics = "guntae2", groupId = "group-id-oing")
    public void consume2(String message) throws IOException {
	 	log.debug("222222222222222222");
	 
	 	log.debug("check:::::"+message);
       
        
    }


	public ArrayList<HashMap<String , Object>> selectKafkaList(HashMap<String,Object> map){
		log.debug("[selectEmpList][work]");
		log.debug("[selectEmpList][check map]:::{}"+map);
		ArrayList<HashMap<String , Object>> result=kafkamapper.selectEmpList();
		log.debug("[checkResult]"+result);

		this.kafkaTemplate.send("guntae2",result.toString());


		return result;

	}


}
