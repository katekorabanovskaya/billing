package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    Iterable<Order> getOrdersByBillingAccountId(Long id);

//    @Query(value = "SELECT o from Order o JOIN BillingAccount b ON o.billingAccountId = b.baId JOIN User u ON b.accountId = u.userId where b.accountId = ?1")
//    Iterable<Order> getOrdersByUserId(Long id);

    @Query(value = "select o from Order o where o.orderStatus = 'ACTIVE'")
    Iterable<Order> getActiveOrders();


}
