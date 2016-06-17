package spittr.data;

import spittr.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUserId(String username);
}
