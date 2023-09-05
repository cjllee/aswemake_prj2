package aswemake.prj.item;

import aswemake.prj.coupon.Coupon;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.List;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    @ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(
            name="item_coupon",
            joinColumns=@JoinColumn(name="item_id"),
            inverseJoinColumns=@JoinColumn(name="coupon_id")
    )
    List<Coupon> coupons=new ArrayList<>();
}