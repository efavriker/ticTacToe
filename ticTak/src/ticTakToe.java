import java.util.Objects;
import java.util.Scanner;

public class ticTakToe {
    static String [][] arr = new String[3][3];

    public static void array(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print("[");
                System.out.print(arr[i][j] = "---");
                System.out.print("]");
            }
            System.out.println();
        }
    }
    public static boolean isEmpty(int i,int j){
              if (!Objects.equals(ticTakToe.arr[i][j], "---")) {
            System.out.println(ticTakToe.arr[i][j] + " is conquering this squire try another squire");
            return false;
        }
        return true;
    }
    public static boolean computer(String w){
        int [] temp = new int[2];
        temp = strategy(w,w);
        apply(temp[0],temp[1],w);
        return check(w);
    }
    public static int[] strategy(String w,String z ){
        int o = 1;
        int p = 1;
        int [] ans = new int [2];
        int flag = 0;
        // backward diagonal
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][arr.length-1-i].equals(w)) {
                flag += 1;
                if (flag == 2 ){
                    for (int l = 0; l < arr.length; l++) {
                        if (Objects.equals(arr[l][arr.length-1-l], "---")) {
                            o = l;
                            p = arr.length-1-l;
                            ans [0]= o;
                            ans [1] =p;
                            return ans;
                        }
                    }

                }
            }
        }

        flag = 0;
        // diagonal
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][i].equals(w)){
                flag +=1;
                if (flag == 2 ){

                    for (int l = 0; l < arr.length; l++) {
                        if (Objects.equals(arr[l][l], "---")) {
                            o = l;
                            p = l;
                            ans [0]= o;
                            ans [1] =p;
                            return ans;
                        }
                    }

                }
            }
        }
        flag = 0;
        //Horizontal
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j].equals(w)) {
                    flag += 1;
                    if (flag == 2 ){

                        for (int l = 0; l < arr.length; l++) {
                            if (Objects.equals(arr[i][l], "---")) {
                                o = i;
                                p = l;
                                ans [0]= o;
                                ans [1] =p;
                                return ans;
                            }
                        }


                    }
                }
            }
            flag = 0;
        }
        //vertical
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i].equals(w)){
                    flag += 1;
                    if (flag == 2 ){

                        for (int l = 0; l < arr.length; l++) {
                            if (Objects.equals(arr[l][i], "---")) {
                                o = l;
                                p = i;
                                ans [0]= o;
                                ans [1] =p;
                                return ans;
                            }
                        }

                    }
                }
            }
            flag = 0;
        }
        if (Objects.equals(w,z)){
            return ans = strategy(changePlayer(w),w);
        }
        if (Objects.equals(arr[1][1], "---")){
            ans [0]= 1;
            ans [1] =1;
            return ans;
        }
        else if ((arr[0][0].equals(arr[arr.length-1][arr.length-1])&&(!arr[0][0].equals("---") && arr[0][0].equals(w)))|| (arr[0][arr.length-1].equals(arr[arr.length-1][0])&&(!arr[0][arr.length-1].equals("---") && arr[0][arr.length-1].equals(w)))) {
            while (!Objects.equals(arr[o][p], "---")) {
                o = (int) (Math.random() * 3);
                if (o == 0 ) {
                    p = 1;
                    ans[0] = o;
                    ans[1] = p;

                } else if (o ==1) {
                    if (Objects.equals(arr[o][0], "---")){
                        p = 0;
                        ans[0] = o;
                        ans[1] = p;
                        return ans;

                    }
                    else {
                        p = 2;
                        ans[0] = o;
                        ans[1] = p;
                    }
                }
                else{
                    p = 1;
                    ans[0] = o;
                    ans[1] = p;

                }
            }
            return ans;

        }
        else {
                while (!Objects.equals(arr[o][p], "---")){
                    o = (int) (Math.random() * 2);
                    if (o == 1){
                        o +=1;
                    }
                    p =(int)(Math.random()*2);
                    if (p == 1){
                        p +=1;
                    }
                }
                ans[0] = o;
                ans[1] = p;
        }
        return ans;

    }


    public static void print(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = (Objects.equals(arr[i][j], "---"))? "---" :arr[i][j];
                System.out.printf("[ %s ]",arr[i][j]);
            }
            System.out.println();
        }
    }
    public static String changePlayer(String w){
        w = (w.equals("x"))?"o":"x";

        return w ;
    }
    public static void apply(int i,int j,String w){
        arr[i][j] = w;
        print();


    }
    public static boolean check(String w) {
        String opp =(w.equals("x"))?"second":"first";
        String [] ans = new String[3];
        boolean istrue = false;
        int flag = 0;
        String win = "Congratulate "+ w +" is the winner";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][arr.length-1-i].equals(w)) {
                flag += 1;
                if (flag == 3 ){
                    System.out.println(win);
                    return istrue = true;
                }
            }
        }

        flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][i].equals(w)){
                flag +=1;
                if (flag ==3 ){
                    System.out.println(win);
                    return istrue = true;
                }
            }
        }
        flag = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j].equals(w)) {
                    flag += 1;
                    if (flag == 3) {
                        System.out.println(win);
                        return istrue = true;
                    }
                }
            }
            flag = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            flag = 0;
            for (String[] value : arr) {
                if (value[i].equals(w)){
                    flag += 1;
                    if (flag ==3 ){
                        System.out.println(win);
                        return istrue = true;
                    }

                }
            }
        }
        flag = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(!arr[i][j].equals("---")){
                    flag ++;
                    if(flag == 9){
                        System.out.println("it is a draw.");
                        return istrue = true;
                    }
                }
             }

        }


        System.out.println("Now it the "+opp+" opponent turn...");
        return istrue;
    }
}
