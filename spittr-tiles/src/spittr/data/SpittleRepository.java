/**
 * 
 */
package spittr.data;

import java.util.List;

import spittr.Spittle;

/**
 * @author jeremyvalenzuela
 *
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId);
}
