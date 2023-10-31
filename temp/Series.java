public class Series {
 public static void main(String[] args) {
      
     int n=1000;
     for(int i=0;i<n;i++){
          for(int j=0;j<10;j++){
               int value=i+j*10;
               if(value>n) break;
               System.out.print(value+" ");
               
          }
          System.out.println(" ");
     }


 }
 
}

//Print series
//    input:1000
// 1 10 100 1000 101 102 103 104 105 106 107 108 109
// 11 110 111 112 113 114 115 116 117 118 119
// 12 120 121 122 123 124 125 126 127 128 129  
// 13 130 131 132 133 134 135 136 137 138 139
//  static void Split(String a,int size){
//     int[] numbers=new int[size];
//     Character[] alphabets=new Character[size];

//    for(int i=0;i<size;i++){
    
//         Character c=a.charAt(i);

//         if(Character.isDigit(c)){
//         }
        
//         else{
            
//         }
//    }
//  }
//  static void Sort(int[] a,int size){

//  }
//  static void removeDuplicates(int[] a,int size){

//  }