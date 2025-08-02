package model.lambdaExpressions;

// not including this could break code in the future if someone extends the interface with other abstract methods
@FunctionalInterface
public interface Operation<T> {

    T operate(T value1, T value2);


}
