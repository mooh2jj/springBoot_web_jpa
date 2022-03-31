package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
//    @Rollback(false)
    public void 회원가입() throws Exception{
        // given
        Member member = new Member();
        member.setName("dsg");

        // when
        Long savedId = memberService.join(member);

        // then
//        em.flush();
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim2");

        Member member2 = new Member();
        member2.setName("kim2");

        // when
        memberService.join(member1);
        try {
            memberService.join(member2);    // 예외가 발생해야 한다!
        } catch (IllegalStateException e) {
            return;
        }

//        Assertions.assertThrows(IllegalStateException.class,
//                () - {});

        // then
//        fail("예외가 발생한다");
    }

}