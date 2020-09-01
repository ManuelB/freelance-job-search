package de.incentery.matrix.connector.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Room {
	@Id
	private String id = UUID.randomUUID().toString();
	
	private String roomId;

	@ManyToOne
	private Identity identity;
	
	public Room() {
		super();
	}

	public Room(String roomId, Identity identity) {
		super();
		this.roomId = roomId;
		this.identity = identity;
	}
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
}
