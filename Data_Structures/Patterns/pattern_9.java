package Data_Structures.Patterns;

public class pattern_9 {
    public static void main(String[] args) {
        int n=6;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                   if(j<=i)
                   System.out.print("*");
                   else
                   System.out.print(" ");
            }
            for(int j=n;j>=1;j--){
                if(j<=i)
                System.out.print("*");
                else
                System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                   if(j<=i)
                   System.out.print("*");
                   else
                   System.out.print(" ");
            }
            for(int j=n;j>=1;j--){
                if(j<=i)
                System.out.print("*");
                else
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

// *          *
// **        **
// ***      ***
// ****    ****
// *****  *****
// ************
// ************
// *****  *****
// ****    ****
// ***      ***
// **        **
// *          *