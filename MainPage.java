
public class MainPage {

	public MainPage() {
		
	}
	public static void firstPage() {
		System.out.println("\n");
		System.out.println("    =======================================================================================    ");
		System.out.println("    =======================================================================================    ");
		System.out.println("    =======================┌───────┐==============┌─┐====┌──────┐=┌─┐======================    ");
		System.out.println("    =======================│ ┌─────┘======┌─┐=====│ │====└────┐ │=│ │======================   ");
		System.out.println("    =======================│ └─────┐======│ │===┌─┘ │=========│ │=│ │======================    ");
		System.out.println("    =======================└───────┘======│ └──┐└─┐ │======┌─┐└─┘=│ └┐=====================   ");
		System.out.println("    ==========================┌─┐=========│ ┌──┘==│ │====┌─┘ └────┘ ┌┘=====================   ");
		System.out.println("    =====================┌────┘ └────┐====└─┘=====│ │====└────────┐ │======================    ");
		System.out.println("    =====================└───────────┘============└─┘=======┌─┐===└─┘======================    ");
		System.out.println("    ========================================================│ └───────┐====================    ");
		System.out.println("    ========================================================└─────────┘====================    ");
		System.out.println("    =======================================================================================    ");
		System.out.println("\n");                                                                                              
		System.out.println("                              도서관을 이용하시길 원한다면 아이디를 입력하세요                                  ");
		System.out.print("                                   아이디(이메일) >> ");
		
	}
	
	public static void headPage(String userId) {
		System.out.println();
		System.out.println("    ---------------------------------------------------------------------------------------    ");
		System.out.println("    "+userId+"                         도 서 관                   로그아웃(0) 종료(exit)    ");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
	}
	public static void menuPage() {
		System.out.println("\n");
		System.out.println("            1. 자료검색            2. 대  출             3. 이용안내           4. 마이페이지          ");
		System.out.println("         ┏━━━━━━━━━━━━━┓      ┏━━━━━━━━━━━━━┓      ┏━━━━━━━━━━━━━┓      ┏━━━━━━━━━━━━━┓       ");
		System.out.println("            통합자료검색            대출도서조회            이 용 시 간            본인정보확인                ");
		System.out.println("         ┣━━━━━━━━━━━━━┫      ┣━━━━━━━━━━━━━┫      ┣━━━━━━━━━━━━━┫      ┣━━━━━━━━━━━━━┫              ");
		System.out.println("            추 천 도 서            나의대출이력            휴  관  일                              ");
		System.out.println("         ┣━━━━━━━━━━━━━┫      ┣━━━━━━━━━━━━━┫      ┣━━━━━━━━━━━━━┫      ┣━━━━━━━━━━━━━┫              ");
		System.out.println("                                                      오시는 길                                ");
		System.out.println("         ┗━━━━━━━━━━━━━┛      ┗━━━━━━━━━━━━━┛      ┗━━━━━━━━━━━━━┛      ┗━━━━━━━━━━━━━┛       ");
		System.out.println("\n\n");                                                                                           
	}
	
	public static void infoUse() {
		System.out.println("                                            이 용 안 내                                          ");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
		System.out.println("     ■ 이용시간    ");
		System.out.println("    ┌─────────┬────────────────────────────────┐");
		System.out.println("    │  구  분             이 용 시 간                 ");
		System.out.println("    ├─────────┼────────────────────────────────┤");
		System.out.println("    │           [종합자료실]                               ");
		System.out.println("    │    평       - 09:00~22:00                          ");
		System.out.println("    │    일      [아동자료실,전자정보실]                      ");
		System.out.println("    │            - 09:00~18:00                           ");
		System.out.println("    ├─────────┼────────────────────────────────┤");
		System.out.println("    │           [종합자료실]                               ");
		System.out.println("    │  토요일      - 09:00~17:00                          ");
		System.out.println("    │  /일요일    [아동자료실,전자정보실]                      ");
		System.out.println("    │            - 09:00~17:00                           ");
		System.out.println("    └─────────┴────────────────────────────────┘");
		System.out.println();                                                                                           
	}
	public static void infoHolyday() {
		System.out.println("                                            이 용 안 내                                          ");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
		System.out.println("     ■ 휴관일    ");
		System.out.println("    ┌─────────┬────────────────────────────────────────────────┐");
		System.out.println("    │  구  분                      휴  관  일                         ");
		System.out.println("    ├─────────┼────────────────────────────────────────────────┤");
		System.out.println("    │            매주 월요일 및 법정공휴일(일요일 제외)                  ");
		System.out.println("    │            *단, 일요일이 다른 법정공휴일과 겹치는 경우에는 휴관함     ");
		System.out.println("    │  자료실     *법정공휴일이란                                    ");
		System.out.println("    │  /열람실     - 일요일, 국경일(3·1절, 광복절, 개천절, 한글날)        ");
		System.out.println("    │             1월1일, 설날연휴, 추석연휴, 석가탄신일, 어린이날       ");
		System.out.println("    │             현충일, 성탄절, 선거일 외 정부에서 임시공휴일로 정한 날  ");
		System.out.println("    └─────────┴────────────────────────────────────────────────┘");
		System.out.println();                                                                                           
	}
	public static void infoWay() {
		System.out.println("                                            이 용 안 내                                          ");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
		System.out.println("     ■ 오시는길    ");
		System.out.println("    ┌──────────┬─────────────┬─────────────┐");
		System.out.println("    │  버스노선      승차정류장       하차정류장   ");
		System.out.println("    ├──────────┼─────────────┴─────────────┤");
		System.out.println("    │    33         합정역          신촌역     ");
		System.out.println("    │    66        홍대입구역        신촌역     ");
		System.out.println("    │    70         당산역          신촌역     ");
		System.out.println("    └──────────┴─────────────┴─────────────┘");
		System.out.println("     ■ 주차안내    ");
		System.out.println("      - 40대의 주차공간이 마련되어 있습니다.    ");
		System.out.println("      - 주차공간이 부족하오니 대중교통을 이용해 주십시오 ");
		System.out.println("      - 차량 10부제가 운영되고 있습니다. ");
		System.out.println("     ■ 도서관 주소 및 연락처    ");
		System.out.println("      - 서울특별시 마포구 백범로 23 Tel : 02-1234-4321");
		System.out.println();                                                                                           
	}
	
}