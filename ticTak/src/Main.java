import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        boolean empty, player1 = false, player2 = false;
        int i, j;
        String sign = "x";
        String yn1, yn2;

            do {
                System.out.println("Do you want that the first player will be a computer y /n");
                yn1 = input.next();
                System.out.println("Do you want that the second player will be a computer y /n");
                yn2 = input.next();
            } while (!((yn1.toLowerCase()).equals("n")) && !((yn1.toLowerCase()).equals("y")) && !((yn2.toLowerCase()).equals("n")) && !((yn2.toLowerCase()).equals("y")));

        ticTakToe.array();

        System.out.println();

            if (Objects.equals(yn1, "y")) {
                player1 = true;
                i = (int) (Math.random() * 2);
                j = (int) (Math.random() * 2);
                if(i == 1){
                    i += 1;
                }
                if (j == 1) {
                    j += 1;
                }
                ticTakToe.apply(i,j,sign);
                sign = ticTakToe.changePlayer(sign);
            }
            if (Objects.equals(yn2, "y")) {
                player2 = true;
            }


            do {
                if (player1 && sign.equals("x")) {
                    flag = ticTakToe.computer(sign);
                    sign = ticTakToe.changePlayer(sign);
                }
                if ((!player1 ||!player2) && !flag){
                do {

                    do {

                        System.out.println("please enter the i coordinate that you what");
                        i = input.nextInt();
                    } while (i < 0 || i >= 3);

                    do {
                        System.out.println("please enter the j coordinate that you what");
                        j = input.nextInt();
                    } while (j < 0 || j >= 3);

                    empty = ticTakToe.isEmpty(i, j);
                } while (!empty);
                    ticTakToe.apply(i, j, sign);
                    flag = ticTakToe.check(sign);
                    sign = ticTakToe.changePlayer(sign);
                }

                if (player2 && !flag && sign.equals("o")) {
                    flag = ticTakToe.computer(sign);
                    sign = ticTakToe.changePlayer(sign);
                }


            } while (!flag);



    }
}