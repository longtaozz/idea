package com.zt.jinanzf.common.util;

public class StringUtil {

	public static boolean isEmpty(String str) {
		if ("".equals(str) || str == null) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNotEmpty(String str) {
		if (str == null || "".equals(str)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 非法字符判断 空格也作为非法字符
	 * 
	 * @param str
	 *            准备判断的字符串
	 * @return 返回判断的结果 正常返回true 非法返回false
	 * */
	public static boolean isNotIllegal(String str) {
		if (!str.equals("") && str.matches("[a-zA-Z0-9_\u4e00-\u9fa5]*")) {
			// 不是非法字符
			return true;
		}
		return false;

	}

	/**
	 * 根据Unicode编码判断中文汉字和符号
	 * */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}

	/**
	 * 通过字符串是否包含中文
	 * 
	 * @param strName
	 *            准备判断的字符串
	 * @return 返回的结果 true包含中文，false没有出现中文
	 * */
	public static boolean isChineseInclude(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 通过字符串是否全是中文
	 * 
	 * @param strName
	 *            准备判断的字符串
	 * @return 返回的结果 true全是中文，false不全是中文
	 * */
	public static boolean isChineseAll(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!isChinese(c)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否全是英文
	 * 
	 * @param str
	 *            准备判断的字符串
	 * @return true 全是英语，false不全是英语。
	 * */
	public static boolean isEnglish(String str) {
		return str.matches("^[a-zA-Z]*");

	}
	
	/**
	 * 判断字符串是否全是数字
	 * 
	 * @param str
	 *            准备判断的字符串
	 * @return true 全是数字，false不全是数字。
	 * */
	public static boolean isNumber(String str) {
		return str.matches("[0-9]*");

	}
	
	
	/**
	 * 检查 email输入是否正确  
    * 正确的书写格 式为 username@domain  
    * @param value  
    * @return  
	 * */
    public static boolean checkEmail(String value, int length) {  
        return value  
                .matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")  
                && value.length() <= length;  
    }  
  
    /**  
    * 检查电话输入 是否正确  
    * 正确格 式 012-87654321、0123-87654321、0123－7654321  
    * @param value  
    * @return  
    */  
    public static boolean checkTel(String value) {  
        return value.matches("\\d{4}-\\d{8}|\\d{4}-\\d{7}|\\d(3)-\\d(8)");  
    }  
  
    /**  
    * 检查手机输入 是否正确  
    *  
    * @param value  
    * @return  
    */  
    public static boolean checkMobile(String value) {  
        return value.matches("^[1][3,5]+\\d{9}");  
    }  
  
    /**  
    * 检查中文名输 入是否正确  
    *  
    * @param value  
    * @return  
    */  
    public static boolean checkChineseName(String value, int length) {  
        return value.matches("^[\u4e00-\u9fa5]+{1}") && value.length() <= length;  
    }  
  
    /**  
    * 检查HTML 中首尾空行或空格  
    * @param value  
    * @return  
    */  
    public static boolean checkBlank(String value) {  
        return value.matches("^\\s*|\\s*{1}");  
    }  
  
    /**  
    * 检查字符串是 否含有HTML标签  
    * @param value  
    * @return  
    */  
    public static boolean checkHtmlTag(String value) {  
        return value.matches("<(\\S*?)[^>]*>.*?</\\1>|<.*? />");  
    }  
  
    /**  
    * 检查URL是 否合法  
    * @param value  
    * @return  
    */  
    public static boolean checkURL(String value) {  
        return value.matches("[a-zA-z]+://[^\\s]*");  
    }  
  
    /**  
    * 检查IP是否 合法  
    * @param value  
    * @return  
    */  
    public static boolean checkIP(String value) {  
        return value.matches("\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}");  
    }
  
    /**  
    * 检查ID是否 合法，开头必须是大小写字母，其他位可以有大小写字符、数字、下划线  
    * @param value  
    * @return  
    */  
    public static boolean checkID(String value) {  
        return value.matches("[a-zA-Z][a-zA-Z0-9_]{4,15}{1}");  
    }
  
    /**  
    * 检查QQ是否 合法，必须是数字，且首位不能为0，最长15位  
    * @param value  
    * @return  
    */  
  
    public static boolean checkQQ(String value) {  
        return value.matches("[1-9][0-9]{4,13}");  
    }  
  
    /**  
    * 检查邮编是否 合法  
    * @param value  
    * @return  
    */  
    public static boolean checkPostCode(String value) {  
        return value.matches("[1-9]\\d{5}(?!\\d)");  
    }  
  
    /**  
    * 检查身份证是 否合法,15位或18位  
    * @param value  
    * @return  
    */  
    public static boolean checkIDCard(String value) {  
        return value.matches("\\d{15}|\\d{18}");  
    }  
  
    /**  
    * 检查输入是否 超出规定长度  
    * @param length  
    * @param value  
    * @return  
    */  
    public static boolean checkLength(String value, int length) {  
        return ((value == null || "".equals(value.trim())) ? 0 : value.length()) <= length;  
    }  
  
	
}
