package de.incentergy.scopevisio.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.scribejava.core.model.OAuth2AccessToken;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "token_type", "access_token", "expires_in", "refresh_token", "uid", "organisationId",
		"organisationName", "teamworkTenantId" })
@NamedQueries({
	@NamedQuery(name="OAuthScopeVisioToken.findByBotIdentity", query = "SELECT o FROM OAuthScopeVisioToken o WHERE o.botIdentity = :botIdentity"),
	@NamedQuery(name="OAuthScopeVisioToken.findByOwner", query = "SELECT o FROM OAuthScopeVisioToken o WHERE o.owner = :owner")
})
@Table(indexes = {@Index(columnList = "botIdentity"), @Index(columnList = "owner")})
public class OAuthScopeVisioToken {

	@Id
	@JsonIgnore
	private String id = UUID.randomUUID().toString();

	@JsonProperty("token_type")
	private String tokenType;
	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("expires_in")
	private Integer expiresIn;
	@JsonProperty("refresh_token")
	private String refreshToken;
	@JsonProperty("uid")
	private String uid;
	@JsonProperty("organisationId")
	private Integer organisationId;
	@JsonProperty("organisationName")
	private String organisationName;
	@JsonProperty("teamworkTenantId")
	private String teamworkTenantId;
	
	@Transient
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonIgnore
	private String botIdentity;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "oAuthScopeVisioToken")
	private List<Room2Project> room2project = new ArrayList<>();
	
	@JsonIgnore
	private String owner;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public OAuthScopeVisioToken() {
	}

	/**
	 *
	 * @param expiresIn
	 * @param uid
	 * @param organisationName
	 * @param organisationId
	 * @param teamworkTenantId
	 * @param tokenType
	 * @param accessToken
	 * @param refreshToken
	 */
	public OAuthScopeVisioToken(String tokenType, String accessToken, Integer expiresIn, String refreshToken,
			String uid, Integer organisationId, String organisationName, String teamworkTenantId) {
		super();
		this.tokenType = tokenType;
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
		this.refreshToken = refreshToken;
		this.uid = uid;
		this.organisationId = organisationId;
		this.organisationName = organisationName;
		this.teamworkTenantId = teamworkTenantId;
	}

	public OAuthScopeVisioToken(OAuth2AccessToken accessToken2) {
		super();
		this.tokenType = accessToken2.getTokenType();
		this.accessToken = accessToken2.getAccessToken();
		this.expiresIn = accessToken2.getExpiresIn();
		this.refreshToken = accessToken2.getRefreshToken();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.botIdentity = id;
	}

	@JsonProperty("token_type")
	public String getTokenType() {
		return tokenType;
	}

	@JsonProperty("token_type")
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}

	@JsonProperty("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@JsonProperty("expires_in")
	public Integer getExpiresIn() {
		return expiresIn;
	}

	@JsonProperty("expires_in")
	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	@JsonProperty("refresh_token")
	public String getRefreshToken() {
		return refreshToken;
	}

	@JsonProperty("refresh_token")
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@JsonProperty("uid")
	public String getUid() {
		return uid;
	}

	@JsonProperty("uid")
	public void setUid(String uid) {
		this.uid = uid;
	}

	@JsonProperty("organisationId")
	public Integer getOrganisationId() {
		return organisationId;
	}

	@JsonProperty("organisationId")
	public void setOrganisationId(Integer organisationId) {
		this.organisationId = organisationId;
	}

	@JsonProperty("organisationName")
	public String getOrganisationName() {
		return organisationName;
	}

	@JsonProperty("organisationName")
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	@JsonProperty("teamworkTenantId")
	public String getTeamworkTenantId() {
		return teamworkTenantId;
	}

	@JsonProperty("teamworkTenantId")
	public void setTeamworkTenantId(String teamworkTenantId) {
		this.teamworkTenantId = teamworkTenantId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public String getBotIdentity() {
		return botIdentity;
	}

	public void setBotIdentity(String botId) {
		this.botIdentity = botId;
	}

	public List<Room2Project> getRoom2project() {
		return room2project;
	}

	public void setRoom2project(List<Room2Project> room2project) {
		this.room2project = room2project;
	}
	
	public void addRoom2project(String roomId, Long projectId) {
		this.getRoom2project().add(new Room2Project(roomId, projectId, this));
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}