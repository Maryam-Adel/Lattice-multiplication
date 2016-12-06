import java.util.Scanner;

/**
 * Lattice multiplication
 * @author Maryam Alaqel
 * maa250@pitt.edu
 */
public class LatticeMultiplication {
	public static void main(String args[]){
	Scanner reader = new Scanner(System.in);
	
	System.out.println("Example: first numebr=224 and second number=53, the answer is 11872 \n");
	System.out.print("The first number: ");
	String string1 =reader.next();
	  int len1 =string1.length()-1;	
	  int num1[] = new int[len1+1];
	  int digit1=0;
	  int char1=0;
	  while(char1<=len1 || digit1<=num1.length-1){
	    num1[digit1]= Character.getNumericValue(string1.charAt(char1));
	    digit1++;
	    char1++;	
	}
	
	System.out.print("The second number: ");
	String string2 =reader.next();
	  int len2 =string2.length()-1;	
	  int num2[] = new int[len2+1];
	  int digit2=0;
	  int char2=0;
	  while(char2<=len2 || digit2<=num2.length-1){
	    num2[digit2]= Character.getNumericValue(string2.charAt(char2));
	    digit2++;
	    char2++;	
	}
	latticeMulti(string1, string2,num1,num2);	
	reader.close();	
	}
  
	public static void latticeMulti(String string1, String string2, int [] num1, int [] num2){
		int size = num1.length + num2.length;
		int answ [] = new int[size];
		for(int x=0; x<answ.length;x++){
			answ[x]=0;	
		}

		int i=num2.length-1, j, p=size-1, n=p-1;
		int t=0;
		int temp;

		while(i>=0){
			j=num1.length-1;
			
			while(j>=0){
				temp=num1[j]* num2[i];
				if(n>=0)
				if(temp <10)
					answ[p]+=temp;
				else{
					answ[p]+=temp%10;
					answ[n]+=temp/10;
				}
					
				j--;
				p--;
				n--;
				if(j<0){
					t++;		
				}
			}
			p=size-1-t;
			n=p-1;
			i--;
		}
		
		int array[]= new int[answ.length];
		array =completeSum(answ);
		System.out.print( string1 +" x "+ string2 +"= ");
		for(int a=0; a<array.length;a++)
			System.out.print(array[a]);
	}
	
	/**
	 * 
	 * @param integer array 
	 * @return integer array after performing sum calculations
	 */
	public static int[] completeSum(int[] array){
		int [] result= new int[array.length];
		int res;
		for(int value=array.length-1; value>=0; value--){
			res= array[value];
			if(res>=10)
			{
				result[value]= res%10;
				array[value-1]= array[value-1] + res/10;	
			}
			else
				result[value]= res;
		}
		return result;
	
  }
}
