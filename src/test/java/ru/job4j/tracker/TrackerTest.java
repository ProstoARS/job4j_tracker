package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        Item bog = new Item();
        bog.setName("Bog");
        Item big = new Item();
        big.setName("Big");
        Item lag = new Item();
        lag.setName("lag");
        Item lox = new Item();
        lox.setName("lox");
        Item lom = new Item();
        lom.setName("lom");
        tracker.add(bug);
        tracker.add(bog);
        tracker.add(big);
        tracker.add(lag);
        tracker.add(lox);
        tracker.add(lom);
        int id = bog.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}