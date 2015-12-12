package remote.ws.mok.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Gijs
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Node{

	private int id;

	private String jndi;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJndi() {
		return jndi;
	}

	public void setJndi(String jndi) {
		this.jndi = jndi;
	}
}