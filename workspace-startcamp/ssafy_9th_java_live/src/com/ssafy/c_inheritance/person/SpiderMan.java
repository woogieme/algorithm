package com.ssafy.c_inheritance.person;
//is a
public class SpiderMan extends Person{
	boolean isSpider;
	
	//has a
	Spider spider;
	public SpiderMan() {}
	public SpiderMan(String name, boolean isSpider) {
		//super();
		//this.name=name;
		super(name);
		this.isSpider=isSpider;
		this.spider=new Spider();
	}
	public void fireWeb() {
		if(this.isSpider) {
			this.spider.fireWeb();
		}else {
			System.out.println("사람일때는 못쏴요~~");
		}
	}
	
	@Override
	public void jump() {
		if(this.isSpider) {
			this.spider.jump();
		}
		else {
			super.jump();
		}
	}
}
