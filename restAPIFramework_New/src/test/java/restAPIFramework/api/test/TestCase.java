package restAPIFramework.api.test;

import java.util.List;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import restAPIFramework.com.rest.responsepojo.GetJobIdStatusResponse;
import restAPIFramework.com.rest.responsepojo.InitBackUpJobResponse;
import restAPIFramework.com.rest.service.Service;
import com.google.gson.Gson;
import com.jayway.restassured.response.Response;

public class TestCase {

	List<JSONObject> list;
	static String jobID;
	String clientID = "bddemo9pstsr51";
	String zone = "bddemo9";
	String region = "us-east-1";
	
	
	/*
	 *Scenario_1 : Verify that the backup should be take on flag 
	 *isAnonymize = false
	 *skipActivityData = true
	 */
	@Test
	public void Scenario_1(){
		System.out.println("=============== Scenario 1 ===============");
		System.out.println("Backup = isAnonymize = False & skipActivityData = True");
		System.out.println("=============== Scenario 1 ===============");
		String status = "",ziplocation = "";
		Service service = new Service();			
		Response data = service.initBackupJob(clientID,zone,region,false,true);
		System.out.println( "Status Code ===> " + data.getStatusCode());
		
		if(data.getStatusCode()== 201){
		//	System.out.println(data.asString());
			Gson gson = new Gson();
			InitBackUpJobResponse initBackUpJobResponse = gson.fromJson(data.asString(),InitBackUpJobResponse.class);
		//	System.out.println(initBackUpJobResponse.getId());
			Assert.assertNotEquals(initBackUpJobResponse.getId(), null);
			jobID = initBackUpJobResponse.getId();
			System.out.println("JOBID = " + jobID);
		}else{
			Assert.fail("The Backup Job ID is not created !!");
		}			
		data = service.jobIDStatus(jobID);
		System.out.println( "JOB Status ===> " + data.getStatusCode());
		try{
		if(data.getStatusCode()== 200){
			
		//	System.out.println(data.asString());
			Gson gson = new Gson();	
			
			int j = 0;			
			do{
				Thread.sleep(40000);
				data = service.jobIDStatus(jobID);				
				GetJobIdStatusResponse getJobIdStatusResponse = gson.fromJson(data.asString(),GetJobIdStatusResponse.class);			
				
				status = getJobIdStatusResponse.getStatus();			
				ziplocation = getJobIdStatusResponse.getLocationOfZipFileForConnectorPipelineLocation();
				
				if(status.equalsIgnoreCase("Completed")){
					j = 3;
					System.out.println(j);
				}else if(status.equalsIgnoreCase("Failure")){
					j = 3;
					System.out.println(j);
				}
				System.out.println("Status ===> "+ status);	
				
			}while(j!=3);		
			
			System.out.println("Status ===> "+ status);
			System.out.println("Zip ===> "+ ziplocation);
			System.out.println("Response Body ===> "+ data.body().asString() );					
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}		
		Assert.assertEquals(status,"Completed");	
		Assert.assertNotEquals(ziplocation,null);
		System.out.println("==========================================");
		
	}

	/*
	 *Scenario_2 : Verify that the backup should be take on flag 
	 *isAnonymize = false
	 *skipActivityData = false
	 */
	@Test
	public void Scenario_2(){
		System.out.println("=============== Scenario 2 ===============");
		System.out.println("Backup = isAnonymize = False & skipActivityData = False");
		System.out.println("=============== Scenario 2 ===============");
		String status = "",ziplocation = "";
		Service service = new Service();			
		Response data = service.initBackupJob(clientID,zone,region,false,false);
		System.out.println( "Status Code ===> " + data.getStatusCode());
		
		if(data.getStatusCode()== 201){
		//	System.out.println(data.asString());
			Gson gson = new Gson();
			InitBackUpJobResponse initBackUpJobResponse = gson.fromJson(data.asString(),InitBackUpJobResponse.class);
		//	System.out.println(initBackUpJobResponse.getId());
			Assert.assertNotEquals(initBackUpJobResponse.getId(), null);
			jobID = initBackUpJobResponse.getId();
			System.out.println("JOBID = " + jobID);
		}else{
			Assert.fail("The Backup Job ID is not created !!");
		}			
		data = service.jobIDStatus(jobID);
		System.out.println( "JOB Status ===> " + data.getStatusCode());
		try{
		if(data.getStatusCode()== 200){
			
		//	System.out.println(data.asString());
			Gson gson = new Gson();	
			int j = 0;			
			do{
				Thread.sleep(40000);
				data = service.jobIDStatus(jobID);				
				GetJobIdStatusResponse getJobIdStatusResponse = gson.fromJson(data.asString(),GetJobIdStatusResponse.class);			
				
				status = getJobIdStatusResponse.getStatus();			
				ziplocation = getJobIdStatusResponse.getLocationOfZipFileForConnectorPipelineLocation();
				
				if(status.equalsIgnoreCase("Completed")){
					j = 3;
					System.out.println(j);
				}else if(status.equalsIgnoreCase("Failure")){
					j = 3;
					System.out.println(j);
				}
				System.out.println("Status ===> "+ status);	
				
			}while(j!=3);		
			
			System.out.println("Status ===> "+ status);
			System.out.println("Zip ===> "+ ziplocation);
			System.out.println("Response Body ===> "+ data.body().asString() );
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}		
		Assert.assertEquals(status,"Completed");	
		Assert.assertNotEquals(ziplocation,null);
		System.out.println("==========================================");
		
	}

	
	
	
	/* *Scenario_3: Verify that the backup should be take on flag 
	 *isAnonymize = true
	 *skipActivityData = false*/
	 
	@Test
	public void Scenario_3(){
		System.out.println("=============== Scenario 3 ===============");
		System.out.println("Backup = isAnonymize = True & skipActivityData = False");
		System.out.println("=============== Scenario 3 ===============");
		String status = "",ziplocation = "";
		Service service = new Service();			
		Response data = service.initBackupJob(clientID,zone,region,true,false);
		System.out.println( "Status Code ===> " + data.getStatusCode());
		
		if(data.getStatusCode()== 201){
		//	System.out.println(data.asString());
			Gson gson = new Gson();
			InitBackUpJobResponse initBackUpJobResponse = gson.fromJson(data.asString(),InitBackUpJobResponse.class);
		//	System.out.println(initBackUpJobResponse.getId());
			Assert.assertNotEquals(initBackUpJobResponse.getId(), null);
			jobID = initBackUpJobResponse.getId();
			System.out.println("JOBID = " + jobID);
		}else{
			Assert.fail("The Backup Job ID is not created !!");
		}			
		data = service.jobIDStatus(jobID);
		System.out.println( "JOB Status ===> " + data.getStatusCode());
		try{
		if(data.getStatusCode()== 200){
			
		//	System.out.println(data.asString());
			Gson gson = new Gson();	
			int j = 0;			
			do{
				Thread.sleep(40000);
				data = service.jobIDStatus(jobID);				
				GetJobIdStatusResponse getJobIdStatusResponse = gson.fromJson(data.asString(),GetJobIdStatusResponse.class);			
				
				status = getJobIdStatusResponse.getStatus();			
				ziplocation = getJobIdStatusResponse.getLocationOfZipFileForConnectorPipelineLocation();
				
				if(status.equalsIgnoreCase("Completed")){
					j = 3;
					System.out.println(j);
				}else if(status.equalsIgnoreCase("Failure")){
					j = 3;
					System.out.println(j);
				}
				System.out.println("Status ===> "+ status);	
				
			}while(j!=3);		
			
			System.out.println("Status ===> "+ status);
			System.out.println("Zip ===> "+ ziplocation);
			System.out.println("Response Body ===> "+ data.body().asString() );					
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}		
		Assert.assertEquals(status,"Completed");	
		Assert.assertNotEquals(ziplocation,null);
		System.out.println("==========================================");
		
	}

	
	
	
	/* *Scenario_3: Verify that the backup should be take on flag 
	 *isAnonymize = true
	 *skipActivityData = false*/
	 
	@Test
	public void Scenario_4(){
		System.out.println("=============== Scenario 4 ===============");
		System.out.println("Backup = isAnonymize = True & skipActivityData = True");
		System.out.println("=============== Scenario 4 ===============");
		String status = "",ziplocation = "";
		Service service = new Service();			
		Response data = service.initBackupJob(clientID,zone,region,true,true);
		System.out.println( "Status Code ===> " + data.getStatusCode());
		
		if(data.getStatusCode()== 201){
		//	System.out.println(data.asString());
			Gson gson = new Gson();
			InitBackUpJobResponse initBackUpJobResponse = gson.fromJson(data.asString(),InitBackUpJobResponse.class);
		//	System.out.println(initBackUpJobResponse.getId());
			Assert.assertNotEquals(initBackUpJobResponse.getId(), null);
			jobID = initBackUpJobResponse.getId();
			System.out.println("JOBID = " + jobID);
		}else{
			Assert.fail("The Backup Job ID is not created !!");
		}			
		data = service.jobIDStatus(jobID);
		System.out.println( "JOB Status ===> " + data.getStatusCode());
		try{
		if(data.getStatusCode()== 200){
			
		//	System.out.println(data.asString());
			Gson gson = new Gson();	
			int j = 0;			
			do{
				Thread.sleep(40000);
				data = service.jobIDStatus(jobID);				
				GetJobIdStatusResponse getJobIdStatusResponse = gson.fromJson(data.asString(),GetJobIdStatusResponse.class);			
				
				status = getJobIdStatusResponse.getStatus();			
				ziplocation = getJobIdStatusResponse.getLocationOfZipFileForConnectorPipelineLocation();
				
				if(status.equalsIgnoreCase("Completed")){
					j = 3;
					System.out.println(j);
				}else if(status.equalsIgnoreCase("Failure")){
					j = 3;
					System.out.println(j);
				}
				System.out.println("Status ===> "+ status);	
				
			}while(j!=3);		
			
			System.out.println("Status ===> "+ status);
			System.out.println("Zip ===> "+ ziplocation);
			System.out.println("Response Body ===> "+ data.body().asString() );					
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}		
		Assert.assertEquals(status,"Completed");	
		Assert.assertNotEquals(ziplocation,null);
		System.out.println("==========================================");
		
	}



}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

