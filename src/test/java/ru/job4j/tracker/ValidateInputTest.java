package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenNegativeValueInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }

    @Test
    public void whenMoreValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "1", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected1 = input.askInt("Enter menu:");
        String selected2 = input.askStr("Enter name:");
        int selected3 = input.askInt("Enter id:");
        assertThat(selected1, is(1));
        assertThat(selected2, is("1"));
        assertThat(selected3, is(1));
    }
}