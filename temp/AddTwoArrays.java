public class AddTwoArrays {
	static int[] A={1,2,3,4,5};
    static int[] B={6,7,8};
	   public static void main(String[] args) {
		
		int n=A.length;
        int x=B.length-1;
		int[] C =new int[n];
		int carry=0;
	     for(int i=n-1;i>=0;i--){
			if(x>=0){
               int sum=A[i]+B[x]+carry;
			   C[i]=sum%10;
			   carry=sum/10;

			}
            else{
				int sum=A[i]+carry;
				C[i]=sum%10;
				carry=sum/10;
			}
			  
			x--;

		 }

		 for(int i=0;i<C.length;i++){
             System.out.print(C[i]);
		 }
         
	   }
}
