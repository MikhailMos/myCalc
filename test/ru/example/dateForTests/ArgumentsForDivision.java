package ru.example.dateForTests;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.example.entities.MyExpression;

import java.util.stream.Stream;

public class ArgumentsForDivision implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new MyExpression(4.0, 2.0, "/"), 2.0),
                Arguments.of(new MyExpression(-4.0, 2.0, "/"), -2.0),
                Arguments.of(new MyExpression(4.0, -2.0, "/"), -2.0),
                Arguments.of(new MyExpression(-4.0, -2.0, "/"), 2.0),
                Arguments.of(new MyExpression(0.0, 2.0, "/"), 0.0)
        );
    }
}
