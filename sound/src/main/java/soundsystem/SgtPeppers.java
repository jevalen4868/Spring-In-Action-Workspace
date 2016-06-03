/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundsystem;

import org.springframework.stereotype.Component;

/**
 *
 * @author jeremyvalenzuela
 */
@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc{
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void playTrack(int TrackNumber) {
        System.out.println("Playing " + title + " by " + artist);
    }
}
