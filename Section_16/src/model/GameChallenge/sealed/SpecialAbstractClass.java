package model.GameChallenge.sealed;

public sealed class SpecialAbstractClass permits SpecialAbstractClass.Kid, SealedKid, nonSealedKid, FinalKid{

    final class Kid extends SpecialAbstractClass{

    }

}
