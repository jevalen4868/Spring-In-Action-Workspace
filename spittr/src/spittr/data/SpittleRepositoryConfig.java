package spittr.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpittleRepositoryConfig {

    @Bean
    public SpittleRepository spittleRepository01(){
	return new SpittleRepository01();
    }
}
