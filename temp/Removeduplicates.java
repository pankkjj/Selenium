import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


public class Removeduplicates {
    static boolean flag=true;
    public static void main(String[] args) {
        
        ArrayList <Integer> A = new ArrayList<Integer>(Arrays.asList(1,1,1,3,2,8));
        while(flag){
            Map<Integer, Integer> m=maparray(A);
            A=ArrayfromMap(m);
            System.out.println(A);
        }
   
    }
   

    static Map<Integer, Integer> maparray(ArrayList<Integer> A){
        Map<Integer, Integer> mymap = new LinkedHashMap<>(0);
        for (int i = 0; i < A.size(); i++) {
          mymap.put(A.get(i), (mymap.getOrDefault(A.get(i),0) + 1));
        }
        return mymap;
    }


    static ArrayList<Integer> ArrayfromMap(Map<Integer,Integer> m){

        ArrayList <Integer> A =new ArrayList<>();
        boolean allone=true;

        for(Map.Entry<Integer,Integer> entry: m.entrySet()){
                if(entry.getValue()!=1){
                A.addLast(entry.getValue());
                allone=false;
                }
                else
                A.addLast(entry.getKey());
        }

        flag=allone?false:true;

      return A;
    }
     
    
}

