
public class MemberVO {
	private String name;
	private String depart;
	private String hire;
	private int sal;
	
	public MemberVO() {
	}
	public MemberVO(String name, String depart, String hire, int sal) {
		this.name = name;
		this.depart = depart;
		this.hire = hire;
		this.sal = sal;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getDepart(){
		return depart;
	}
	public void setHire(String hire) {
		this.hire = hire;
	}
	public String getHire(){
		return hire;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getSal(){
		return sal;
	}
	public void memberPrint() {
		System.out.println("이름="+name);
		System.out.println("부서명="+depart);
		System.out.println("이름="+name);
		System.out.println("이름="+name);
	}
	//상위 클래스인 Object의 toString()메소드를 오버라이딩
	public String toString() {
		String memberData = name+","+depart+", "+hire+", "+sal;
		return memberData;
	}
}
