public class counthash {
    public static void main(String args[]) {
        int r=3,c=4;
        Character[][] arr = {
            {'#', '#', '#', '#'},
            {'#', '.', '#','.'},
            {'.', '.', '#','#'}
        };
        int maxcount=0;
        for(int i=0;i<r;i++)
        {
             int count=0;
            for(int j=0;j<c;j++)
            {
               
                if(arr[i][j]=='#'){
                    count++;
                } 
                if(count>maxcount){
                    maxcount=count;
                }
                if(arr[i][j]!='#'){
                   count=0;
                }
            }
        }
        System.out.println(maxcount);
    }

}
