package team260914.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import team260914.service.ReviewService;

@RestController 
@RequiredArgsConstructor         
@RequestMapping ("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;
}
