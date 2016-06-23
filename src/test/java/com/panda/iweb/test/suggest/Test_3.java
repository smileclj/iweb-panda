package com.panda.iweb.test.suggest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Test;

//银行家四舍五入算法
//标度值是指小数位数
public class Test_3 {
	@Test
	public void setScale() {
		BigDecimal decimal1 = new BigDecimal("3.6");
		BigDecimal decimal2 = decimal1.setScale(2);
		System.out.println(decimal1);
		System.out.println(decimal2);
	}

	@Test
	public void intValue() {
		BigDecimal decimal1 = new BigDecimal("3.6");
		System.out.println(decimal1.intValue());
		// System.out.println(decimal1.intValueExact()); //报错

		BigDecimal decimal2 = decimal1.setScale(1, RoundingMode.HALF_EVEN);
		System.out.println(decimal2.intValue());
		System.out.println(decimal2.intValueExact());
	}

	@Test
	public void round() {
		//银行家算法
		//舍去位小于5时直接舍去
		//舍去位大于5时，进位后舍去
		//舍去位等于5时，若5后面还有非0数字，进位，若5后面是0，则看前面的数字，奇数进位，偶数舍去
		BigDecimal decimal1 = new BigDecimal("4.5");
		BigDecimal decimal2 = decimal1.setScale(0, RoundingMode.HALF_EVEN);
		System.out.println(decimal2);
		
		
	}
}
