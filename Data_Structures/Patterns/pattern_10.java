package Data_Structures.Patterns;

public class pattern_10 {
    public static void main(String[] args) {
        int n=5;
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n-1;j++){
                    System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
        }
            System.out.println();
        }
}
}

//     *****
//    *****
//   *****
//  *****
// *****