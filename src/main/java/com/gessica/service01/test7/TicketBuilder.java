package com.gessica.service01.test7;

public class TicketBuilder {
	public static Object builder(TicketHelper helper) {
		System.out.println("通过TicketHelper构建套票信息");
		return null;
	}
	public static void main(String[] agrs) {
		TicketHelper helper = new TicketHelper();
		helper.buildAdult("成年票");
		helper.buildChildrenForSeat("儿童有坐票");
		helper.buildChildrenNoSeat("儿童五坐票");
		helper.buildElderly("老人票");
		helper.buildSoldier("构建军人票");
		TicketBuilder.builder(helper);
	}
}
