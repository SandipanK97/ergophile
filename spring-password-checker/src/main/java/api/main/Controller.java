package api.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/* Url : http://localhost:8080/swagger-ui/index.html */
@RestController
@RequestMapping("/api")
public class Controller {
	
@Autowired
private IPasswordService passwordService;

@GetMapping("/test")
public ResponseEntity<String> testEndpoint() {
    // This is a simple GET endpoint for testing
    String response = "This is a test response for the GET endpoint.";

    // Return a response with HttpStatus.OK
    return new ResponseEntity<>(response, HttpStatus.OK);
}

@PostMapping("/isStrongPassword")
public ResponseEntity<String> handlePostRequest(@RequestBody String requestBody) {
    Boolean response = passwordService.isStrongPassword(requestBody);
    return new ResponseEntity<>(response.toString(), HttpStatus.OK);
}
}
