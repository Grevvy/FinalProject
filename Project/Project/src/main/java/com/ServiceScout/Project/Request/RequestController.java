package com.ServiceScout.Project.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    // Get all requests
    @GetMapping
    public List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }

    // Get request by ID
    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable Long id) {
        return requestService.getRequestById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get requests by user ID
    @GetMapping("/customer/{customerId}")
    public List<Request> getRequestsByUserId(@PathVariable Long customerId) {
        return requestService.getRequestsByCustomerId(customerId);
    }

    // Get requests by contractor ID
    @GetMapping("/contractor/{contractorId}")
    public List<Request> getRequestsByContractorId(@PathVariable Long contractorId) {
        return requestService.getRequestsByContractorId(contractorId);
    }

    // Create a new request
    @PostMapping
    public Request createRequest(@RequestBody Request request) {
        return requestService.createRequest(request);
    }

    // Update an existing request
    @PutMapping("/{id}")
    public ResponseEntity<Request> updateRequest(@PathVariable Long id, @RequestBody Request updatedRequest) {
        try {
            return ResponseEntity.ok(requestService.updateRequest(id, updatedRequest));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<Request> updateRequestStatus(@PathVariable Long id, @RequestParam String status) {
        try {
            Request updatedRequest = requestService.updateStatus(id, status);
            return ResponseEntity.ok(updatedRequest);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a request
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}
