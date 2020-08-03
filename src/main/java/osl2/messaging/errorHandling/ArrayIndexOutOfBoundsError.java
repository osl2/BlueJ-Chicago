package osl2.messaging.errorHandling;

public class ArrayIndexOutOfBoundsError implements UserError {
    private static final int MIN_INDEX = 0;

    private final int userIndex;
    private final int maxIndex;
    private final String name = "ArrayIndexIndexOutOfBounds";

    public ArrayIndexOutOfBoundsError(int userIndex, int maxIndex) {
        this.userIndex = userIndex;
        this.maxIndex = maxIndex;
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return "UserIndex: " + userIndex + "\n" + "Min/Max Index: [" + MIN_INDEX + "," + maxIndex + "]";
    }
}
