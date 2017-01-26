package mybatiseproject.util;

public enum PicBagNameEnum {
	PERSONAL_BAGS("personalBags"),//新闻图片
	CIRCLE_BAGS("circleBags"),//圈子图片
	PORTRAIT_BAGS("portraitBags");
private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

private PicBagNameEnum(String name) {
	this.name = name;
}
	
}
