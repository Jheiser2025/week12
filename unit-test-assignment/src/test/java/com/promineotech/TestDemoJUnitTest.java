package com.promineotech;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import com.prominotech.TestDemo;

public class TestDemoJUnitTest {
    private TestDemo testDemo;

    @BeforeEach
    void setUp() {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
            arguments(2, 4, 6, false),
            arguments(1, 1, 2, false),
            arguments(-1, 2, 1, true),
            arguments(0, 2, 2, true),
            arguments(3, 3, 6, false)
        );
    }
    
    
	@Test
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {

        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
        assertThat(testDemo.addPositive(10, 20)).isEqualTo(30);
        assertThat(testDemo.addPositive(3, 7)).isEqualTo(10);
        assertThat(testDemo.addPositive(100, 200)).isEqualTo(300);
        
	}
        @Test

       void assertThatPairsOfPositiveNumbersAreMultipliedCorrectly() {
            // Test cases for multiplyPositive
           assertThat(testDemo.multiplyPositive(2, 3)).isEqualTo(6);
            assertThat(testDemo.multiplyPositive(4, 5)).isEqualTo(20);
        assertThat(testDemo.multiplyPositive(6, 7)).isEqualTo(42);
            assertThat(testDemo.multiplyPositive(8, 9)).isEqualTo(72);
          assertThat(testDemo.multiplyPositive(10, 11)).isEqualTo(110);
        
	}
    	@Test
    	
      void assertThatNumberSquaredIsCorrect() {
            // Create a mock of the TestDemo object
           TestDemo mockDemo = spy(testDemo);

            // Program the mocked TestDemo object to return 5 when getRandomInt is called
        doReturn(5).when(mockDemo).getRandomInt();

            // Call the method randomNumberSquared on the mocked TestDemo object
          int fiveSquared = mockDemo.randomNumberSquared();

            // Assert that the result is 25
        assertThat(fiveSquared).isEqualTo(25);
    }
}
