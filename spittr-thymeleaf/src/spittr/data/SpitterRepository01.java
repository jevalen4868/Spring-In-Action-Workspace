package spittr.data;

import spittr.Spitter;

public class SpitterRepository01 implements SpitterRepository {

    @Override
    public Spitter save(Spitter spitter) {
	spitter.setId(Long.MIN_VALUE);
	return spitter;
    }

    @Override
    public Spitter findByUserId(String username) {
	// TODO Auto-generated method stub
	return null;
    }

}
