/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizer_indonesia;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;  

public class Tokenizer_Indonesia_withClitics{  
 

  static Pattern end = Pattern.compile("\\G\\z");  
  static Pattern word = Pattern.compile("\\G\\w+");  
  static Pattern punct = Pattern.compile("\\G\\p{Punct}");  
  static Pattern space = Pattern.compile("\\G\\s");  
  static Pattern number = Pattern.compile("\\G\\d+\\,?\\d*");
  static Pattern repetition = Pattern.compile("\\G\\b(\\w+)(\\b\\W+\\b\\1\\b)*");
  static Pattern multi = Pattern.compile("\\G(\\brumah sakit\\b|\\borang tua\\b|\\bbunga desa\\b|\\bair mata\\b)");
  static Pattern clitics_mu = Pattern.compile("([a-zA-Z]+)([mu]{2})");
  static Pattern clitics_nya = Pattern.compile("([a-zA-Z]+)([nya]{3}$)");
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
    List<String> list2 = new ArrayList<>();
    List<String> list3= new ArrayList<>();

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

    int size = list.size();
    for (int i=0; i<size; i++) {
        Matcher text = end.matcher(list.get(i)); 
        text.usePattern(clitics_nya);
            if(text.find() && list.get(i).length()>5) {
                if (text.group(2).equals("nya")){
                    list2.add (text.group(1));
                    list2.add ("-"+text.group(2));
                }else{
                    list2.add (list.get(i));               
                }
            }else{
                list2.add (list.get(i)); 
                
            }
    }
    
    int size2 = list2.size();
    for (int i=0; i<size2; i++) {
        Matcher text = end.matcher(list2.get(i)); 
        text.usePattern(clitics_mu);
            if(text.find() && list2.get(i).length()>=5) {
                if (text.group(2).equals("mu")){
                    list3.add (text.group(1));
                    list3.add (text.group(2));
                }else{
                    list3.add (list.get(i));               
                }
            }else{
                list3.add (list2.get(i)); 
                
            }
    }

    List<List<String>> a= new ArrayList<List<String>>();
    List<String> temp = new ArrayList<>();
    for (int i=0; i<list3.size(); i++) {
        temp.add(list3.get(i));
        if(list3.get(i).equals(".")){
            a.add(new ArrayList(temp));
            temp.clear();
        }
        
           
    }
//    for (int i=0; i<a.size(); i++) {
//        System.out.println("Sentence "+ (i+1));
//        System.out.println(a.get(i));
//        
//    }
    return a;

  }  
}