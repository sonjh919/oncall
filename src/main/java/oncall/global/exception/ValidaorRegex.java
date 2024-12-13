package oncall.global.exception;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaorRegex {
    public static final String DELIMITER = ",";

    public static final String GROUP = "()"; //그룹
    public static final String SELECT = "[]"; //문자 선택
    public static final String START = "^"; //시작
    public static final String END = "$"; //끝
    public static final String KOREAN_PATTERN = "[가-힣]+"; //한글 /-: RANGE
    public static final Pattern KOREAN_AND_ENGLISH_PATTERN = Pattern.compile("^[ㄱ-ㅎ가-힣A-Za-z]+$"); //한글영어

    public static final String WORD_PATTERN = "[\\w가-힣]+"; //한글
    public static final String NUMERIC_PATTERN = "([1-9]\\d*)"; //0보다 큰 정수
    private static final String REAL_NUMBER_PATTERN = "((\\d)+\\.(\\d*[1-9]))"; // 실수
    // \d : 0~9 \s : space \w : 알파벳+숫자+_
    // x+ x가 한번이상반복
    // x* x가 0번이상반복

    //크리스마스
//    private static final String ORDER_PATTERN =
//            "(" + KOREAN_PATTERN + ")" + "-" + "(" + NUMERIC_PATTERN + ")"; //([가-힣]+)-(([1-9]\d*))
//    private static final Pattern ORDERS_PATTERN = Pattern.compile(
//            ORDER_PATTERN + "(" + DELIMITER + ORDER_PATTERN + ")*"); //([가-힣]+)-(([1-9]\d*))(,([가-힣]+)-(([1-9]\d*)))*

    //편의점
    private static final String PRODUCT_NAME_REGEX = "([\\w가-힣]+)";
    private static final String PRODUCT_REGEX = "\\[" + PRODUCT_NAME_REGEX + "-(\\d+)\\]"; //\[([\w가-힣]+)-(\d+)\]
    private static final Pattern PRODUCT_LIST_PATTERN = Pattern.compile(
            "^(" + PRODUCT_REGEX + ")(," + PRODUCT_REGEX + ")*$"); // ^(\[([\w가-힣]+)-(\d+)\])(,\[([\w가-힣]+)-(\d+)\])*$

    // 계산기
//
//    private static final String NUMBER_PATTERN = "(" + NUMERIC_PATTERN + "|" + REAL_NUMBER_PATTERN + ")"; //0보다 큰 정수 또는 실수
//    private static final Pattern DELIMITER_PATTERN = Pattern.compile("//(\\D)\\\\n.*");
//    private static final String CUSTOM_DELIMITER_START = "//";
//    private static final String CUSTOM_DELIMITER_END = "\\\\n";

    //////////////////////////////////////////////////////////////////////

    private static void validateRegex(final String input, final Pattern pattern, final ExceptionMessage exception) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(exception.message);
        }
    }

    private static List<String> getListfrom(final String input, final String delimiter) {
        return List.of(input.split(delimiter));
    }

    //////////////////////////////////////////////////////////////////////
    // 계산기 : matches() 이후 매칭가능

//    public void extractDelimiter() {
//        Matcher matcher = DELIMITER_PATTERN.matcher(input);
//        String[] splitDelimiter = input.split(CUSTOM_DELIMITER_END);
//
//        if (splitDelimiter[0].startsWith(CUSTOM_DELIMITER_START)) {
//            validateDelimiter(matcher);
//            input = splitDelimiter[1];
//            this.delimiters = createDelimiters(matcher.group(1).charAt(0));
//            return;
//        }
//        input = splitDelimiter[0];
//        this.delimiters = createDelimiters();
//    }

    //////////////////////////////////////////////////////////////////////
    // 편의점 : PurchaseProducts 참고
    //그룹별로 추출해서 객체 만들기
}
