package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

public class PerformanceReviewRepository extends RepositoryBase<PerformanceReview> implements IRepository<PerformanceReview> {
    public PerformanceReviewRepository() {
        super(PerformanceReview.class);
    }
}
