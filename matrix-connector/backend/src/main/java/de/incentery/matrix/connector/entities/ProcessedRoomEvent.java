package de.incentery.matrix.connector.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ProcessedRoomEvent {
	@Id
	private String id;
	
	@Column(length=65536)
	private String content;

	@ManyToOne
	private Identity identity;
	
	public ProcessedRoomEvent() {
		super();
	}

	public ProcessedRoomEvent(String id, String content, Identity identity) {
		super();
		this.id = id;
		this.content = content;
		this.identity = identity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	
	
}
