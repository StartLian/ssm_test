package com.gessica.service01.test7;

public class TicketHelper {
	public void buildAdult(String info) {
		System.out.println("构建成年人票逻辑："+info);
	}
	public void buildChildrenForSeat(String info) {
		System.out.println("构建儿童有坐票逻辑："+info);
	}
	public void buildChildrenNoSeat(String info) {
		System.out.println("构建儿童无坐票逻辑："+info);
	}
	public void buildElderly(String info) {
		System.out.println("构建老年人票逻辑："+info);
	}
	public void buildSoldier(String info) {
		System.out.println("构建军年及家属票逻辑："+info);
	}
}
