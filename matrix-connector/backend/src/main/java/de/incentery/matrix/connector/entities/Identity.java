package de.incentery.matrix.connector.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Identity.findAll", query = "SELECT i FROM Identity i")
@EntityListeners(value = IdentityListener.class)
public class Identity {
	@Id
	private String id = UUID.randomUUID().toString();

	private String username;
	private String domain;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "identity")
	private List<Room> rooms = new ArrayList<Room>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "identity")
	@MapKey(name = "id")
	private Map<String, ProcessedRoomEvent> processedRoomEvents = new HashMap<>();

	public Identity() {
		super();
	}

	public Identity(String id, String username, String domain, String password) {
		super();
		this.id = id;
		this.username = username;
		this.domain = domain;
		this.password = password;
	}

	public Identity(String username, String domain, String password) {
		super();
		this.username = username;
		this.domain = domain;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "@" + getUsername() + ":" + getDomain();
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public void addRoom(String roomId) {
		this.getRooms().add(new Room(roomId, this));
	}

	public Map<String, ProcessedRoomEvent> getProcessedRoomEvents() {
		return processedRoomEvents;
	}

	public void setProcessedRoomEvents(Map<String, ProcessedRoomEvent> processedRoomEvents) {
		this.processedRoomEvents = processedRoomEvents;
	}

	public void addProcessedRoomEvent(String id, String content) {
		this.getProcessedRoomEvents().put(id, new ProcessedRoomEvent(id, content, this));
	}

}
