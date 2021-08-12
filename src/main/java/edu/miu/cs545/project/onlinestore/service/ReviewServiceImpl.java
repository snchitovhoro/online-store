package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Review;
import edu.miu.cs545.project.onlinestore.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements IReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void createReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public List<Review> getReviewsNotApproved() {
        return reviewRepository.findReviewsByApprovedIsFalse();
    }

    @Override
    public Boolean approveReview(Long reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (review.isPresent()) {
            review.get().setApproved(true);
            reviewRepository.save(review.get());
            return true;
        }
        return false;
    }

}
