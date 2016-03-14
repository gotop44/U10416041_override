/** U10416041 */

import java.lang.*;
import static java.lang.System.out;

class override {
	public static void main(String[] para) {
		out.println("========= A 類別之 obj1 物件 =========");
		A obj1 = new A();
		obj1.fun1();
		obj1.showAA();
		obj1.showAA(1111);
		out.println("obj1.aa = " + obj1.aa);

		out.println("========= B1 類別之 obj2 物件 =========");
		B1 obj2 = new B1();
		obj2.fun1();
		obj2.showAA();
		obj2.showAA(3333);
		out.println("obj2.aa = " + obj2.aa);

		out.println("========= B2 類別之 obj3 物件 =========");
		B2 obj3 = new B2();
		obj3.fun1();
		obj3.showAA();
		obj3.showAA(6666);
		out.println("obj3.aa = " + obj3.aa);
		
		//==============父類別物件參考子類別實體=================
		//=======可參考「多型」，以及「滿足」與物件的轉型========

		out.println("== A 類別物件 obj4 參考 B1 之物件實體 ==");
		A obj4 = new B1();
		obj4.fun1();
		obj4.showAA();
		obj4.showAA(7777);
		out.println("obj4.aa = " + obj4.aa);

		out.println("== A 類別物件 obj5 參考 B2 之物件實體 ==");
		A obj5 = new B2();
		obj5.fun1();	//會間接存取到 B2 的 bb 變數
		obj5.showAA();
		obj5.showAA(8888);
		out.println("obj5.aa = " + obj5.aa);
		//System.out.println("obj5.bb = " + obj5.bb);
			//錯誤，A 類別的 obj5 沒有 bb 成員變數
		//obj5.fun("if overload ==>");
			//錯誤，A 類別沒有 fun2(String) 這種參數型態的方法
	}
}

class A {
	public int aa = 1000;

	public void fun1() {
		out.println("A 類別的 fun1() 方法");
	}

	public void fun2() {
		out.println("A 類別的 fun2() 方法");
	}

	public void showAA() {				//存取 A 類別內定義的 aa
		out.println("call A class showAA() : aa = " + aa);
	}

	public void showAA(int aaValue) {
		aa = aaValue;	//存取 A 類別內定義的 aa
		out.println("call A class showAA(int) : aa = " + aa);
	}
}

class B1 extends A {
	public String aa = "001-aa"; //隱藏繼承來的 aa,同名,型態不同
	
	public void showAA() {			   //存取 B1 類別內定義的 aa
		out.println("call B1 class showAA() : aa = " + aa);
	}

	public void fun1() {
		//回傳型態一定要相同才能 override，否則會有編譯錯誤
		out.println("B1 類別的 fun1() 方法");
	}
}

class B2 extends A {
	public String aa = "002-aa";
	public int bb = 300;
	
	public final void fun1() {
		//修飾字不同一樣也是 override
		out.println("B2 類別的 fun1() 方法");
		bb = bb + 10;
		out.println("bb = " + bb);
	}

	public void fun2(String str) {
		//不算 fun2() 的 overload，也不是 override
		out.println(str + "B1 類別的 fun2() 方法");
	}
}
