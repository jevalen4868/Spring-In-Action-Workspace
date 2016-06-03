/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jeremyvalenzuela
 */
@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;
    
    @Autowired
    public CDPlayer(CompactDisc cd)
    {
        this.cd = cd;
    }
    
    @Override
    public void play() {
        cd.playTrack(1);
    }
    
}
