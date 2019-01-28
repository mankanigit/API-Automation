package restAPIFramework.com.rest.requestpojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InitBackUpJob {

	@SerializedName("clientId")
	@Expose
	private String clientId;
	@SerializedName("sourceZone")
	@Expose
	private String sourceZone;
	@SerializedName("sourceRegionName")
	@Expose
	private String sourceRegionName;
	@SerializedName("skipActivityData")
	@Expose
	private Boolean skipActivityData;
	@SerializedName("isAnonymize")
	@Expose
	private Boolean isAnonymize;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSourceZone() {
		return sourceZone;
	}

	public void setSourceZone(String sourceZone) {
		this.sourceZone = sourceZone;
	}

	public String getSourceRegionName() {
		return sourceRegionName;
	}

	public void setSourceRegionName(String sourceRegionName) {
		this.sourceRegionName = sourceRegionName;
	}

	public Boolean getSkipActivityData() {
		return skipActivityData;
	}

	public void setSkipActivityData(Boolean skipActivityData) {
		this.skipActivityData = skipActivityData;
	}

	public Boolean getIsAnonymize() {
		return isAnonymize;
	}

	public void setIsAnonymize(Boolean isAnonymize) {
		this.isAnonymize = isAnonymize;
	}

}