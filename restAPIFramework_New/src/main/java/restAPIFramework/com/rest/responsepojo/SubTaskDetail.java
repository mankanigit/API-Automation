package restAPIFramework.com.rest.responsepojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubTaskDetail {

	@SerializedName("taskId")
	@Expose
	private Integer taskId;
	@SerializedName("taskName")
	@Expose
	private String taskName;
	@SerializedName("taskComponent")
	@Expose
	private String taskComponent;
	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("startTime")
	@Expose
	private String startTime;
	@SerializedName("completeTime")
	@Expose
	private Object completeTime;
	@SerializedName("response")
	@Expose
	private Object response;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskComponent() {
		return taskComponent;
	}

	public void setTaskComponent(String taskComponent) {
		this.taskComponent = taskComponent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Object getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Object completeTime) {
		this.completeTime = completeTime;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

}
