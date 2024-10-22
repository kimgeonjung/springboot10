package edu.du.sb1021_2.service;

import edu.du.sb1021_2.entity.Member;
import edu.du.sb1021_2.exception.DuplicateMemberException;
import edu.du.sb1021_2.repository.MemberDao;
import edu.du.sb1021_2.vo.RegisterRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), 
				LocalDateTime.now());
		memberDao.insert(newMember);
	}
}
