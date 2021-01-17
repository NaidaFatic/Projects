/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Naida
 */
public class PhoneBook  {
    private List<Person> people;
    public PhoneBook(){
        people=new ArrayList<Person>();
    }
    
    public void addNumber(String name,String number){    
        int check=0;
            for(Person p: people){
                  if(p.getName().equals(name)){
                      p.putNumber(number);
                      check=1;
                  }                        
              }
            if(check==0){
                Person p=new Person(name,number);
                people.add(p); 
            }             
    }
    public int check(String name){
        int check=0;
        for(Person p: people){
            if(p.getName()==null)
                return 0;
            if(p.getName().equals(name))                
                return 1;
        }      
            return 0;
    }
 
    public void findNumber(String name){
        
        for(Person p: people){
            if(p.getName().equals(name)){
                if(p.getNumber().isEmpty())
                    System.out.println("\tphone number not found\n");
                else
                 System.out.println("\tphone number: \n"+p.printNumber());  
            }                          
           }
        if(check(name)==0)
            System.out.println("\tnot found\n");
       
    }
    public String findName(String number){
        List<Integer> list=new ArrayList<Integer>();
        for(Person p: people){
            list=p.getNumber();
            if(list.contains(number))
                return p.getName();            
        }
        return null;
    }
    public void addAddress(String name, String street, String city){
       
        for(Person p: people){
            if(p.getName().equals(name)){
                p.putAddress(street, city);
                }
        }
    }
    public void showAddress(String name){        
         for(Person p:people){
             if(p.getName().equals(name))
                 System.out.println(p.getAddress());
         }        
    }
    public void deletePerson(String name){
        for(Person p: people){
            if(p.getName().equals(name)){
                people.remove(p);
                break;
            }
                
        }
    }    
    public void create(String name){
        Person p=new Person(name);
        people.add(p);
    }
    public void search(String sub){
        int check=0;
        List<String> names=new ArrayList<String>(); 
       
        if(sub.equals("")){
            for(Person p: people){
                names.add(p.getName());
            }
           Collections.sort(names);
           if(names.isEmpty())
                System.out.println("\tno information");
           else{
           for(String n: names){
               System.out.println("\t"+n);
               showAddress(n);
               findNumber(n); 
           }             
           }
        }
        else {
            for(Person p: people){
                if(p.getName().contains(sub) || p.getAddress().contains(sub)){
                    names.add(p.getName()); 
                    check=1;
                }  
            }
            if(check==1){
                    Collections.sort(names);
                    for(String n: names){
                    System.out.println("\t"+n);
                    showAddress(n);
                    findNumber(n);
                    }
                }
            else System.out.println("\tkeyword not found");  
            
        }
    }
     

    
}
