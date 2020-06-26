package pipeline;


import tokenizer_indonesia.Tokenizer_Indonesia_withClitics;
import tokenizer_indonesia.Tokenizer_Indonesia_withoutClitics;
import postag_indonesia.postag_indonesia;
////

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class pipeline{



public static void main(String args[]) throws Exception {
        List<List<String>> temp = new ArrayList<>();
        List<String> list = new ArrayList<>(); 
        String test = "Ada beberapa macam ragam jenis artikel, seperti halnya dengan artikel ilmiah, pendidikan, populer, kesehatan hingga artikel yang membahas tentang penelitian, dan tentunya masih banyak lagi terkait jenis-jenis artikel yang lainnya. Sebelum masuk kepembahasan terkait contoh artikel, alangkah baiknya untuk Anda simak dahulu mengenai pengertian artikel dan ciri-ciri artikel itu sendiri.";
        Tokenizer_Indonesia_withClitics token = new Tokenizer_Indonesia_withClitics();
        temp = token.test(test);
        postag_indonesia postag = new postag_indonesia();
        System.out.println(temp);
        list = postag.test(temp);
        

                
            
        

    }

}