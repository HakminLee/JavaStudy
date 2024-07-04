package ch15.sec06.exam01;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Coin {
    private int value;

//    AllArgsConstructor 와 동일하다
//    public Coin(int value) {
//        this.value = value;
//    }
    //@Getter와 동일하다
//    public int getValue() {
//        return value;
//    }
}
