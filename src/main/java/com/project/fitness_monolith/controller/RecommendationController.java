package com.project.fitness_monolith.controller;


import com.project.fitness_monolith.dto.RecommendationRequest;
import com.project.fitness_monolith.model.Recommendation;
import com.project.fitness_monolith.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
   public ResponseEntity<Recommendation>  generateRecommendtion(@RequestBody RecommendationRequest request){
        Recommendation recommendation=recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>>  getUserRecommendtion(@PathVariable String userId){
        List<Recommendation> recommendation=recommendationService.getUserRecommendtion(userId);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendation(@PathVariable String activityId){
        List<Recommendation> recommendation=recommendationService.getActivityRecommendtion(activityId);
        return ResponseEntity.ok(recommendation);
    }
}
