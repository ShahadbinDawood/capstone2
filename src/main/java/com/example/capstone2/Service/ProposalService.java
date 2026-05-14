package com.example.capstone2.Service;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.Proposal;
import com.example.capstone2.Repository.ProjectRepository;
import com.example.capstone2.Repository.ProposalRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProposalService {
    private final ProposalRepository proposalRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    public List<Proposal> getAllProposal(){
        return proposalRepository.findAll();
    }
    public void addProposal (Proposal proposal){
        if (proposal == null){
            throw new ApiException("proposal  not found");
        }
        if (userRepository.findUserById(proposal.getFreelancerId())==null){
            throw new ApiException("user  not found");
        }
        if (projectRepository.findProjectById(proposal.getProjectId())==null){
            throw new ApiException("project  not found");
        }
        proposalRepository.save(proposal);
    }
    public void updateProposal (Integer id ,Proposal proposal ){
        Proposal oldProposal = proposalRepository.findProposalById(id);
        if (oldProposal == null){
            throw new ApiException("proposal  not found");
        }
        if (userRepository.findUserById(proposal.getFreelancerId())==null){
            throw new ApiException("user  not found");
        }
        if (projectRepository.findProjectById(proposal.getProjectId())==null){
            throw new ApiException("project  not found");
        }
        oldProposal.setFreelancerId(proposal.getFreelancerId());
        oldProposal.setProjectId(proposal.getProjectId());
        oldProposal.setStatus(proposal.getStatus());
        oldProposal.setBidAmount(proposal.getBidAmount());
        oldProposal.setCoverLetter(proposal.getCoverLetter());
        proposalRepository.save(oldProposal);
    }

    public void deleteProposal(Integer id){
        Proposal proposal = proposalRepository.findProposalById(id);
        if (proposal == null){
            throw new ApiException("proposal  not found");
        }
        proposalRepository.delete(proposal);
    }
}
