package baseClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Configuration.ConfigurationBuilder;
import com.jayway.jsonpath.Predicate.PredicateContext;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

import io.restassured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class BaseClass {
	RequestSpecification reqSpec;
	Response response;
	public void initialisation() {
		reqSpec = RestAssured.given().contentType(ContentType.JSON);
	}
	public void addSingleheader(String key,String value) {
		reqSpec=reqSpec.header(key,value);
	}
	public void addHeaders(String key1,String value1,String key2,String value2) {
	Header header1=new Header(key1,value1);
	Header header2=new Header(key2,value2);
	List< Header> li=new LinkedList<>();
	li.add(header1);
	li.add(header2);
	Headers headers=new Headers(li);
	reqSpec=reqSpec.and().headers(headers);
	}
	public void addHeader(Header header) {
		reqSpec.header(header);
	}
	public void addHeaders(Headers headers) {
		reqSpec=RestAssured.given().headers(headers);
	}
	public void addBodyas(Object obj) {
		reqSpec=reqSpec.body(obj);
	}
	public void addBody(String body) {
		reqSpec.body(body);
	}
	public void addBaseUri(String uri) {
		reqSpec=reqSpec.baseUri(uri);
	}
	public void addBasePath(String uri) {
		reqSpec=reqSpec.basePath(uri);
	}
	public Response reqType(String type,String endpoint) {
		switch (type) {
		case "GET":
			response = reqSpec.get(endpoint);
			break;
		case "POST":
			response=reqSpec.post(endpoint);
			break;
		case "PUT":
			response=reqSpec.put(endpoint);
			break;
		case "DELETE":
			response=reqSpec.delete(endpoint);
			break;
		}
		return response;		
	}
	public Response reqTypeWithoutEndpoint(String type){
		switch (type) {
		case "GET":
			response = reqSpec.get();
			break;
		case "POST":
			response=reqSpec.post();
			break;
		case "PUT":
			response=reqSpec.put();
			break;
		case "DELETE":
			response=reqSpec.delete();
			break;
		}
		return response;		
	}
	public ResponseBody getBody(Response response) {
		ResponseBody body = response.getBody();
		return body;
	}
	public String getBodyasPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}
	public List<String> jsonPath(String responseBody,String path) {
		List<String> firstNames = JsonPath.read(responseBody, path);
		return firstNames;
	}
	public Object jsonPathusingBody(Response response,String path) {
		Object object = response.body().jsonPath().get(path);
		return object;
	}
	public Object jsonPathConfiguration(Response response,String path) {
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.ALWAYS_RETURN_LIST);
		Object read = JsonPath.using(config).parse(response).read(path);
		return read;
	}
	public List<Object> jsonPathParse(Response response,String path) {
		List<Object> obj=JsonPath.parse(response.asString()).read(path);
		return obj;
	}
}
