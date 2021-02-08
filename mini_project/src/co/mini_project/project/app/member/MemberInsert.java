package co.mini_project.project.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini_project.project.common.Command;
import co.mini_project.project.dao.MemberDAO;
import co.mini_project.project.vo.MemberVO;

public class MemberInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 'memberInsert.do'
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setmName(request.getParameter("mName"));
		vo.setmId(request.getParameter("mId"));
		vo.setmPassword(request.getParameter("mPassword"));
		vo.setmEmail(request.getParameter("mEmail"));
		vo.setmTel(request.getParameter("mTel"));
		vo.setmAddress(request.getParameter("mAddress"));
		vo.setDetailAdr(request.getParameter("detailAdr"));
		vo.setPostCode(request.getParameter("postCode"));
		vo.setmBirth(request.getParameter("mBirth"));

		int n = dao.memberInsert(vo);
		
		String viewPage = "main.do";
		
		if(n == 0) {
			viewPage = "member/insertFail";
		}

		return viewPage;
	}

}
