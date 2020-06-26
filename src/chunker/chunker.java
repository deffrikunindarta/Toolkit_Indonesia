/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chunker;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.IOException;

/**
 *
 * @author deffri
 */
public class chunker {
 

public List<List<String>> tag_border(List<String> list1,List<String> list2){
    List<String> tag = list1;
    List<String> word= list2;
    List<List<String>> a= new ArrayList<List<String>>();
    List<String> temp = new ArrayList<>();
    for (int i=0; i<  tag.size() ; i++) {
        if ((tag.get(i).equals("NNP")&&tag.get(i+1).equals("NNP"))|(tag.get(i).equals("NN")&&tag.get(i+1).equals("VB"))|(tag.get(i).equals("CD")&&tag.get(i+1).equals("NN"))){
            temp.add(tag.get(i));
            temp.add(tag.get(i+1));
            i=i+1;
        }else{
            temp.add(tag.get(i));
            a.add(temp); 

        }
        a.add(new ArrayList(temp));
        temp.clear();

    }
    a.removeIf(x -> x != null && x.isEmpty());
    System.out.println(a);
    return a;

}
public List<List<String>> word_border(List<String> list1,List<String> list2){
    List<String> tag = list1;
    List<String> word= list2;
    List<List<String>> a= new ArrayList<List<String>>();
    List<String> temp = new ArrayList<>();
    for (int i=0; i<  tag.size() ; i++) {
        if ((tag.get(i).equals("NNP")&&tag.get(i+1).equals("NNP"))|(tag.get(i).equals("NN")&&tag.get(i+1).equals("VB"))|(tag.get(i).equals("CD")&&tag.get(i+1).equals("NN"))){
            temp.add(word.get(i));
            temp.add(word.get(i+1));
            i=i+1;
        
        }else{
            temp.add(word.get(i));
            a.add(temp);
        }
        a.add(new ArrayList(temp));
        temp.clear();


    
    }
    a.removeIf(x -> x != null && x.isEmpty());
    System.out.println(a);
    return a;

}

public static void main(String args[]) { 
    
    List myList = new ArrayList();
    List<String> tag = Arrays.asList("NNP", "NNP", "Z", "NN", "NNP", "NNP", "NNP", "NNP", "Z", "IN", "CD", "NN", "NN", "MD", "VB", "NN", "PRP", "IN", "NNP", "Z", "SC", "MD", "VB", "NNP", "IN", "RB", "MD", "VB", "VB", "NN", "Z", "SC", "VB", "NN", "IN", "NN", "NN", "NN", "CC", "NN", "SC", "NNP", "VB", "VB", "NN", "Z");
    List<String> word = Arrays.asList("pemerintah", "as", ",", "pimpinan", "presiden", "george", "w.", "bush", ",", "dalam", "beberapa", "pekan", "belakangan", "telah", "meningkatkan", "pendirian", "-nya", "terhadap", "iran", ",", "yang", "telah", "dituduh", "barat", "secara", "diam-diam", "sedang", "berusaha", "membuat", "bom atom", ",", "sehingga", "meningkatkan", "kekhawatiran", "di", "kalangan", "pemimpin", "usaha", "dan", "politik", "bahwa", "as", "berencana", "melancarkan", "serangan", ".");
    chunker tag_chunk = new chunker();
    chunker word_chunk = new chunker();
    tag_chunk.tag_border(tag,word);
    word_chunk.word_border(tag,word);



 
    }


}
