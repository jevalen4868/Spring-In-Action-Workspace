package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spittle;

@Component
public class SpittleRepository01 implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
	List<Spittle> list = new ArrayList<Spittle>();
	for (int idx = 0; idx < count; idx++) {
	    Spittle spittle = new Spittle("Hi there, this is your first spittle " + idx, new Date());
	    list.add(spittle);
	}
	return list;
    }

    @Override
    public Spittle findOne(long spittleId) {
	Spittle spittle = new Spittle("Hi there, this is your first spittle", new Date());
	return spittle;
    }

}
