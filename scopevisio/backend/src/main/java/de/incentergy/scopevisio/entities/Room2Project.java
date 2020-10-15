package de.incentergy.scopevisio.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Room2Project.findByroomId", query = "SELECT r FROM Room2Project r WHERE r.roomId = :roomId")
})
public class Room2Project {
	@Id
	private String id = UUID.randomUUID().toString();
	
	private String roomId;
	
	private Long projectId;

	@ManyToOne
	private OAuthScopeVisioToken oAuthScopeVisioToken;

	public Room2Project() {
		
	}
	
	public Room2Project(String roomId, Long projectId, OAuthScopeVisioToken oAuthScopeVisioToken) {
		super();
		this.roomId = roomId;
		this.projectId = projectId;
		this.oAuthScopeVisioToken = oAuthScopeVisioToken;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public OAuthScopeVisioToken getoAuthScopeVisioToken() {
		return oAuthScopeVisioToken;
	}

	public void setoAuthScopeVisioToken(OAuthScopeVisioToken oAuthScopeVisioToken) {
		this.oAuthScopeVisioToken = oAuthScopeVisioToken;
	}
	
	
}
