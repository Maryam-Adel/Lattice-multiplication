# Lattice-multiplication
In this repository, I designed a simple algorithm that uses lattice multiplication method. For more information about how does lattice multiplication work, please visit http://www.learnnc.org/lp/pages/4458


# Algorithm

   Input: two integer arrays
 
   Output: mutiplication of the two numbers (one dimension array)

    //for simplicity num1=[2,2,4] , num2=[5,3] 
    int[] latticeMultiplication ( int num1[], int num2[]){

    //let i points to the end of the array [3]
    int i = sizeOf(num2); 
    int j ;
    int currentValue; 
  
    //set the size of the result array and make it contains zeros
    int size = sizeOf(num1) + sizeOf(num2);
    int result[size];
    loop through all elements in result[] and make them 0
  
    //those pointers to maintain the result array
    int pointer1 = sizeOf(result);  //initially points to [0]
    int pointer2 = pointer1 -1;
  
    while( i>=0){
      j = sizeOf(num1); //points to [4]
    
      while( j>=0){
        CurrentValue = num1[j] * num2[i];
        //remember that if the result of multiplication has two digits
        //we need to add the most left digit to the next slide
        //otherwise we just add the currentvalue to whatever there
          if(CurrentValue < 10 ) 
            result[pointer1] = result[pointer1] + CurrentValue;
          else
          {
            result[pointer1] = result[pointer1] + CurrentValue%10; //most right digit
            result[pointer2] = result[pointer2] + CurrentValue/10;
           }
        
        //update pointers going backwards because we have started from the end of arrays
        j--; //it will point to [2]...[2]
        pointer1--;
        pointer2--;
        
        }//end of inner while
     
     i--;   // go to the next number in the array
     
    }//while
    
    //now we need to perform sum calculations of result array 
    //because in case of large numbers will have an array like [1,4,16,7,0]
    //and this will not be an acceptable answer cause the answer should be 15670
    
    
    int answer[sizeOf(result)];
    return answer = sumCal(result);
    
    }
   
   Input: An integer one dimension array that its values has two digits in one cell,
   so their most left need to be added to the next value.
   
   Output: An integer one dimension array that its all values have one digit only
   
      int[] sumCal(int result[]){
        int array[sizeOf(result)];
        int value;
        int i;
      
      //going backwards 
      for(int i=sizeOf(result); i>=0; i--){
          if(result[i]>=10)
            {
            array[i] = result[i]%10;
            result[i-1]= result[i-1] + result[i]/10;  
            }
          else
            array[i] =result[i];
         }//if
         
      return array;
     }
  

# Implementation 
The solution is implemented in java
 
# Author
© 2016 Maryam Alaqel
