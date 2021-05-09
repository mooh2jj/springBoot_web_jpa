package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
// 값 객체는 setter x
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
