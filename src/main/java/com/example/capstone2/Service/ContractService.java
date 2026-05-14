package com.example.capstone2.Service;


import com.example.capstone2.Model.Contract;
import com.example.capstone2.Repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
    public List<Contract>  getAllContract (){
        return contractRepository.findAll();
    }
}
