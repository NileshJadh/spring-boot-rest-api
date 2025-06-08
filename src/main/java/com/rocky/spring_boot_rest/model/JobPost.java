package com.rocky.spring_boot_rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class JobPost {

    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;

//    public JobPost(int postId, String postProfile, String postDesc, int reqExperience, List<String> postTechStack) {
//        this.postId = postId;
//        this.postProfile = postProfile;
//        this.postDesc = postDesc;
//        this.reqExperience = reqExperience;
//        this.postTechStack = postTechStack;
//    }


    public int getPostId() {
        return postId;
    }
}
