import java.util.function.Function;
import java.util.function.Predicate;

class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {

        Predicate<Boolean> isAwake = s -> s.equals(knightIsAwake);

        if (isAwake.test(true))
            return false;
        return true;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {

        Predicate<Boolean> canSpy = s -> knightIsAwake || archerIsAwake || prisonerIsAwake;

        if (canSpy.test(true))
            return true;
        return false;

    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {

        if (archerIsAwake == true && prisonerIsAwake == true || prisonerIsAwake == false)
            return false;
        return true;

    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {

        if (archerIsAwake) {
            return false;
        } else if (petDogIsPresent) {
            return true;
        } else if (knightIsAwake && prisonerIsAwake) {
            return false;
        } else if (prisonerIsAwake) {
            return true;
        } else if (knightIsAwake && archerIsAwake && prisonerIsAwake && petDogIsPresent) {
            return true;
        } else if (!(knightIsAwake && archerIsAwake && prisonerIsAwake && petDogIsPresent)) {
            return false;
        } else if (knightIsAwake && archerIsAwake && prisonerIsAwake || petDogIsPresent) {
            return true;
        } else if (knightIsAwake && (petDogIsPresent || prisonerIsAwake)) {
            return false;
        } else if (knightIsAwake || (prisonerIsAwake && petDogIsPresent)) {
            return true;
        } else if (!(knightIsAwake && prisonerIsAwake) && petDogIsPresent) {
            return false;
        }
        return true;
    }
}
