package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket(
            "SVO", "IKT", 18_000, 8, 14);
    Ticket ticket2 = new Ticket(
            "SVO", "IKT", 15_000, 8, 13);
    Ticket ticket3 = new Ticket(
            "SVO", "IKT", 7_500, 8, 12);
    Ticket ticket4 = new Ticket(
            "SVO", "AER", 7_500, 8, 12);
    Ticket ticket5 = new Ticket(
            "DME", "IKT", 12_000, 8, 15);

    @Test
    public void findAll() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = avia.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void compareToTest1() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        int expected = ticket1.compareTo(ticket2);
        int actual = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void compareToTest2() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        int expected = ticket3.compareTo(ticket2);
        int actual = -1;

    }

    @Test
    public void compareToTest3() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        int expected = ticket3.compareTo(ticket4);
        int actual = 0;

    }


    @Test
    public void searchTest() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {ticket3, ticket2, ticket1};
        Ticket[] actual = avia.search("SVO", "IKT");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ticketTimeComparatorTest1() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = timeComparator.compare(ticket1, ticket5);
        int actual = -1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ticketTimeComparatorTest2() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = timeComparator.compare(ticket3, ticket4);
        int actual = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ticketTimeComparatorTest3() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = timeComparator.compare(ticket1, ticket2);
        int actual = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchComparatorTest() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3, ticket2, ticket1};
        Ticket[] actual = avia.searchAndSortBy("SVO", "IKT", timeComparator);
        Assertions.assertArrayEquals(expected, actual);

    }

}