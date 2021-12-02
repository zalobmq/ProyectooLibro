package utils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="servers")
public class PersistenceUnit {
	//esto son pruebas
	private String name;
	private String serverConnection;
	
	

	public PersistenceUnit() {
		super();
	}

	public PersistenceUnit(String name, String serverConnection) {
		super();
		this.name = name;
		this.serverConnection = serverConnection;
	}

	/**
	 * @return the name
	 */
	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the serverConnection
	 */
	@XmlAttribute(name="serverConnection")
	public String getServerConnection() {
		return serverConnection;
	}

	/**
	 * @param serverConnection the serverConnection to set
	 */
	public void setServerConnection(String serverConnection) {
		this.serverConnection = serverConnection;
	}
	
	
	

}
