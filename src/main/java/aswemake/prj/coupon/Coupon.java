package aswemake.prj.coupon;

import aswemake.prj.item.Item;
import jakarta.persistence.*;
import aswemake.prj.order.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    @Id
    @GeneratedValue
    private Long id;

    private Double discountRate;

    private Integer discountAmount;



    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    @Enumerated(EnumType.STRING)
    private CouponScope couponScope;

    @ManyToMany(mappedBy = "coupons")
    private List<Item> items = new ArrayList<>();
}