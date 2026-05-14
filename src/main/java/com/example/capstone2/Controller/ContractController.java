package com.example.capstone2.Controller;

import com.example.capstone2.Service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contract")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;
    public ResponseEntity<?> getAllContract(){
        return ResponseEntity.status(200).body(contractService.getAllContract());
    }
}
