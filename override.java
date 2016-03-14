/** U10416041 */

import java.lang.*;
import static java.lang.System.out;

class override {
	public static void main(String[] para) {
		out.println("========= A ���O�� obj1 ���� =========");
		A obj1 = new A();
		obj1.fun1();
		obj1.showAA();
		obj1.showAA(1111);
		out.println("obj1.aa = " + obj1.aa);

		out.println("========= B1 ���O�� obj2 ���� =========");
		B1 obj2 = new B1();
		obj2.fun1();
		obj2.showAA();
		obj2.showAA(3333);
		out.println("obj2.aa = " + obj2.aa);

		out.println("========= B2 ���O�� obj3 ���� =========");
		B2 obj3 = new B2();
		obj3.fun1();
		obj3.showAA();
		obj3.showAA(6666);
		out.println("obj3.aa = " + obj3.aa);
		
		//===============�����O����ѦҤl���O����==================
		//========�i�Ѧҡu�h���v�A�H�Ρu�����v�P�����૬=========

		out.println("== A ���O���� obj4 �Ѧ� B1 ��������� ==");
		A obj4 = new B1();
		obj4.fun1();
		obj4.showAA();
		obj4.showAA(7777);
		out.println("obj4.aa = " + obj4.aa);

		out.println("== A ���O���� obj5 �Ѧ� B2 ��������� ==");
		A obj5 = new B2();
		obj5.fun1();	//�|�����s���� B2 �� bb �ܼ�
		obj5.showAA();
		obj5.showAA(8888);
		out.println("obj5.aa = " + obj5.aa);
		//System.out.println("obj5.bb = " + obj5.bb);
			//���~�AA ���O�� obj5 �S�� bb �����ܼ�
		//obj5.fun("if overload ==>");
			//���~�AA ���O�S�� fun2(String) �o�ذѼƫ��A����k
	}
}

class A {
	public int aa = 1000;

	public void fun1() {
		out.println("A ���O�� fun1() ��k");
	}

	public void fun2() {
		out.println("A ���O�� fun2() ��k");
	}

	public void showAA() {				//�s�� A ���O���w�q�� aa
		out.println("call A class showAA() : aa = " + aa);
	}

	public void showAA(int aaValue) {
		aa = aaValue;	//�s�� A ���O���w�q�� aa
		out.println("call A class showAA(int) : aa = " + aa);
	}
}

class B1 extends A {
	public String aa = "001-aa"; //�����~�ӨӪ� aa,�P�W,���A���P
	
	public void showAA() {			   //�s�� B1 ���O���w�q�� aa
		out.println("call B1 class showAA() : aa = " + aa);
	}

	public void fun1() {
		//�^�ǫ��A�@�w�n�ۦP�~�� override�A�_�h�|���sĶ���~
		out.println("B1 ���O�� fun1() ��k");
	}
}

class B2 extends A {
	public String aa = "002-aa";
	public int bb = 300;
	
	public final void fun1() {
		//�׹��r���P�@�ˤ]�O override
		out.println("B2 ���O�� fun1() ��k");
		bb = bb + 10;
		out.println("bb = " + bb);
	}

	public void fun2(String str) {
		//���� fun2() �� overload�A�]���O override
		out.println(str + "B1 ���O�� fun2() ��k");
	}
}