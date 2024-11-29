package spring;

public class AuthService {

	private MemberDao dao;
	
	public void setMemberDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public AuthInfo authenticate(String email, String password) {
		Member member = dao.selectByEmail(email);
		if(member == null) {
			throw new WrongIdPasswordException();
		}
		if(!member.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(member.getId(),
				member.getEmail(),
				member.getName());
	}
}
