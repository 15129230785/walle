package util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hunk.qin on 2015/1/25.
 */
public class StringUtil {


    /**
     * 字符串如果是空返回 true
     */
    public static boolean isEmpty(String str) {
        if ((str == null) ||str.length()==0||trim(str).equals("") || str.equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }


    /**
     * 字符串，如果不是空，返回true
     */
    public static boolean isNotEmpty(String str) {
        return  !isEmpty(str);
    }

    /**
     * 删除字符串前后空格，包括半角，全角
     * To delete the space on beginning and end of the string. Both single-byte
     * and double-byte space will be deleted.
     * @param str String
     * @return trimed string
     */
    public static String trim(String str) {
        if ((str == null) || str.trim().equals("")) {
            return "";
        }

        String newStr = str.trim();
        boolean startFull = newStr.startsWith("　"); // 12288
        boolean endFull = newStr.endsWith("　"); // 12288
        boolean startHalf = newStr.startsWith(" "); // 97
        boolean endHalf = newStr.endsWith(" "); // 97

        while (startFull || endFull || startHalf || endHalf) {
            startFull = newStr.startsWith("　"); // 12288
            endFull = newStr.endsWith("　"); // 12288

            if (startFull) {
                if (newStr.length() == 1) {
                    return "";
                }

                newStr = newStr.substring(1);
            }

            if (endFull) {
                if (newStr.length() == 1) {
                    return "";
                }

                newStr = newStr.substring(0, newStr.length() - 1);
            }

            startHalf = newStr.startsWith(" "); // 97
            endHalf = newStr.endsWith(" "); // 97

            if (startHalf) {
                newStr = newStr.substring(1);
            }

            if (endHalf) {
                newStr = newStr.substring(0, newStr.length() - 1);
            }
        }

        return newStr;
    }


    public static String convertUnicode(String msg) {
        if(msg == null){
            return "";
        }
        char[] in = msg.toCharArray();
        int off = 0;
        char c;
        char[] out = new char[in.length];
        int outLen = 0;
        while (off < in.length) {
            c = in[off++];
            if (c == '\\') {
                if (in.length > off) { // 是否有下一个字符
                    c = in[off++]; // 取出下一个字符
                } else {
                    out[outLen++] = '\\'; // 末字符为'\'，返回
                    break;
                }
                if (c == 'u') { // 如果是"\\u"
                    int value = 0;
                    if (in.length > off + 4) { // 判断"\\u"后边是否有四个字符
                        boolean isUnicode = true;
                        for (int i = 0; i < 4; i++) { // 遍历四个字符
                            c = in[off++];
                            switch (c) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    value = (value << 4) + c - '0';
                                    break;
                                case 'a':
                                case 'b':
                                case 'c':
                                case 'd':
                                case 'e':
                                case 'f':
                                    value = (value << 4) + 10 + c - 'a';
                                    break;
                                case 'A':
                                case 'B':
                                case 'C':
                                case 'D':
                                case 'E':
                                case 'F':
                                    value = (value << 4) + 10 + c - 'A';
                                    break;
                                default:
                                    isUnicode = false; // 判断是否为unicode码
                            }
                        }
                        if (isUnicode) { // 是unicode码转换为字符
                            out[outLen++] = (char) value;
                        } else { // 不是unicode码把"\\uXXXX"填入返回值
                            off = off - 4;
                            out[outLen++] = '\\';
                            out[outLen++] = 'u';
                            out[outLen++] = in[off++];
                        }
                    } else { // 不够四个字符则把"\\u"放入返回结果并继续
                        out[outLen++] = '\\';
                        out[outLen++] = 'u';
                        continue;
                    }
                } else {
                    switch (c) { // 判断"\\"后边是否接特殊字符，回车，tab一类的
                        case 't':
                            c = '\t';
                            out[outLen++] = c;
                            break;
                        case 'r':
                            c = '\r';
                            out[outLen++] = c;
                            break;
                        case 'n':
                            c = '\n';
                            out[outLen++] = c;
                            break;
                        case 'f':
                            c = '\f';
                            out[outLen++] = c;
                            break;
                        default:
                            out[outLen++] = '\\';
                            out[outLen++] = c;
                            break;
                    }
                }
            } else {
                out[outLen++] = (char) c;
            }
        }
        return new String(out, 0, outLen);
    }

    /**
     * 去除字符串首尾出现的某个字符.
     * @param source 源字符串.
     * @param element 需要去除的字符.
     * @return String.
     */
    public static String trimFirstAndLastChar(String source,char element)
    {
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do{
            int beginIndex = source.indexOf(element) == 0 ? 1 : 0;
            int endIndex = source.lastIndexOf(element) + 1 == source.length() ? source.lastIndexOf(element) : source.length();
            source = source.substring(beginIndex, endIndex);
            beginIndexFlag = (source.indexOf(element) == 0);
            endIndexFlag = (source.lastIndexOf(element) + 1 == source.length());
        } while (beginIndexFlag || endIndexFlag);
        return source;
    }


    /**
     * 解析前端提交的params 参数到map
     * eg:param:{"username":"1232","password":"4567"}
     * @param parmsstr
     * @return
     */
    public static Map<String,String> parseParamsToMap(String parmsstr){
        if(StringUtil.isEmpty(parmsstr)) return new HashMap<String, String>();
        Map<String,String> paramsMap= JSON.parseObject(parmsstr, Map.class);
        return paramsMap;
    }

}
