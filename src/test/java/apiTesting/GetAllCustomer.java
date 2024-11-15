package apiTesting;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonAlias;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Address;
import pojo.Education;
import pojo.Payload;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class GetAllCustomer {

	@Test
	public void getAllCustomer() {
		Response resposne = given().header("Authorization",
				"Bearer sk_test_51QLQpYG2CXGirlGTWWqBJqMQiinKgjO1aeqog9aq5rmqHEoj6nvoZt42A0DiryiTlM1YcMxZ31kQGareoE2Bkhsd00wHvtJzyf")
				.contentType(ContentType.JSON).get("https://api.stripe.com/v1/customers");
		resposne.prettyPrint();

	}
//	@Test
//	public void basicAuth() {
//		Response response=given().auth().basic("", "sk_test_51QLQpYG2CXGirlGTWWqBJqMQiinKgjO1aeqog9aq5rmqHEoj6nvoZt42A0DiryiTlM1YcMxZ31kQGareoE2Bkhsd00wHvtJzyf")
//				.contentType(ContentType.JSON).get("https://api.stripe.com/v1/customers");
//		System.out.println("***");
//		response.prettyPrint();
//	}

	@Test
	public void createCustomer() {
		Response response = given().headers("Authorization",
				"Bearer sk_test_51QLQpYG2CXGirlGTWWqBJqMQiinKgjO1aeqog9aq5rmqHEoj6nvoZt42A0DiryiTlM1YcMxZ31kQGareoE2Bkhsd00wHvtJzyf")
				.contentType(ContentType.JSON).formParam("email", "pradippatil1543@gmail.com")
				.formParam("name", "pradip").headers("Content-type", "application/x-www-form-urlencoded")
				.post("https://api.stripe.com/v1/customers");
		response.prettyPrint();
	}
	
	//for below api run java file in rest assured folder

	@Test
	public void createUser() {

		// if we have paload which need multiple data in that case we can use HashMp
		HashMap<String, String> payload = new HashMap<String, String>();
		payload.put("email", "pradip@gmail.com");
		payload.put("firstName", "pradip");
		payload.put("lastName", "patil");
		// here we need to add 'jackson databind' dependecy which convert data into
		// jason data
		Response response = given().contentType(ContentType.JSON).body(payload).post("http://localhost:8080/api/users");
		System.out.println(response.getStatusCode());
	}

	@Test
	public void payloadWithJsonFile() {

		// we have created json file and send path of the file
		// to log header we have added log().all() which will return in resposne object
		Response response = given().contentType(ContentType.JSON).body(new File("./src/test/java/data/payload.json"))
				.log().all().post("http://localhost:8080/api/users");
		response.prettyPrint();
		System.out.println(response.statusCode());

	}

	@Test
	public void passingComplexDataWithHashMap() {

		ArrayList<Integer> mb = new ArrayList<Integer>();
		mb.add(123);
		mb.add(456);
		
		HashMap<String, String> add = new HashMap<String, String>();
		add.put("street", "mendake galli");
		add.put("city", "Kolhapur");
		add.put("state", "Mharashtra");
		
		ArrayList<String>pk=new ArrayList<String>();
		pk.add("java");
		pk.add("javascript");
		pk.add("phyton");
		
		ArrayList<Object>ed=new ArrayList<Object>();
		HashMap<String, Object>ed1=new HashMap<String, Object>();
		ed1.put("course", "B.E");
		ed1.put("mark", 70);
		
		HashMap<String, Object>ed12=new HashMap<String, Object>();
		ed12.put("course", "M.E");
		ed12.put("mark", 60);
		
		ed.add(ed1);
		ed.add(ed12);
		
		

		HashMap<String, Object> payload = new HashMap<String, Object>();
		payload.put("email", "complex@gmail.com");
		payload.put("firstName", "complex");
		payload.put("lastName", "jason");
		payload.put("mobileNo", mb);
		payload.put("address", add);
		payload.put("primarySkill", pk);
		payload.put("education", ed);

		Response resposne = given().contentType(ContentType.JSON).body(payload).log().all().post("http://localhost:8080/api/users");
		resposne.prettyPrint();
		System.out.println(resposne.statusCode());
	}
	
	@Test
	public void byUsingJsonObject() {
		
		JSONArray jr=new JSONArray();
		jr.put(124);
		jr.put(456);
		
		JSONObject add1=new JSONObject();
		add1.put("Course", "B.E");
		add1.put("mark", 70);
		
		JSONObject add2=new JSONObject();
		add2.put("Course", "M.E");
		add2.put("mark", 50);
		
		JSONArray add=new JSONArray();
		add.put(add1);
		add.put(add2);
	
		// we need to add jsonJava dependency in pom.xml
		JSONObject json=new JSONObject();
		json.put("email", "jsonObjec@gmail.com");
		json.put("firstName", "json");
		json.put("mobileNo", jr);
		json.put("addres", add);
		
		
		//while passing jsonObject we need to conver into to string
		Response resposne = given().contentType(ContentType.JSON).body(json.toString()).log().all().post("http://localhost:8080/api/users");
		resposne.prettyPrint();
		System.out.println(resposne.statusCode());
	
	}
	
	@Test
	public void payloadUsingObject() {
		Education education=new Education("Be", 80);
		Education education2=new Education("M.E", 90);
		
		Address address1=new Address("parit galli", "kolhapur", "maharashtra");
		Address address2=new Address("sutar galli", "Kolhapur", "Maharashtrea");
		
		
		Payload payload=new Payload("object@gmail.com", "object", "java");
		payload.setMobileNumber(111,222,333);
		payload.setEducation(education,education2);
		payload.setPrimarySkill("java","javascript","phyton");
		payload.setAddress(address1,address2);
		

		Response resposne = given().contentType(ContentType.JSON).body(payload).log().all().post("http://localhost:8080/api/users");
		resposne.prettyPrint();
		System.out.println(resposne.statusCode());
		
		
	}
	
	@Test
	public void getCustomer() {
		Response resposne = given().contentType(ContentType.JSON).get("http://localhost:8080/api/users");
		resposne.prettyPrint();
		System.out.println(resposne.statusCode());
	}
}
