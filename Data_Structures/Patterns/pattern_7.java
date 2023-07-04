package Data_Structures.Patterns;

public class pattern_7 {
    public static void main(String[] args) {
        int n=10;
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                    System.out.print(j+" ");
                
            }
            System.out.println();
        }
}
}

// 1 2 3 4 5 6 7 8 9 10 
// 1 2 3 4 5 6 7 8 9 
// 1 2 3 4 5 6 7 8 
// 1 2 3 4 5 6 7 
// 1 2 3 4 5 6 
// 1 2 3 4 5 
// 1 2 3 4 
// 1 2 3 
// 1 2 
// 1 