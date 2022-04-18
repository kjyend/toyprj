package toy.toyprj.domain.member;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberRepository {

    private static Map<Long, Member> store=new ConcurrentHashMap<>();
    private static long sequence=0L;


    public Member save(Member member){ //회원가입
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    public Optional<Member> findByLoginId(String loginId){ //세션에 로그인 체크
        return findAll().stream().filter(m->m.getLoginId().equals(loginId)).findFirst();
    }

    private List<Member> findAll() {//회원 검색
        return new ArrayList<>(store.values());
    }
}
