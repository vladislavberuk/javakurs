import java.util.Random;


public class GuessLogic {
    private int secretNumber;
    GuessInterface userInterface = new GuessInterface();

    /**
     * Загадаывает секретное число и сохраняет его в поле secretNumber.
     */

    // System.out.println("Случайное число: " + secretNumber);


    int generateSecretNumber() {
        Random r = new Random();
        secretNumber = 1 + r.nextInt(100);
        return secretNumber;
    }
    /**
     * Сравнивает загаданное число и секретное число.
     * Возвращет 0, если загаданное число больше совпало
     * Возвращает -1, если загаданное число меньше
     * Возвращает 1, если загаданное число больше.
     *
     * Для продвинутых: возвращать экземляр перечислимого типа (enum).
     */
    int compareWithSecretNumber(int guessedNumber) {
        if ( guessedNumber == secretNumber) {
            userInterface.printWin();
            return 0;
        }
        else if ( guessedNumber < secretNumber) {
            userInterface.printMessageIfLess();
            return -1;
        }else {
            userInterface.printMessageIfGreater();
            return 1;
        }
        //System.out.println("Случайное число: " + secretNumber);
    }

    /**
     * В цикле проверяет число и взаимодействует с пользователем.
     */
    void work() {
        for(int i = 0; i < 8; ++i) {
            int s = userInterface.askForNumber();
            int rezultat = compareWithSecretNumber(s);

            if( rezultat == 0){
                userInterface.printGameOver();
                break;
            }
            if (i==7){
                userInterface.printGameOver();
            }

        }
    }


}
