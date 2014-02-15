package com.swordy.demo.java.lang;

/**
 * 使用goto可以在简化多层循环的跳转。
 * 
 * @author swordy
 *
 */
public class Goto1 {
	public static void main(String[] args) {
		System.out.println("# start loop");

		outter:
		// can not has statements here.
		for (int i = 0; i != 5; i++) {

			System.out.println("~ outter loop A : " + i);
			if (i == 2) {
				break outter;
			}
			System.out.println("~ outter loop B : " + i);

			inner: for (int j = 0; j != 3; j++) {
				System.out.println("@ inner loop A : " + j);
				if (j == 0) {
					continue inner;
				}
				System.out.println("@ inner loop B : " + j);
				if(j == 1)
				{
					break inner;
				}
				System.out.println("@ inner loop C : " + j);
				if(j == 2)
				{
					/*
					 * 这里可直接break到最外层，不用一层一层往出break；
					 */
					break outter;
				}
				System.out.println("@ inner loop D : " + j);
			}

		}
		
		System.out.println("# end loop");
	}
}
