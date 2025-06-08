package com.rocky.spring_boot_rest.repository;

import com.rocky.spring_boot_rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Cloud Architect", "Design and implement cloud infrastructure solutions", 6, Arrays.asList("AWS", "Azure", "Docker")),
            new JobPost(2, "Java Developer", "Must have good understanding in core java and advance java", 2, Arrays.asList("Spring Boot", "Hibernate", "JPA")),
            new JobPost(3, "FrontEnd Developer ", "Must have good understanding in front end Technologis", 2, Arrays.asList("Html", "Css", "JavaScript"))

    ));
    public List<JobPost> getAllJobs(){
        return jobs;
    }

    public void addJob(JobPost job){
        jobs.add(job);
        System.out.println(jobs);
    }

    public JobPost getJob(int postId) {
        for(JobPost job :jobs){
            if(job.getPostId()== postId){
                return job;
            }
        }
        return null;
    }

//    public JobPost getJob(int postId) {
//        return jobs.stream()
//                .filter(job -> job.getPostId() == postId)
//                .findFirst()
//                .orElse(null); // Safely handles empty result
//    }


    public void updateJob(JobPost jobPost) {
        for(JobPost jobPost1:jobs){
            if(jobPost1.getPostId()==jobPost.getPostId()){
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setReqExperience(jobPost.getReqExperience());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJob(int postId) {
        for(JobPost jobPost : jobs){
            if(jobPost.getPostId()==postId)
                jobs.remove(jobPost);
        }
    }
}
