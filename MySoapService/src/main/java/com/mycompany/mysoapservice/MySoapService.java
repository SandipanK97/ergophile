

package com.mycompany.mysoapservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Sandipan Kundu
 */
@WebService
public class MySoapService {

    public static void main(String[] args) {
        
        Endpoint.publish("http://localhost:8080/MySoapService", new MySoapService());
        System.out.println("SOAP Service is running at http://localhost:8080/MySoapService\n WSDL http://localhost:8080/MySoapService?wsdl");
    }
    
    @WebMethod
    public OutputData processData(InputData input) {
        OutputData output = new OutputData();
        output.setMessage("Hello, " + input.getName() + "! You are " + input.getAge() + " years old.");
        return output;
    }
}
