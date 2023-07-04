package Data_Structures.Patterns;

public class pattern_9 {
    public static void main(String[] args) {
        int n=5;
        int c=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                    c=c==1 ? 0 : 1;
                    System.out.print(c+" ");
            }
            System.out.println();;

        }
    }
}
