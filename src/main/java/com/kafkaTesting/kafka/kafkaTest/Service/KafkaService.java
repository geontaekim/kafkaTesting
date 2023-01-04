package com.kafkaTesting.kafka.kafkaTest.Service;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

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


	public ArrayList<HashMap<String , Object>> selectEmpList(HashMap<String,Object> map) throws ParseException{
		log.debug("[selectEmpList][work]");
		log.debug("[selectEmpList][check map]:::{}"+map);
		ArrayList<HashMap<String , Object>> result=kafkamapper.selectEmpList();

		log.debug("[checkResult]"+result);
		
		
		for(HashMap<String , Object> res : result) {
			
			JSONObject json = new JSONObject(res);
			log.debug("check:::"+json);
			this.kafkaTemplate.send("guntae",json.toString());
		}
	
		//this.kafkaTemplate.send("guntae2",result.toString());

		return result;
		
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
