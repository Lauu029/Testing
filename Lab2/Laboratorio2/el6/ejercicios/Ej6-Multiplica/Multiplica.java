//package ejercicios;
////Laura Gómez Bodego
////Sergio José Alfonso Rojas
////Daniel Illanes Morillas
//public class Multiplica {
//
//	public int[] multiplica(int[] array1, int[] array2) {
//		if(array1==null||array2==null) {
//			throw new NullPointerException();
//		}
//		
//		int minlong = ((array1.length < array2.length) ? array1.length : array2.length);
//		int maxlong = ((array1.length > array2.length) ? array1.length : array2.length);
//		
//		int outArray[] = new int[maxlong];
//		
//		for (int i = 0; i < minlong; i++) {
//			outArray[i] = array1[i]*array2[i];
//		}
//		int longarray[] = ((array1.length > array2.length) ? array1 : array2);
//		
//		for (int i = minlong; i < maxlong; i++) {
//			outArray[i] = longarray[i];
//		}
//		
//		return outArray;
//	}
//}
