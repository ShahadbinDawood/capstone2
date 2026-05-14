package com.example.capstone2.Service;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.FreelancerProfile;
import com.example.capstone2.Repository.FreelancerProfileRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreelancerProfileService {
    private  final FreelancerProfileRepository freelancerProfileRepository;
    private final UserRepository userRepository;

    public List<FreelancerProfile> getAllFreelancerProfile() {
        return freelancerProfileRepository.findAll();
    }
    public void addFreelancerProfile(FreelancerProfile freelancerProfile){
        if(freelancerProfile==null){
            throw new ApiException("freelancer Profile  not found");
        }
        if (userRepository.findUserById(freelancerProfile.getUserId()) == null) {
            throw new ApiException("User not found");
        }
        freelancerProfileRepository.save(freelancerProfile);

    }
    public void updateFreelancerProfile(Integer id,FreelancerProfile freelancerProfile){
        FreelancerProfile oldFreelancerProfile = freelancerProfileRepository.findFreelancerProfileById(id);
        if(oldFreelancerProfile==null){
            throw new ApiException("freelancer Profile  not found");
        }
        if (userRepository.findUserById(freelancerProfile.getUserId()) == null) {
            throw new ApiException("User not found");
        }
        oldFreelancerProfile.setUserId(freelancerProfile.getUserId());
        oldFreelancerProfile.setPortfolio(freelancerProfile.getPortfolio());
        oldFreelancerProfile.setHourlyRate(freelancerProfile.getHourlyRate());
        oldFreelancerProfile.setExperienceYears(freelancerProfile.getExperienceYears());
        freelancerProfileRepository.save(oldFreelancerProfile);

    }

    public void deleteFreelancerProfile(Integer id){
        FreelancerProfile freelancerProfile = freelancerProfileRepository.findFreelancerProfileById(id);
        if(freelancerProfile ==null){
            throw new ApiException("freelancer Profile  not found");
        }
        freelancerProfileRepository.delete(freelancerProfile);
    }
}
