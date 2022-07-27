import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lottery.lottoBalls;

public class typeChanger {
    public List <lottoBalls> ballsToIntList(String balls){
        return Arrays.stream(balls.split(","))
                      .map(lottoBalls::new)
                      .collect(Collectors.toList());
    }
}
