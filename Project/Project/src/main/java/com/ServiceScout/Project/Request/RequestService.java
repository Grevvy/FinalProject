package com.ServiceScout.Project.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Optional<Request> getRequestById(Long id) {
        return requestRepository.findById(id);
    }

    public List<Request> getRequestsByCustomerId(Long customerId) {
        return requestRepository.findByCustomerUserId(customerId);
    }

    public List<Request> getRequestsByContractorId(Long contractorId) {
        return requestRepository.findByContractorUserId(contractorId);
    }

    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    public Request updateRequest(Long id, Request updatedRequest) {
        return requestRepository.findById(id)
                .map(existingRequest -> {
                    existingRequest.setCustomer(updatedRequest.getCustomer());
                    existingRequest.setContractor(updatedRequest.getContractor());
                    existingRequest.setDescription(updatedRequest.getDescription());
                    existingRequest.setStatus(updatedRequest.getStatus());
                    return requestRepository.save(existingRequest);
                })
                .orElseThrow(() -> new RuntimeException("Request not found with id " + id));
    }

    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
}
