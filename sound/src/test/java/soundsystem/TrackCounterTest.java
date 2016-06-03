package soundsystem;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TrackCounterConfig.class)
public class TrackCounterTest {

    
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();
    
    @Autowired 
    private TrackCounter counter;
    
    @Autowired
    private CompactDisc cd;
    
    @Test
    public void testTrackCounter()
    {
	cd.playTrack(1);
	cd.playTrack(1);
	cd.playTrack(1);
	cd.playTrack(1);
	assertEquals(4,  counter.getPlayCount(1));
    }
}
