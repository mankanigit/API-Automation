package restAPIFramework.com.rest.responsepojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetJobIdStatusResponse {

	@SerializedName("clientId")
	@Expose
	private String clientId;
	@SerializedName("sourceZone")
	@Expose
	private String sourceZone;
	@SerializedName("sourceRegionName")
	@Expose
	private String sourceRegionName;
	@SerializedName("isAnonymize")
	@Expose
	private Boolean isAnonymize;
	@SerializedName("jobId")
	@Expose
	private String jobId;
	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("message")
	@Expose
	private Object message;
	@SerializedName("locationOfSnapshotGenratedFiles")
	@Expose
	private String locationOfSnapshotGenratedFiles;
	@SerializedName("locationOfZipFileForConnectorPipelineLocation")
	@Expose
	private String locationOfZipFileForConnectorPipelineLocation;
	@SerializedName("startTime")
	@Expose
	private String startTime;
	@SerializedName("completionTime")
	@Expose
	private Object completionTime;
	@SerializedName("dateLastModified")
	@Expose
	private String dateLastModified;
	@SerializedName("subTaskDetails")
	@Expose
	private List<SubTaskDetail> subTaskDetails = null;
	@SerializedName("skipActivityData")
	@Expose
	private Boolean skipActivityData;
	@SerializedName("taskID")
	@Expose
	private Integer taskID;
	@SerializedName("toUseProvisioningMapping")
	@Expose
	private Boolean toUseProvisioningMapping;

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

	public Boolean getIsAnonymize() {
		return isAnonymize;
	}

	public void setIsAnonymize(Boolean isAnonymize) {
		this.isAnonymize = isAnonymize;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public String getLocationOfSnapshotGenratedFiles() {
		return locationOfSnapshotGenratedFiles;
	}

	public void setLocationOfSnapshotGenratedFiles(
			String locationOfSnapshotGenratedFiles) {
		this.locationOfSnapshotGenratedFiles = locationOfSnapshotGenratedFiles;
	}

	public String getLocationOfZipFileForConnectorPipelineLocation() {
		return locationOfZipFileForConnectorPipelineLocation;
	}

	public void setLocationOfZipFileForConnectorPipelineLocation(
			String locationOfZipFileForConnectorPipelineLocation) {
		this.locationOfZipFileForConnectorPipelineLocation = locationOfZipFileForConnectorPipelineLocation;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Object getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(Object completionTime) {
		this.completionTime = completionTime;
	}

	public String getDateLastModified() {
		return dateLastModified;
	}

	public void setDateLastModified(String dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	public List<SubTaskDetail> getSubTaskDetails() {
		return subTaskDetails;
	}

	public void setSubTaskDetails(List<SubTaskDetail> subTaskDetails) {
		this.subTaskDetails = subTaskDetails;
	}

	public Boolean getSkipActivityData() {
		return skipActivityData;
	}

	public void setSkipActivityData(Boolean skipActivityData) {
		this.skipActivityData = skipActivityData;
	}

	public Integer getTaskID() {
		return taskID;
	}

	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}

	public Boolean getToUseProvisioningMapping() {
		return toUseProvisioningMapping;
	}

	public void setToUseProvisioningMapping(Boolean toUseProvisioningMapping) {
		this.toUseProvisioningMapping = toUseProvisioningMapping;
	}

}