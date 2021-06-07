package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        Output output = new StubOutput();
        UserAction[] actions = {
                new EditAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        Output output = new StubOutput();
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ls = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ls +
                        "0. Exit Program" + ls +
                        "=== Exit ====" + ls + ls
        ));
    }

    @Test
    public void whenShowAllAndEmptyStorage() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ls = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ls +
                        "0. Show all items" + ls +
                        "1. Exit Program" + ls +
                        "=== Show all items ====" + ls +
                        "Хранилище еще не содержит заявок" + ls + ls +
                        "Menu:" + ls +
                        "0. Show all items" + ls +
                        "1. Exit Program" + ls +
                        "=== Exit ====" + ls + ls
        ));
    }

    @Test
    public void whenShowAllAndNotEmptyStorage() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Item 1"));
        Item item2 = tracker.add(new Item("Item 2"));
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ls = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ls +
                        "0. Show all items" + ls +
                        "1. Exit Program" + ls +
                        "=== Show all items ====" + ls +
                        item1 + ls +
                        item2 + ls + ls +
                        "Menu:" + ls +
                        "0. Show all items" + ls +
                        "1. Exit Program" + ls +
                        "=== Exit ====" + ls + ls
        ));
    }

    @Test
    public void whenFindByIdAndNoItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ls = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ls +
                        "0. Find item by id" + ls +
                        "1. Exit Program" + ls +
                        "=== Find item by id ====" + ls +
                        "Заявка с введенным id: 1 не найдена." + ls + ls +
                        "Menu:" + ls +
                        "0. Find item by id" + ls +
                        "1. Exit Program" + ls +
                        "=== Exit ====" + ls + ls
        ));
    }

    @Test
    public void whenFindByIdAndItemFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ls = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ls +
                        "0. Find item by id" + ls +
                        "1. Exit Program" + ls +
                        "=== Find item by id ====" + ls +
                        item + ls + ls +
                        "Menu:" + ls +
                        "0. Find item by id" + ls +
                        "1. Exit Program" + ls +
                        "=== Exit ====" + ls + ls
        ));
    }

    @Test
    public void whenFindByNameAndNoItems() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        Tracker tracker = new Tracker();
        new StartUI(out).init(in, tracker, actions);
        String ls = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ls +
                        "0. Find items by name" + ls +
                        "1. Exit Program" + ls +
                        "=== Find items by name ====" + ls +
                        "Заявки с именем: Item не найдены." + ls + ls +
                        "Menu:" + ls +
                        "0. Find items by name" + ls +
                        "1. Exit Program" + ls +
                        "=== Exit ====" + ls + ls
        ));
    }

    @Test
    public void whenFindByNameAndItemsFound() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Item"));
        Item item2 = tracker.add(new Item("Fake"));
        Item item3 = tracker.add(new Item("Item"));
        new StartUI(out).init(in, tracker, actions);
        String ls = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ls +
                        "0. Find items by name" + ls +
                        "1. Exit Program" + ls +
                        "=== Find items by name ====" + ls +
                        item1 + ls +
                        item3 + ls + ls +
                        "Menu:" + ls +
                        "0. Find items by name" + ls +
                        "1. Exit Program" + ls +
                        "=== Exit ====" + ls + ls
        ));
    }
}
