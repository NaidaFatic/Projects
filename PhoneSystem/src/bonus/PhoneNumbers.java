/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Naida
 */
public class PhoneNumbers {
   private List<String> numbers;
   
   public PhoneNumbers(){
       numbers=new ArrayList<String>();
       
   }
   public void add(String number){
       numbers.add(number);
   }
  public List getNumbers(){
      return numbers;
  }
  public String print(){
      String print="";
      for(String n: numbers)
          print+="\t "+n+"\n";
     return print;
      
  }
 
    
}
