package software.ulpgc.chess.domain.model;

import static software.ulpgc.chess.domain.model.Color.Black;
import static software.ulpgc.chess.domain.model.Color.White;

public enum Piece {
    WhitePawn,
    WhiteRook,
    WhiteKnight,
    WhiteBishop,
    WhiteKing,
    WhiteQueen,
    BlackPawn,
    BlackRook,
    BlackKnight,
    BlackBishop,
    BlackKing,
    BlackQueen;

    Color color(){
        return isWhite() ? White : Black;
    }

    boolean isPawn(){
        return this == WhitePawn || this == BlackPawn;
    }

    boolean isRook(){
        return this == WhiteRook || this == BlackRook;
    }

    boolean isKnight(){
        return this == WhiteKnight || this == BlackKnight;
    }

    boolean isQueen(){
        return this == WhiteQueen || this == BlackQueen;
    }

    boolean isKing(){
        return this == WhiteKing || this == BlackKing;
    }

    boolean isBishop(){
        return this == WhiteBishop || this == BlackBishop;
    }

    private boolean isWhite(){
        return this == WhitePawn ||
                this == WhiteBishop ||
                this == WhiteKing ||
                this == WhiteRook ||
                this == WhiteQueen ||
                this == WhiteKnight;
    }

}