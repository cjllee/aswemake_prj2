package aswemake.prj.orderitem;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderItemRepository {

    private final EntityManager em;

    public void save(OrderItem orderItem){
        em.persist(orderItem);
    }

    public OrderItem findOne(Long id){
        return em.find(OrderItem.class, id);
    }

}