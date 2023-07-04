package Data_Structures.Patterns;

public class pattern_3 {
    public static void main(String[] args) {
        int n=4;
        int m=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1)
                System.out.print("* ");
                else if(j==0 || j==m-1)
                System.out.print("* ");
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
