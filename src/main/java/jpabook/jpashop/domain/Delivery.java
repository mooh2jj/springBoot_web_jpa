package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")   // 하나의 배송정보는 하나의 주문상태를 가진다.
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;  // READY, COMP EnumType.STRING쓰는 이유 : 그래야 순서가 밀려도 절대 어긋날리가 없어짐!
}
