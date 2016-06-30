package spittr;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spittle {
    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message, Date time) {
	this(message, time, null, null);
    }

    public Spittle(String message, Date time, Double longitude, Double latitude) {
	this(null, message, time, longitude, latitude);
    }
    
    public Spittle(Long id, String message, Date time, Double longitude, Double latitude) {
	this.id = null;
	this.message = message;
	this.time = time;
	this.longitude = longitude;
	this.latitude = latitude;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	return HashCodeBuilder.reflectionHashCode(this,  "id", "time");
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object that) {
	return EqualsBuilder.reflectionEquals(this,  that,  "id", "time");
    }
   
}
