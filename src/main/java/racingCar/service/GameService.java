package racingCar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import racingCar.model.Car;
import racingCar.model.RacingCarHistory;
import racingCar.model.Track;
import racingCar.model.Winners;
import racingCar.strategy.CarMoveRandomStrategy;

public class GameService {

  private final static Track TRACK = new Track();

  public List<Car> readyCars(String names) {
    TRACK.addCar(names);
    return TRACK.getCars();
  }

  public Integer gameRound(Integer rounds) {
    return rounds;
  }

  public List<RacingCarHistory> play(List<Car> allCars, Integer rounds) {
    List<RacingCarHistory> printCars = new ArrayList<>();
    for (Car car : allCars) {
      addRacingHistory(rounds, printCars, car);
    }
    return printCars;
  }

  private void addRacingHistory(Integer rounds, List<RacingCarHistory> printCars, Car car) {
    for (int i = 0; i < rounds; i++) {
      car = car.move(new CarMoveRandomStrategy());
      printCars.add(new RacingCarHistory(i + 1, car));
    }
  }

  public List<Car> gameResult(List<RacingCarHistory> racingHistories,
      Integer rounds) {
    List<Car> resultList = new ArrayList<>();
    for (RacingCarHistory racingHistory : racingHistories) {
      sameRoundResult(rounds, resultList, racingHistory);
    }
    return resultList;
  }

  public List<String> findWinnerNames(List<Car> candidates) {
    List<String> coWinnerNameList = new Winners(candidates).findWinnerNameList();
    coWinnerNameList.removeAll(Collections.singletonList(null));
    return coWinnerNameList;
  }

  private void sameRoundResult(Integer rounds, List<Car> resultList,
      RacingCarHistory racingHistory) {
    if (Objects.equals(racingHistory.round(), rounds)) {
      resultList.add(racingHistory.car());
    }
  }

}