package com.kafkaTesting.kafka.kafkaTest.vo;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class KafkaVo {
	
    private String productName;
    private Integer price;
    private ArrayList<HashMap<String,Object>> params;
    
    
    
}
 