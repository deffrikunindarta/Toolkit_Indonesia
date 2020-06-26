/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizer_indonesia;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;  

public class Tokenizer_Indonesia_withoutClitics{  
 



  static Pattern end = Pattern.compile("\\G\\z");  
  static Pattern word = Pattern.compile("\\G\\w+");  
  static Pattern punct = Pattern.compile("\\G\\p{Punct}");  
  static Pattern space = Pattern.compile("\\G\\s");  
  static Pattern number = Pattern.compile("\\G\\d+\\,?\\d*");
  static Pattern repetition = Pattern.compile("\\G\\b(\\w+)(\\b\\W+\\b\\1\\b)*");
  static Pattern multi = Pattern.compile("\\G(\\brumah sakit\\b|\\borang tua\\b|\\bbunga desa\\b|\\bair mata\\b)");
  static Pattern acronym = Pattern.compile("([a-zA-Z]*\\.)+");



  static String getTextToken(Matcher mat) { 

    mat.usePattern(space); 
    mat.find(); 


    mat.usePattern(punct); 
    if(mat.find()) {
        return mat.group();
    } 
      
    mat.usePattern(number); 
    if(mat.find()) {
        return mat.group();
    } 
    
    mat.usePattern(multi); 
    if(mat.find()) {
        return mat.group();
    } 

    mat.usePattern(repetition); 
    if(mat.find()) {
        return mat.group();
    } 
    mat.usePattern(acronym); 
    if(mat.find()) {
        return mat.group();
    }   

    mat.usePattern(word); 
    if(mat.find()) {
        return mat.group();
 
    } 

    mat.usePattern(end); 
    if(mat.find()) return "";     
        return null; 
        
  } 
  
 
  public List<List<String>> test(String sentence) {  
    String token; 
 
    Matcher mat = end.matcher(sentence.toLowerCase()); 
    List<String> list = new ArrayList<>(); 


    do { 
      token = getTextToken(mat); 
 
      if(token == null) { 
        break; 
      } 
 
      if(token.length() != 0) {
        list.add(token);
      }else {

       }
 
    } while(token.length() != 0);

     
    List<List<String>> a= new ArrayList<List<String>>();
    List<String> temp = new ArrayList<>();
    for (int i=0; i<list.size(); i++) {
        temp.add(list.get(i));
        if(list.get(i).equals(".")){
            a.add(new ArrayList(temp));
            temp.clear();
        }
        
           
    }
    for (int i=0; i<a.size(); i++) {
        System.out.println("Sentence "+ (i+1));
        System.out.println(a.get(i));
        
    }
    return a;

  }  
}
 
    

   

