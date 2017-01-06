package mybatiseproject.util;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * StringBuffer 工具类
 * */
@Component
public class BufferUtil {
	/**
	 * 拼接两个String参数
	 * */
	public StringBuffer bufferString(String param0,String param1){
		StringBuffer buffer=new StringBuffer();
		buffer.append(param0);
		buffer.append(param1);
		return buffer;
	}
	public StringBuffer bufferObject(long param0,String param1){
		StringBuffer buffer=new StringBuffer();
		buffer.append(param0);
		buffer.append(param1);
		return buffer;
	}
	/**
	 * 拼接n个String参数
	 * */
	public String bufferString(String...strings){
		StringBuffer buffer=new StringBuffer();
		for (String str : strings) {
			buffer.append(str);
		}
		return buffer.toString();
	}
	/**
	 * 将list型参数拼接成stringbuffer
	 * */
	public StringBuffer bufferList(List<String> list){
		StringBuffer buffer=new StringBuffer();
		for(int i=0;i<list.size();i++){
		buffer.append(list.get(i));	
		}
		return buffer;
	}
}
