import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ru.AviaSouls;
import ru.netology.ru.Ticket;
import ru.netology.ru.TicketTimeComparator;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void ShouldcompareToMin(){
        Ticket ticket = new Ticket("Москва","Санкт Петербург",5_000, 21_00, 23_00);
        Ticket ticket1 = new Ticket("Москва","Санкт Петербург",7_000, 17_00, 18_30);


        int expected = -1;
        int actual = (ticket.compareTo(ticket1));

        Assertions.assertEquals(expected,actual);


    }
    @Test
    public void ShouldcompareToMax() {
        Ticket ticket = new Ticket("Москва", "Санкт Петербург", 7_000, 21_00, 23_00);
        Ticket ticket1 = new Ticket("Москва", "Санкт Петербург", 5_000, 17_00, 18_30);


        int expected = 1;
        int actual = (ticket.compareTo(ticket1));

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void ShouldcompareToEquals() {
        Ticket ticket = new Ticket("Москва", "Санкт Петербург", 7_000, 21_00, 23_00);
        Ticket ticket1 = new Ticket("Москва", "Санкт Петербург", 7_000, 17_00, 18_30);


        int expected = 0;
        int actual = (ticket.compareTo(ticket1));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSearchWithPriceSort() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва","Санкт Петербург",5_000,21_00,23_00);
        Ticket ticket2 = new Ticket("Москва","Санкт Петербург", 7_000, 17_00, 18_30);
        Ticket ticket3 = new Ticket("Москва","Санкт Петербург", 6_000, 11_00, 13_00);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] result = aviaSouls.search("Москва", "Санкт Петербург");
        Ticket[] expected = {ticket1, ticket3, ticket2}; // упорядоченные по цене

        Assertions.assertArrayEquals(expected, result);
    }
    @Test
    public void ShouldsearchAndSortBy(){
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва","Санкт Петербург",5_000,21_00,23_00);
        Ticket ticket2 = new Ticket("Москва","Санкт Петербург", 7_000, 17_00, 18_30);
        Ticket ticket3 = new Ticket("Москва","Санкт Петербург", 6_000, 11_00, 13_00);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual= aviaSouls.searchAndSortBy("Москва", "Санкт Петербург", comparator);
        Ticket[] expected = {ticket2, ticket1, ticket3};
    }
}
