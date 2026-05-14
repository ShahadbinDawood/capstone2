package com.example.capstone2.Controller;


import com.example.capstone2.Api.ApiResponse;
import com.example.capstone2.Model.Proposal;
import com.example.capstone2.Service.ProposalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/proposal")
@RequiredArgsConstructor
public class ProposalController {
    private final ProposalService proposalService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllProposal() {
        return ResponseEntity.status(200).body(proposalService.getAllProposal());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProposal(@RequestBody @Valid Proposal proposal, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        proposalService.addProposal(proposal);
        return ResponseEntity.status(200).body(new ApiResponse("Review added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProposal(@PathVariable Integer id, @RequestBody @Valid Proposal proposal, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        proposalService.updateProposal(id, proposal);
        return ResponseEntity.status(200).body(new ApiResponse("Review updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProposal(@PathVariable Integer id) {
        proposalService.deleteProposal(id);
        return ResponseEntity.status(200).body(new ApiResponse("Review deleted successfully"));
    }
}
