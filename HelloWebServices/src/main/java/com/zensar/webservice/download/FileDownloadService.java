package com.zensar.webservice.download;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class FileDownloadService {
	private static final String textFile="D:\\aditee.txt";
	private static final String imageFile="D:\\Aditee\\Adv_Java\\Image\\profilePhoto.jpg";
	private static final String pdfFile="D:\\java_tutorial.pdf";
	@GET
	@Path("/file")
	@Produces("text/plain")
	public Response getTextFile() {
		File f = new File(textFile);
		ResponseBuilder r= Response.ok(f);
		r.header("Content-Disposition", "attachment;filename=new.txt");
		return r.build();
	}
	@GET
	@Path("/image")
	@Produces("image/jgp")
	public Response getImageFile() {
		File f = new File(imageFile);
		ResponseBuilder r= Response.ok(f);
		r.header("Content-Disposition", "attachment;filename=new.jpg");
		return r.build();
	}
	@GET
	@Path("/pdf")
	@Produces("application/pdf")
	public Response getPdfFile() {
		File f = new File(pdfFile);
		ResponseBuilder r= Response.ok(f);
		r.header("Content-Disposition", "attachment;filename=new.pdf");
		return r.build();
	}
	
}
