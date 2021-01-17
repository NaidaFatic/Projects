/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus;
import java.util.List;
/**
 *
 * @author Naida
 */
public class Person {
    private String name;
    private PhoneNumbers number;
    private String street;
    private String city;
    
    public Person (String name, String number){
        this.name=name;
        this.number=new PhoneNumbers();
        this.number.add(number);             
    }
    public Person (String name){
        this.name=name;
        this.number=new PhoneNumbers();       
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        if(this.street==null)
            return "\taddress unknown";
        else
            return "\taddress: "+this.city+" "+this.street;
    }
    public List getNumber(){
        return this.number.getNumbers();
    }
    public String printNumber(){
        return this.number.print();
    }
    public void putAddress(String street,String city){
        this.street=street;
        this.city=city;
    }    
    public void putNumber(String n){
        number.add(n);
    }   
    
    
}
