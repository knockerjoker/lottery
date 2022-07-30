package changer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lottery.lottoBalls;

public class typeChanger {
    public static List <lottoBalls> ballsToIntList(String balls){
        return Arrays.stream(balls.split(","))
                      .map(lottoBalls::new)
                      .collect(Collectors.toList());
    }
}
