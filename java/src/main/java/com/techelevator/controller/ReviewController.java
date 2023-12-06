package com.techelevator.controller;

import com.techelevator.dao.ReviewDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ReviewController {

    private ReviewDao reviewDao;

}
