package Data_Structures.Patterns;

public class pattern_8 {
    public static void main(String[] args) {
        int n=15;
        int c=1;
        for(int i=1;c<=n;i++){
            for(int j=1;j<=i;j++){
                   if(c>=n+1){
                    break;
                   }
                    System.out.print(c++ +"    ");
            }
            System.out.println();;

        }
}
}

// 1    
// 2    3    
// 4    5    6    
// 7    8    9    10    
// 11    12    13    14    15    