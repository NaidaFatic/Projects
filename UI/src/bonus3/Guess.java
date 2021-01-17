/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus3;

import java.util.ArrayList;

/**
 *
 * @author Naida
 */
public class Guess {
    private String guess;
    private String word;
    private int value;
    private ArrayList<String> letters;
    private ArrayList<String> lettersx;
    
    public Guess(){
        this.word="naida";
        this.value=10;
        letters= new ArrayList<String>();
        lettersx= new ArrayList<String>();
    }
    public void setGuess(String guess){
        this.guess=guess;
    }
    public int compare(String guess){
        this.value-=1;
        setGuess(guess);
        if(this.guess.equals(this.word)){           
            return 1; 
        }      
        else if(this.word.contains(this.guess)){
            letters.add(guess);
            return 0;
        }            
        else {
            lettersx.add(guess);
            return 0;
        }        
    }
    public int getValue(){
        return this.value;
    }
    public String getLetters(){
        String letter="";
        for(String l: letters)
         letter+=l+" ";
        return letter;
    }
    public String getLettersx(){
        String letter="";
        for(String l: lettersx)
         letter+=l+" ";
        return letter;
    }
}
