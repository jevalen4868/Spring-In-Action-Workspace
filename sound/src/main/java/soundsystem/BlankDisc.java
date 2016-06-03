/**
 * 
 */
package soundsystem;

import java.util.List;

/**
 * @author jeremyvalenzuela
 *
 */
public class BlankDisc implements CompactDisc {

    /*
     * (non-Javadoc)
     * 
     * @see soundsystem.CompactDisc#play()
     */
    @Override
    public void playTrack(int trackNumber) {
	System.out.println("Playing " + title + " trackNumber" + trackNumber);
    }

    private String title;
    private String artist;
    private List<String> tracks;

    /**
     * @return the tracks
     */
    public List<String> getTracks() {
        return tracks;
    }

    /**
     * @param tracks the tracks to set
     */
    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * @return the artist
     */
    public String getArtist() {
	return artist;
    }

    /**
     * @param artist
     *            the artist to set
     */
    public void setArtist(String artist) {
	this.artist = artist;
    }

}
