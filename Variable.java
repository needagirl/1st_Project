class Variable //Ŭ������ �빮�ڷ� �����ϰ� �ռ��� �϶��� �� �ܾ��� ù��° ���ڸ� �빮�ڷ� �Ѵ�. 
				//256���ڱ��� �����ϴ�.
{
	public static void main(String[] args) 
	{
		//������ : �� �Ǵ� �����͸� �����ϴ� ����� ����
		//	���� 50��, ���� 80��, ���� 70��
		// �⺻������ �� : ������ int, byte, short, long
		//			�Ǽ��� float(4byte), double(8byte)
		//			�� boolean (1byte)
		//			���� char(2byte)
		
		//			���۷�����

		//byte kor = 50; // 1byte
		int kor2 = 50; // 4byte ������ ����� int���̴�.
		int eng = 80;
		int math = 70;
		// ���� ���� ��Ģ
		//  ù��° ���ڴ� �����ҹ��ڷ� ���� or _ or $ �� ����  // Ư������, ���ڷ� ���� ����
		//  �ռ��� �϶��� �ι�° ���� �ܾ�� �빮�ڷ� �Ѵ�.
		//  ��ɾ�(�����)�� ������ ����� �� ����.
		//		����)
		//		name, _name, $name ����
		//		9name, *name, if(�����)
		
		// ���
		//	������ : +, -, *, /, %(������)

		int sum = kor2 + eng + math; //200
		double aver = sum / 3.0; // �Ǽ��� �⺻ ������ Ÿ���� double 31.4
		// ����, �Ǽ� = ����
		// ����, �Ǽ� = �Ǽ�
		// �Ǽ�, ���� = �Ǽ�
		// �Ǽ�, �Ǽ� = �Ǽ�
		
		System.out.println("���� = " + sum);
		System.out.println("��� = " + aver);

		boolean state = true; // true, false (1byte)
		System.out.println(state);
		
		char lastName = 'ȫ';
		String firstName = "�浿";
		System.out.println(lastName + firstName);
		
		// ����ȯ
		
		float data = (float)3532.4352;
		int data2 = (int)3532.4352;
		System.out.println(data);
		System.out.println(data2);
		// ū ���������� �����͸� ���� ������������ ������ ������ ���� ����ȯ�� �ϸ� �ȴ�.
		// ���� ���������� �����͸� ū ���������� ���� ������ ���� ����ȯ ���� �ʾƵ� �ȴ�.
		double data3 = 1234567;
		System.out.println(data3);
	}
}
