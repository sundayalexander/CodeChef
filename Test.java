import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
    private static int[] result = null;
    private static int N;
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Get number of test cases.
        try {
            int T = Integer.parseInt(reader.readLine());
            int test = 0;

            //Loop for the number of test cases
            while (test < T){
                //Get number of chef fingers
                N = Integer.parseInt(reader.readLine());
                result = new int[2];
                //Length of chef fingers
                int[] L = new int[N];
                //Length of shealths of glove
                int[] G = new int[N];

                //Get cher fingers
                StringTokenizer lIn = new StringTokenizer(reader.readLine(), " ");
                StringTokenizer gIn = new StringTokenizer(reader.readLine(), " ");
                for (int i = 0; i < N; i++) {
                    L[i] = Integer.parseInt(lIn.nextToken());
                    G[i] = Integer.parseInt(gIn.nextToken());
                }
                front(L,G);
                back(L,G);
                if (result[0] == 1 && result[1] ==1){
                    System.out.println("both");
                }else if (result[0] == 1){
                    System.out.println("front");
                }else if (result[1] == 1){
                    System.out.println("back");
                }else {
                    System.out.println( "none");
                }
                test++;
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Front tracker method
     */
    public static void front(int[] L, int[] G){
        result[0] = 1;
        for(int i = 0; i<N; i++){
            if (L[i] > G[i]){
                result[0] = 0;
                return;
            }
        }
    }

    /**
     * back tracker method
     */
    public static void back(int[] L, int[] G){
        result[1] = 1;
        for(int i = 0; i<N; i++){
            if (L[i] > G[(N-1)-i]){
                result[1] = 0;
                return;
            }
        }
    }
}
