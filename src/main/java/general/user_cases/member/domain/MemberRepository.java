package general.user_cases.member.domain;

import general.kernel.Repository;

import java.util.List;


public interface MemberRepository extends Repository<MemberId,Member> {
   // void save(Member member);

    //Member byId(MemberId userId);

    //MemberId nextId();

    //List<Member> findAll();
    List<Member> findAll();
}
