package ch28.a;

// 애노테이션 정의
// 
public @interface MyAnnotation {

}

// 주석 : 컴파일 할 때 .class 파일에서 제거됨

// -> 한 줄 주석

/* ->
 * 여러줄 주석
 * : 컴파일 할 때 .class 파일에 포함되지 않음
 */

/** javadoc 주석
 * : javadoc.exe를 통해 HTML API 문서를 생성할 때 사용 됨.
 * : 컴파일 할 때 .class 파일에 포함되지 않음ㄴㄴ
 */

// @xxx(프로퍼티=값, 프로터티=값) 애노테이션
// : 컴파일러에게 정보 전달 할 때 사용.
// : 실행 중에 정보를 추출할 때 사용.
// : .class 파일에 포함할 수 있다.
// 
