package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(out),
                new Exit(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new EditItems(out),
                new Exit(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteItems(out),
                new Exit(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new Exit(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator() +
                        "==== Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("new Item1"));
        Item item2 = tracker.add(new Item("new Item2"));
        Input in = new StubInput(new String[]{"0", "1"});
        List<UserAction> actions = Arrays.asList(new ShowItems(out), new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
                + "==== Show all items ====" + ln
                + item1 + ln
                + item2 + ln
                + "Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
                + "==== Exit Program ====" + ln
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("new Item"));
        item.setId(4);
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = Arrays.asList(new FindItemsId(out), new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Find item by Id" + ln
                + "1. Exit Program" + ln
                + "==== Find item by Id ====" + ln
                + item + ln
                + "Menu." + ln
                + "0. Find item by Id" + ln
                + "1. Exit Program" + ln
                + "==== Exit Program ====" + ln
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("same item"));
        Item item2 = tracker.add(new Item("diss item"));
        Item item3 = tracker.add(new Item("same item"));
        Input in = new StubInput(new String[]{"0", "same item", "1"});
        List<UserAction> actions = Arrays.asList(new FindItemsName(out), new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(),
                is("Menu." + ln
                        + "0. Find item by name" + ln
                        + "1. Exit Program" + ln
                        + "==== Find item by name ====" + ln
                        + item1 + ln
                        + item3 + ln
                        + "Menu." + ln
                        + "0. Find item by name" + ln
                        + "1. Exit Program" + ln
                        + "==== Exit Program ====" + ln
                ));

    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"8", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new Exit(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit Program%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit Program%n"
                                + "==== Exit Program ====%n"
                )
        ));
    }
}