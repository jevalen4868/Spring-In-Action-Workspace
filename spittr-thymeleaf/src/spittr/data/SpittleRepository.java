/**
 * 
 */
package spittr.data;

import java.util.List;

import spittr.Spittle;
import spittr.web.DuplicateSpittleException;
import spittr.web.SpittleNotFoundException;

/**
 * @author jeremyvalenzuela
 *
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId) throws SpittleNotFoundException;

    void save(Spittle spittle) throws DuplicateSpittleException;
}
