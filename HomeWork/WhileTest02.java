class WhileTest02
{
	public static void main(String[] args) 
	{
		// ÁßÃ¸¹Ýº¹¹®(while)
		int r1 = 0;
		while (r1<5){
			int r2 =1;
			while (r2<=5){
				System.out.print(r2+"\t");
				r2++;
			}
			r1++;
			System.out.println();
		}
	}
}

/*
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5

*/