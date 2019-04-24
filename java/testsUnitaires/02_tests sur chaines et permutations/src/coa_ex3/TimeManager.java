package coa_ex3;
import java.util.ArrayList;

import tools.Tools;

public class TimeManager {
	static String h, m, s, temp;
	static String msg = "NOT_POSSIBLE";

	public static String getFirstTimeAvailable(String s){
		
		if (s == null) {
//			
//			System.out.println("[13] chaine null");
			return msg;
		}
		
		if (s.isEmpty()) {
//			
//			System.out.println("[18] chaine vide");
			return msg;
		}
				
		String[] n = tools.Tools.explodeAndOrderInAscending(s);
			
		h = n[0]+n[1];
		m = n[2]+n[3];
		s = n[4]+n[5];
		
//		
//		System.out.println("[28] apres tri explode: "+ h+"h"+m+"m"+s+"s");
		
		if (tools.Tools.checkIfHourIsValid(h)==false){
//			
//			System.out.println("[29] h non valide");
			return msg;
		}
		
		if (tools.Tools.checkIfHourIsValid(h)==true){
			if ( tools.Tools.checkIfMinuteOrSecondIsValid(m)==true && tools.Tools.checkIfMinuteOrSecondIsValid(s)==false){
				
				temp=n[3];
				n[3]=n[4];
				n[4]=temp;
				
				h = n[0]+n[1];
				m = n[2]+n[3];
				s = n[4]+n[5];
//				
//				System.out.println("[45] hTRUE mTRUE sFALSE: "+h+"h"+m+"m"+s+"s");
				
				if (tools.Tools.checkIfMinuteOrSecondIsValid(m)==false){
					
					temp=n[1];
					n[1]=n[4];
					n[4]=temp;
					
					h = n[0]+n[1];
					s = n[2]+n[3]; //on inverse les secondes et les minutes car les minutes seront plus petites que les secondes
					m = n[4]+n[5];
//
//					System.out.println("[57] hTRUE mFALSE : "+h+"h"+m+"m"+s+"s");
				}
					
			}
			if (tools.Tools.checkIfMinuteOrSecondIsValid(m)==false && tools.Tools.checkIfMinuteOrSecondIsValid(s)==false
				) 	{	
//				
//				System.out.println("[57] mFALSE et sFALSE");
				return msg;
			}
		}
		 
		String res = h+"h"+m+"m"+s+"s";
		return res;
	}		
}
	

