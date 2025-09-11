package model.GameChallenge.sealed;

import java.util.function.Predicate;

public sealed interface SealedInterFace permits BetterInterFace, StringChecker {

    boolean testData(Predicate<String> p, String... strings);
}
