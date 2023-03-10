package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // 생성자 주입 퉁쳐준다
public class MemberService {
    private final MemberRepository memberRepository;



    // 회원가입
    @Transactional
    public Long join(Member member){

        //validateDuplicateMember(member);

        if(memberRepository.findbyName(member.getName()).size()>0){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        return memberRepository.save(member);
    }


    // 회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    // 특정 회원 조회
    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findbyName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
