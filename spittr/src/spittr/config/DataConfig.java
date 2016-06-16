package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spittr.data.SpitterRepository;
import spittr.data.SpitterRepository01;
import spittr.data.SpittleRepository;
import spittr.data.SpittleRepository01;

@Configuration
public class DataConfig {

    @Bean
    public SpittleRepository spittleRepository01(){
	return new SpittleRepository01();
    }
    
    @Bean
    public SpitterRepository spitterRepository01(){
	return new SpitterRepository01();
    }
}
