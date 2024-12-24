package ch11;

//Runtime Exception(실행 예외)  -> UncheckException -> 컴파일러 예외 확인하지 않음.
public class ExceptionEx1 {

   public static int makeException(int input) {
      int divide = 0;
      int result = input/divide;   // java.lang.ArithmeticException: / by zero
      return result;
   }
   
   public static void makeException2() {
      String s= "가";
      System.out.println(s.charAt(1)); //  java.lang.StringIndexOutOfBoundsException: 
   }
   
   public static void makeException3() throws Exception {
      int[] a = { 1, 2, 3};
      System.out.println(a[3]);
   }
   
   public static void makeException4() {
      String nothing = null;
      System.out.println(nothing.split("")); //Cannot invoke "String.split(String)" because "nothing" is null
   }
   
   public static void makeException5() {
      String notInt = "가나다";
      int a = Integer.parseInt(notInt);	//For input string: "가나다"
   }
   
   public static void makeExcetpion6() {	
      for(int i = 0; i < Integer.MAX_VALUE; i++) {
         makeExcetpion6(); // Exception in thread "main" java.lang.StackOverflowError
      }
   }
   
   public static void makeException7() {
      Object[] objArr = new String[3];
      objArr[0] = 0; // java.lang.Integer
   }
   
   public static void makeException8() {
      Object[] objArr = new String[3];
      objArr[0] = "0";
      Integer a = (Integer) objArr[0]; // class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
   }
   
   public static void main(String[] args) throws Exception {
      
//     makeException(10);
//     makeException2();
//	   makeException3(); 	// 이 메소드는 throws를 사용하여 예외 사항을 호출한 곳으로 넘김
	   						// 이 메소드를 호출한 곳에서 예외 처리를 진행해야 함
	   						// 예외 처리 방법 1. try - catch - finally
	   						// 			  2. throws
//	   makeException4();
//	   makeException5();
//	   makeExcetpion6();
//	   makeException7();
//	   makeException8();
   }

}
