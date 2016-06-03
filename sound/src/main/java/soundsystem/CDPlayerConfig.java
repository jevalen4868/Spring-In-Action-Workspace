/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jeremyvalenzuela
 */
@Configuration
//@ComponentScan(basePackages = "soundsystem")
public class CDPlayerConfig {
    @Bean(name = "lonelyHeartsClubBand")
    public CompactDisc sgtPeppers()
    {
        return new SgtPeppers();
    }
    @Bean
    public CDPlayer cdPlayer()
    {
        return new CDPlayer(sgtPeppers());
    }
}
