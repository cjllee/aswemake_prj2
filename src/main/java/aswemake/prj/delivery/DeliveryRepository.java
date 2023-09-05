package aswemake.prj.delivery;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeliveryRepository {

    private final EntityManager em;

    public void save(Delivery delivery) {
        em.persist(delivery);
    }

    public Delivery findOne(Long id) {
        return em.find(Delivery.class, id);
    }
}