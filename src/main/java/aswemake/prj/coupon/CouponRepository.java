package aswemake.prj.coupon;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CouponRepository {

    private final EntityManager em;

    public void save(Coupon coupon) {
        em.persist(coupon);
    }

    public Coupon findOne(Long id) {
        return em.find(Coupon.class, id);
    }

}