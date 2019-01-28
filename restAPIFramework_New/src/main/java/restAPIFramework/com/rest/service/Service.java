package restAPIFramework.com.rest.service;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.testng.Assert;
import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import restAPIFramework.com.rest.requestpojo.InitBackUpJob;
import restAPIFramework.com.rest.responsepojo.GetJobIdStatusResponse;
import restAPIFramework.com.rest.responsepojo.InitBackUpJobResponse;

public class Service {
	List<JSONObject> list;
	static String jobID;
	
	/**
	 * This API will create Backup
	 * @param clientId
	 * @param sourceZone
	 * @param sourceRegionName
	 * @param isAnonymize
	 * @param skipActivityData
	 * @return
	 */
	
	public Response initBackupJob(String clientId, String sourceZone, String sourceRegionName, boolean isAnonymize, boolean skipActivityData){
		InitBackUpJob initBackUpJob = new InitBackUpJob();
		initBackUpJob.setClientId(clientId);
		initBackUpJob.setSourceZone(sourceZone);
		initBackUpJob.setSourceRegionName(sourceRegionName);
		initBackUpJob.setIsAnonymize(isAnonymize);
		initBackUpJob.setSkipActivityData(skipActivityData);	
	
		
		JSONObject jsonObj = new JSONObject(initBackUpJob);
		System.out.println("json payload..");		
		System.out.println(jsonObj);
		
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType("application/json");
		requestSpecification.accept("application/json");
		requestSpecification.body(jsonObj.toString());		
		System.out.println("end point url.."+ ServiceURL.initBackUpJob);
		Response response = requestSpecification.post(ServiceURL.initBackUpJob);
		
		return response;
	}
	
	/**
	 * This API will show Status
	 * @param jobID	
	 * @return
	 */
	public Response jobIDStatus(String jobID){		
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType("application/json");
		requestSpecification.accept("application/json");
		System.out.println("end point url.."+ServiceURL.getJobIdStatus +jobID+"/Status");
		Response response = requestSpecification.get(ServiceURL.getJobIdStatus +jobID+"/Status");
		return response;
	}
	
	
 	/*public Response createPersionAPI(String name,String surname, String city,String landmark, String state, String zipcode){
		
		CreatePerson createPerson = new CreatePerson();
		createPerson.setName(name);
		createPerson.setSurname(surname);
		
		Address address = new Address();
		createPerson.setAddress(address);
		address.setCity(city);
		address.setLandmark(landmark);
		address.setState(state);
		address.setZipcode(zipcode);
		
		JSONObject jsonObj = new JSONObject(createPerson);
		System.out.println("json payload..");
		list = new ArrayList<JSONObject>();
		list.add(jsonObj);
		System.out.println(list);
		
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType("application/json");
		requestSpecification.accept("application/json");
		requestSpecification.body(list.toString());
		System.out.println("end point url.."+ServiceURL.createPersonurl);
		Response response = requestSpecification.post(ServiceURL.createPersonurl);
		return response;
	}*/
	
	/**
	 * This API will return state details
	 * @return
	 */
	public Response getStateDetails(){
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType("application/json");
		requestSpecification.accept("application/json");
		System.out.println("end point url.."+ServiceURL.createPersonurl);
		Response response = requestSpecification.get(ServiceURL.createPersonurl);
		return response;
	}
	
	/**
	 * This API will update person details
	 * @param name
	 * @param surname
	 * @param city
	 * @param landmark
	 * @param state
	 * @param zipcode
	 * @return
	 */
	/*public Response updatePersonDetail(String name,String surname, String city,String landmark, String state, String zipcode){
		UpdatePersonPojo updatePersonPojo = new UpdatePersonPojo();
		updatePersonPojo.setName(name);
		updatePersonPojo.setSurname(surname);
		
		Address address = new Address();
		updatePersonPojo.setAddress(address);
		address.setCity(city);
		address.setLandmark(landmark);
		address.setState(state);
		address.setZipcode(zipcode);
		updatePersonPojo.setAddress(address);
		
		JSONObject jsonObj = new JSONObject(updatePersonPojo);
		System.out.println("json payload..");
		list = new ArrayList<JSONObject>();
		list.add(jsonObj);
		System.out.println(list);
		
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType("application/json");
		requestSpecification.accept("application/json");
		requestSpecification.body(list.toString());
		System.out.println("end point url.."+ServiceURL.updatePersonDetails);
		Response response = requestSpecification.put(ServiceURL.updatePersonDetails);
		return response;
	}*/
	
/*	public static void main(String[] args) {
		String status = "",ziplocation = "";
		Service service = new Service();			
		Response data = service.initBackupJob("bddemo9pstsr51","bddemo9","us-east-1",false,true);
		System.out.println( "===> " + data.getStatusCode());
		
		if(data.getStatusCode()== 201){
			System.out.println(data.asString());
			Gson gson = new Gson();
			InitBackUpJobResponse initBackUpJobResponse = gson.fromJson(data.asString(),InitBackUpJobResponse.class);
			System.out.println(initBackUpJobResponse.getId());
			Assert.assertNotEquals(initBackUpJobResponse.getId(), null);
			jobID = initBackUpJobResponse.getId();
		}else{
			Assert.fail("The Backup Job ID is not created !!");
		}			
		data = service.jobIDStatus(jobID);
		System.out.println( "===> " + data.getStatusCode());
		try{
		if(data.getStatusCode()== 200){
			
			System.out.println(data.asString());
			Gson gson = new Gson();	
			do{
				data = service.jobIDStatus(jobID);
				GetJobIdStatusResponse getJobIdStatusResponse = gson.fromJson(data.asString(),GetJobIdStatusResponse.class);			
				
				status = getJobIdStatusResponse.getStatus();			
				ziplocation = getJobIdStatusResponse.getLocationOfZipFileForConnectorPipelineLocation();
				System.out.println("Status :"+ status);
				System.out.println("Zip :"+ ziplocation);
			}while(status=="Completed");
			System.out.println("Hello");
			//Assert.assertEquals(status,"Completed");			
			//Assert.assertNotEquals(ziplocation,null);
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		Assert.assertEquals(status,"Completed");	
		Assert.assertNotEquals(ziplocation,null);
		//Assert.assertNotEquals(ziplocation,null);
	}*/

}
