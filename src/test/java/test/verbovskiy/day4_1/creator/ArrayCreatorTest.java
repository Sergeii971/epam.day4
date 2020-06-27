package test.verbovskiy.day4_1.creator;

import com.verbovskiy.day4_1.creator.ArrayCreator;
import com.verbovskiy.day4_1.exception.TaskException;
import com.verbovskiy.day4_1.validator.ArrayValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCreatorTest {
    ArrayCreator arrayCreator;

    @BeforeClass
    public void setUp() {
        arrayCreator = new ArrayCreator();
    }

    @Test(expectedExceptions = TaskException.class)
    public void createAndFillArrayRandomExceptionTest() throws TaskException {
        arrayCreator.createAndFillArrayRandom(0);
    }
}