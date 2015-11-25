package nl.mok.mastersofcode.adminclient.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * A node represents a single build server. Every node has a JNDI name at which
 * the build server request queue is found.
 * 
 * @author Jeroen Schepens
 */
public class Node implements Serializable {

	private static final long serialVersionUID = 4876663794887281762L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String jndi;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the JNDI name of this node's request queue.
	 * 
	 * @return The JNDI name
	 */
	public String getJndi() {
		return jndi;
	}

	/**
	 * Sets the JNDI name of this node's request queue.
	 * 
	 * @param jndi
	 *            The JDNI name
	 */
	public void setJndi(String jndi) {
		this.jndi = jndi;
	}

	@Override
	public String toString() {
		return "Node #" + id + ' ' + jndi;
	}
}