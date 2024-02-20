import java.util.Scanner;

public class Baekjoon {

   
   public static void main(String[] args) {
      
      int N;
      
      Scanner sc = new Scanner(System.in);
      System.out.print("");
      N = sc.nextInt();
      
      
      for(int i=1; i<=N; i++) {
    	  
    	  for(int j=0; j<N-i; j++) {
    		  System.out.print(" ");
    	  } // for
    	  
    	  for(int j=0; j<i*2-1; j++) {
    		  System.out.print("*");
    	  }
    	  
    	  System.out.println();
      } // for
      
      for(int i=N-1; i>=1; i--) {
    	  
    	  for(int j=0; j<N-i; j++) {
    		  System.out.print(" ");
    	  } // for
    	  
       	  for(int j=0; j<i*2-1; j++) {
       		  System.out.print("*");
       	  } // for
       	  
       	  System.out.println();
      } // for
      
      
   } // main

} // end class