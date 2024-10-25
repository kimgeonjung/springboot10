package edu.du.sbproject.service;

import edu.du.sbproject.entity.Member;
import edu.du.sbproject.exception.DuplicateMemberException;
import edu.du.sbproject.repository.MemberRepository;
import edu.du.sbproject.vo.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberRegisterService {
	
	private final MemberRepository memberRepository;

	public void regist(RegisterRequest req) {
		Optional<Member> member = memberRepository.findByEmail(req.getEmail());
		if (member.isPresent()) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = Member.builder()
				.email(req.getEmail())
				.password(passwordEncoder().encode(req.getPassword()))
				.regdate(LocalDateTime.now())
				.username(req.getName())
				.role("USER")
				.build();
		memberRepository.save(newMember);
	}

	private PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

}
