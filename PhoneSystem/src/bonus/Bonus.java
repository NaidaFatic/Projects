/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus;
import java.util.Scanner;

/**
 *
 * @author Naida
 */
public class Bonus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        PhoneBook pb=new PhoneBook();
        
        System.out.println("Phone search");
        operations();
        
        String op;       
        System.out.print("command: ");
        op=reader.nextLine();
        
        while(!op.equals("x")){
            
            if(op.equals("1")){
                String number;
                String name;
                System.out.print("whose number: ");
                name=reader.nextLine();
                System.out.print("number: ");
                number=reader.nextLine();   
                pb.addNumber(name, number);
                System.out.println("");
            }
            if(op.equals("2")){                
                String name;
                System.out.print("whose number: ");
                name=reader.nextLine();                 
                pb.findNumber(name);
            }
            if(op.equals("3")){
                String number;                
                System.out.print("number: ");
                number=reader.nextLine(); 
                if(pb.findName(number)==null)
                    System.out.println("\tnot found\n");
                else {System.out.println("\t"+pb.findName(number));
                System.out.println("");}
            }
            if(op.equals("4")){
                String city, street, name;                
                System.out.print("whose address: ");
                name=reader.nextLine(); 
                if(pb.check(name)==0){
                    pb.create(name);
                    System.out.print("street: ");
                    street=reader.nextLine();
                    System.out.print("city: ");
                    city=reader.nextLine(); 
                    pb.addAddress(name,street,city);
                }
                else{
                    System.out.print("street: ");
                    street=reader.nextLine();
                    System.out.print("city: ");
                    city=reader.nextLine(); 
                    pb.addAddress(name,street,city);
                }
                System.out.println("");
            }
            if(op.equals("5")){
                String name;                
                System.out.print("whose information: ");
                name=reader.nextLine(); 
               if(pb.check(name)==0)
                    System.out.println("\tnot found\n");
                else{
                pb.showAddress(name);                
                pb.findNumber(name);
                }                     
            }
            if(op.equals("6")){
                String name;                
                System.out.print("whose information: ");
                name=reader.nextLine(); 
                pb.deletePerson(name);
                System.out.println("");
                }
            if(op.equals("7")){
                String substring;                
                System.out.print("keyword (if empty, all listed): ");
                substring=reader.nextLine(); 
                pb.search(substring);               
                }
            
            System.out.print("command: ");
            op=reader.nextLine();
        }            
        
              
       
    }
    
    public static void operations(){
        System.out.println("avaible operations:");
        System.out.println("  1 add a number\n"
                + "  2 search for a number\n"
                + "  3 search for a person by phone number\n"
                + "  4 add an address\n"
                + "  5 search for personal information\n"
                + "  6 delete personal information\n"
                + "  7 filtered listing\n"
                + "  x quit");
    }
   
    
}
