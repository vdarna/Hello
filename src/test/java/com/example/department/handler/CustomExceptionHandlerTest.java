package com.example.department.handler;

import com.example.department.exception.ErrorCode;
import com.example.department.exception.NotFoundException;
import com.example.department.exception.NotFoundException2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class CustomExceptionHandlerTest {

    private CustomExceptionHandler customExceptionHandlerUnderTest;

    @BeforeEach
    void setUp() {
        customExceptionHandlerUnderTest = new CustomExceptionHandler();
    }

    @Test
    void testHandleException() {
        // Setup
        final NotFoundException exception = new NotFoundException(ErrorCode.INVALID_INPUT, "message");
        final ResponseEntity<String> expectedResult = new ResponseEntity<>("body", HttpStatus.OK);

        // Run the test
        final ResponseEntity<String> result = customExceptionHandlerUnderTest.handleException(exception);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testHandleException2() {
        // Setup
        final NotFoundException2 exception = new NotFoundException2(ErrorCode.INVALID_INPUT, "message",
                new Exception("message"));
        final ResponseEntity<String> expectedResult = new ResponseEntity<>("body", HttpStatus.OK);

        // Run the test
        final ResponseEntity<String> result = customExceptionHandlerUnderTest.handleException2(exception);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
