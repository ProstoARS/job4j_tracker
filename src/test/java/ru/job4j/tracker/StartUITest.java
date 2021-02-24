package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StabOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StabOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditItems(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StabOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItems(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StabOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "==== Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Output out = new StabOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("new Item1"));
        Item item2 = tracker.add(new Item("new Item2"));
        Input in = new StubInput(new String[]{"0", "1"});
        UserAction[] actions = {new ShowItems(out), new Exit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item1.getId()).toString() +
                System.lineSeparator() +
                tracker.findById(item2.getId()).toString(), is(item1.toString() +
                System.lineSeparator() + item2.toString()));
    }

    @Test
    public void whenFindById() {
        Output out = new StabOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("new Item"));
        item.setId(4);
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new FindItemsId(out), new Exit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).toString(), is(item.toString()));
    }

    @Test
    public void whenFindByName() {
        Output out = new StabOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("same item"));
        Item item2 = tracker.add(new Item("diss item"));
        Item item3 = tracker.add(new Item("same item"));
        Input in = new StubInput(new String[] {"0", "same item", "1"});
        UserAction[] actions = {new FindItemsName(out), new Exit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item1.getId()).toString() +
                System.lineSeparator() + tracker.findById(item3.getId()).toString(),
                is(item1.toString() + System.lineSeparator() + item3.toString()));

    }
}