package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubscriptionRepository extends PagingAndSortingRepository<Subscription, Long> {

    Iterable<Subscription> getSubscriptionByCompany_CompanyId(Long ownerId);

    @Query(value = "select s.subName from Subscription s where s.subName like CONCAT('%', ?1, '%')")
    Iterable<String> getPatternNames(String pattern);

    Page<Subscription> getSubscriptionsBySubNameLikeAndCategory_CategoryName(String subName, String categoryName, Pageable pageable);

    Page<Subscription> getSubscriptionsBySubNameLike(String subName, Pageable pageable);
}
