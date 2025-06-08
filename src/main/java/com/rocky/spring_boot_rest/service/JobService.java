package com.rocky.spring_boot_rest.service;

import com.rocky.spring_boot_rest.model.JobPost;
import com.rocky.spring_boot_rest.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }

    public Optional<JobPost> getJob(int postId) {
        return Optional.ofNullable(repo.getJob(postId))
                .or(() -> Optional.of(new JobPost(postId, "null", "null", 0, List.of())));
    }

    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteJob(postId);
    }
}
