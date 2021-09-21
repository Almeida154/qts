package util;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

public class Util {
	
	@Test
	public Date addDays(Date date, int daysQuantity) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, daysQuantity);
		return calendar.getTime();
	}
	
	public Date getDays(int day, int month, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month -1);
		calendar.set(Calendar.YEAR, year);
		return calendar.getTime();
	}
	
	/**
	 * @return boolean
	 * @param Date retirada
	 * Verifica se a data de retirada é igual ao do mesmo dia
	 * */
	public boolean areEqualDates(Date pullout) {
		Date dates[] = {pullout, new Date()};
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(dates[0]);
		
		Calendar c2 = Calendar.getInstance();
		c1.setTime(dates[1]);
		
		if (c1.YEAR == c2.YEAR && c1.MONTH == c2.MONTH && c1.DAY_OF_MONTH == c2.DAY_OF_MONTH)
			return true;		
		return false;
	}
}

//CÓDIGO ORIGINAL:

//package Util;
//
//import java.util.Calendar;
//import java.util.Date;
//
//public class DataUtil {
//	
//	public Date addDias(Date date, int qtdDias) {
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//		calendar.add(Calendar.DAY_OF_MONTH, qtdDias);
//		return calendar.getTime();
//	}
//	
//	public Date obterData(int dia, int mes, int ano) {
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.DAY_OF_MONTH, ano);
//		calendar.set(Calendar.MONTH, mes -1);//no calendar deve começar em 0 e não em 1
//		calendar.set(Calendar.YEAR, ano);
//		return calendar.getTime();
//	}
//	
//	public boolean verificaDatasIguais(Date date1, Date date2) {
//		Calendar c1=Calendar.getInstance();
//		c1.setTime(date1);
//		Calendar c2=Calendar.getInstance();
//		c1.setTime(date2);
//		
//		if (c1.YEAR == c2.YEAR && c1.MONTH == c2.MONTH &&  c1.DAY_OF_MONTH == c2.DAY_OF_MONTH) { 
//			
//			return true;
//		}else { 
//			return false;
//		}
//	}
//
//}