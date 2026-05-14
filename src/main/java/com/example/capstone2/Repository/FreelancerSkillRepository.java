package com.example.capstone2.Repository;

import com.example.capstone2.Model.FreelancerSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreelancerSkillRepository extends JpaRepository<FreelancerSkill,Integer> {
}
