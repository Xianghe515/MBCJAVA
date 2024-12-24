package ch12;

import java.util.Calendar;

public class CalendarQ {

	public static void main(String[] args) {
		// 년, 월, 일을 입력 받고 해당 날짜가 무슨 요일인지 출력하는 프로그램 작성
		
			int year = 1999;
			int month = 05;
			int date = 15;
			
			String dayOfWeek = getDayOfWeek(year, month, date);
			System.out.println(dayOfWeek);
					


		
		

	}
	
	static String getDayOfWeek(int year, int month, int date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);	// Calendar.MONTH는 인덱스 값으로(0부터), month는 내가 입력한 값, 둘을 맞추기 위해서는 month에 -1
		cal.set(Calendar.DATE, date);
		

		switch(cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.MONDAY:
			return "월요일";
		case Calendar.TUESDAY:
			return "화요일";
		case Calendar.WEDNESDAY:
			return "수요일";
		case Calendar.THURSDAY:
			return "목요일";
		case Calendar.FRIDAY:
			return "금요일";
		case Calendar.SATURDAY:
			return "토요일";
		default:
			return "일요일";
		}
		
		
		

	}
	
	
}