package com.jbossnotebook.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://www.jbossnotebook.com/",
		serviceName = "MathService")
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class MathWebService {
	
	@WebMethod
	@WebResult(name="result")
	public double addDouble(@WebParam(name="first") double first, 
			@WebParam(name="second") double second) {
		return first + second;
	}
}
