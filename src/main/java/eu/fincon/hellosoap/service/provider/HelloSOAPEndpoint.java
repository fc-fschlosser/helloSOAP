package eu.fincon.hellosoap.service.provider;

import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetHelloSOAPRequest;
import io.spring.guides.gs_producing_web_service.GetHelloSOAPResponse;
import io.spring.guides.gs_producing_web_service.HelloSOAPPort;

@Endpoint()
public class HelloSOAPEndpoint implements HelloSOAPPort {
	
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHelloSOAPRequest")
	@ResponsePayload
	@Override
	public GetHelloSOAPResponse getHelloSOAP(@RequestPayload GetHelloSOAPRequest getHelloSOAPRequest) {
		GetHelloSOAPResponse response = new GetHelloSOAPResponse();
		response.setAnswer(getGreeting());
		return response;
	}
	
	
	final String uri = "http://localhost:8080/dropwizard_test";

	public String getGreeting() {
		RestTemplate rest = new RestTemplate();
		String result = rest.getForObject(uri, String.class);
		return result;
}


}
