package racing.view;


import java.util.Arrays;
import java.util.Scanner;

import static racing.domain.car.CarName.NAME_VALID_LENGTH;

public class InputView {
    private static final String NAME_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String NAME_VALIDATION_MESSAGE = "자동차 이름은 5글자를 초과할 수 없습니다.";
    private static final String NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?";
    private static final String NAME_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static String[] namesOfCar() {
        String[] namesOfCar = namesFromUser();
        while (inputInvalid(namesOfCar)) {
            print(NAME_VALIDATION_MESSAGE);
            namesOfCar = namesFromUser();
        }
        return namesOfCar;
    }

    public static int numberOfAttempts() {
        print(NUMBER_OF_ATTEMPTS);
        return inputNumber();
    }


    private static boolean inputInvalid(String[] namesOfCar) {
        return Arrays
                .stream(namesOfCar)
                .anyMatch(name -> name.length() > NAME_VALID_LENGTH);
    }

    private static String[] namesFromUser() {
        print(NAME_OF_CARS);
        return inputString().split(NAME_DELIMITER);
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static int inputNumber() {
        return scanner.nextInt();
    }

    private static String inputString() {
        return scanner.nextLine();
    }
}
