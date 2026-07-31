package com.jiheon.main_api_server.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	private final String version;

	public ApiController(@Value("${app.version}") String version) {
		this.version = version;
	}

	@GetMapping("/version")
	public String version() {
		return version + ".test2";
	}

	@GetMapping("/health")
	public ResponseEntity<Void> health() {
		return ResponseEntity.ok().build();
	}

	@GetMapping("/delay")
	public String delay() throws InterruptedException {
		Thread.sleep(5000);
		return "delayed";
	}
}
