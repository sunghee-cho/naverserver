package board.spring.mybatis;

public class BoardMemberDTO {
 int seq;
 String title, contents;
 MemberDTO member;
 String pw, viewcount;
 String writingtime;
public int getSeq() {
	return seq;
}
public void setSeq(int seq) {
	this.seq = seq;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContents() {
	return contents;
}
public void setContents(String contents) {
	this.contents = contents;
}
public MemberDTO getMember() {
	return member;
}
public void setMember(MemberDTO member) {
	this.member = member;
}
public String getPw() {
	return pw;
}
public void setPw(String pw) {
	this.pw = pw;
}
public String getViewcount() {
	return viewcount;
}
public void setViewcount(String viewcount) {
	this.viewcount = viewcount;
}
public String getWritingtime() {
	return writingtime;
}
public void setWritingtime(String writingtime) {
	this.writingtime = writingtime;
}
 
}
