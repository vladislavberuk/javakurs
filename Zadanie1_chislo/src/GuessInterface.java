import java.util.Scanner;


public class GuessInterface {
    /**
     * Печатает просьбу о вводе числа.
     * Считывает число, проверяет что оно входит в диапазон [1...100]. Если не входит - то переспрашивает до победы.
     * Возвращает прочитанное число.
     */


    int askForNumber() {
        int s;
        do {
            System.out.println("Введите число");
            Scanner sc = new Scanner(System.in);
            s = sc.nextInt();

        } while (s < 1  | s > 100);
        return s;
    }

    /**
     * Выдаем сообщение о том, что задуманное число меньше
     */
    void printMessageIfLess() {
        System.out.println("Меньше") ;
    }

    /**
     * Выдаем сообщение о том, что задуманное число больше
     */
    void printMessageIfGreater() {
        System.out.println("Больше" + '\n') ;
    }

    void printWin() {
        System.out.println("Правильно" + '\n') ;
    }

    void printGameOver() {
        System.out.println("Игра окончена") ;
        }
}
