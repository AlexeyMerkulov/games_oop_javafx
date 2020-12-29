package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPositionA2() {
        Figure figure = new BishopBlack(Cell.A2);
        Cell rsl = figure.position();
        assertThat(rsl, is(Cell.A2));
    }

    @Test
    public void whenCopyToH3() {
        Figure actualBishopBlack = new BishopBlack(Cell.B1);
        Figure copiedBishopBlack = actualBishopBlack.copy(Cell.H3);
        assertThat(copiedBishopBlack.position(), is(Cell.H3));
    }

    @Test
    public void whenWayFromC1ToG5() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.way(Cell.G5), is(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenThrowImpossibleMoveException() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.G1);
        bishopBlack.way(Cell.G2);
    }

    @Test
    public void whenNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G1);
        boolean rsl = bishopBlack.isDiagonal(Cell.G1, Cell.F4);
        assertThat(rsl, is(false));
    }

    @Test
    public void whenIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G1);
        boolean rsl = bishopBlack.isDiagonal(Cell.G1, Cell.F2);
        assertThat(rsl, is(true));
    }


}