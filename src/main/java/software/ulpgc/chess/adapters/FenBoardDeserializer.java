package software.ulpgc.chess.adapters;

import software.ulpgc.chess.domain.model.Board;
import software.ulpgc.chess.domain.model.Piece;
import software.ulpgc.chess.domain.model.Square;
import software.ulpgc.chess.ports.BoardDeserializer;

import java.util.HashMap;
import java.util.Map;

public class FenBoardDeserializer implements BoardDeserializer {

    // Significado letras notación FEN
    private static final Map<Character, Piece> PIECES = Map.ofEntries(
            Map.entry('P', Piece.WhitePawn),
            Map.entry('R', Piece.WhiteRook),
            Map.entry('N', Piece.WhiteKnight),
            Map.entry('B', Piece.WhiteBishop),
            Map.entry('Q', Piece.WhiteQueen),
            Map.entry('K', Piece.WhiteKing),
            Map.entry('p', Piece.BlackPawn),
            Map.entry('r', Piece.BlackRook),
            Map.entry('n', Piece.BlackKnight),
            Map.entry('b', Piece.BlackBishop),
            Map.entry('q', Piece.BlackQueen),
            Map.entry('k', Piece.BlackKing)
    );

    @Override
    public Board deserialize(String value) {
        return deserialize(value.split(" ")[0].split("/"));
    }

    private Board deserialize(String[] ranks) {
        return new Board(piecesIn(ranks));
    }

    // Analiza todas las filas
    private Map<Square, Piece> piecesIn(String[] ranks) {
        Map<Square, Piece> map = new HashMap<>();
        int j = 8;
        for (String rank : ranks)
            map.putAll(piecesIn(j--, rank.toCharArray()));
        return map;
    }

    // Analiza una única fila
    private Map<Square, Piece> piecesIn(int j, char[] rank) {
        Map<Square, Piece> map = new HashMap<>();
        int i = 1;
        for (char order : rank) {
            if (Character.isDigit(order)) {
                i += order - '0';
            } else {
                Square square = Square.at("" + (char) ('a' + i - 1) + j);
                map.put(square, PIECES.get(order));
                i++;
            }
        }
        return map;
    }
}
