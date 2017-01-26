package mybatiseproject.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FormatUtils {

	public double decimalFormat(double num, int digits) {
		BigDecimal b = new BigDecimal(num);
		return b.setScale(digits, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 格式化时间成yyyyMMddHHmmss格式
	 * 
	 * @param source
	 * @return Date
	 **/
	public Date stringToDate(String source) {
		if (null != source && !"".equals(source)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				return sdf.parse(source);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 格式化时间成任意格式
	 * 
	 * @param source
	 * @param format
	 * @return Date
	 */
	public Date stringToDate(String source, String format) {
		if (null != source && !"".equals(source)) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			try {
				return sdf.parse(source);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String StringToDate(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(source);
	}
	/**
	 * 将String类型的时间字符串格式化成Date(yyyy-MM-dd)
	 * */
	public Date StringToDate2(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 将时间转化成yyyy-MM-dd HH:mm:ss
	 * 
	 * @param Date
	 * @return String
	 */
	public String dateToString(Date date, String format) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
		return "";
	}
	public String dateToStringFormatToYear(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		}
		return "";
	}
	public String dateToStringFormatToTime(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			return sdf.format(date);
		}
		return "";
	}
	public String dateToStringFormatToTime() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			return sdf.format(new Date());
	}
	public String dateToString3(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
			return sdf.format(date);
		}
		return "";
	}
	/**
	 * 将时间转化成yyyy-MM-dd HH:mm:ss
	 * 
	 * @param Date
	 * @return String
	 */
	public String dateToString(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		}
		return "";
	}

}
