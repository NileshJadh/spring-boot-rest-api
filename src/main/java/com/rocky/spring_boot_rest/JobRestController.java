package com.rocky.spring_boot_rest;

import com.rocky.spring_boot_rest.model.JobPost;
import com.rocky.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId) {
        return service.getJob(postId).orElse(null);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId()).orElse(null);
    }

    @PutMapping("jobPost/{postId}")
    public JobPost updateJob(@RequestBody JobPost jobPost, @PathVariable int postId) {
        jobPost.setPostId(postId);
        service.updateJob(jobPost);
        return service.getJob(postId).orElse(null);
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId) {
        service.deleteJob(postId);
        return "deleted";
    }
}
