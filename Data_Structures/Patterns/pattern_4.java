package Data_Structures.Patterns;

public class pattern_4 {
    public static void main(String[] args) {
        int n=3;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


// *********
// ********
// *******
// ******
// *****
// ****
// ***
// **
// *