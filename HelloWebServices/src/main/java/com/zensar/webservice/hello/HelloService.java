package com.zensar.webservice.hello;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainHello() {
		return "Welcome to Zensar Hello Service";
		
	}
	@Path("/html")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html>"+"<body>"+"<h1>"+"Welcome To Zensar"+"</h1>"+"</body>"+"</html>";
	}
	@Path("/xml")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXmlHello() {
		return "<?xml version='1.0'?><hello>Welcome to Zensar XML</hello>";
	}
	@GET
	@Path("/{nm}")
	@Produces("text/html")
	public String sayHelloUser(@PathParam("nm")String name) {
		return "<h1>Dear "+ name +" Welcome to zensar hello service</h1>";
	}
	@GET
	@Path("res/{nm}")
	@Produces("text/html")
	public Response sayHelloUserResponse(@PathParam("nm")String name) {
		Response res = Response.status(200).entity("<h1>Dear"+ name +" Welcome to zensar hello service</h1>").build();
		return res;
	}
	@GET
	@Path("res/{nm}/{dd}/{mm}/{yy}")
	@Produces("text/html")
	public Response sayHappyBirthDay(@PathParam("nm")String name,@PathParam("dd")int day,@PathParam("mm")int month,@PathParam("yy")int year) {
		LocalDate birthdate = LocalDate.of(year, month, day);
		Response res = Response.status(200).entity("<h1>Dear"+ name +" HappyBirthDay on <br>"+birthdate+ "</h1>").build();
		return res;
	}
}
