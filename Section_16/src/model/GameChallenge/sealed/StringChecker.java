package model.GameChallenge.sealed;

import java.util.function.Predicate;

public final class StringChecker implements SealedInterFace{


    @Override
    public boolean testData(Predicate<String> p, String... strings) {
        return false;
    }
}
