package org.dreborier.shared;

import org.dreborier.shared.CodeMoveTeamMatcher.Team;

public class CodeMoveTeamMatcher {

    public static enum Team {
        RED, BLUE
    };

    public static enum Move {
        UP, DOWN
    };

    public static String getCodeOfTheMove(Team team, Move move) {
        if (team.equals(Team.RED) && move.equals(Move.UP)) {
            return "0";
        } else if (team.equals(Team.RED) && move.equals(Move.DOWN)) {
            return "1";
        } else if (team.equals(Team.BLUE) && move.equals(Move.UP)) {
            return "2";
        } else {
            return "3";
        }
    }

    public static Team getTeamFromCode(String code) {
        if (code.equals("0") || code.equals("1"))
            return Team.RED;
        else
            return Team.BLUE;
    }
    
    public static Move getMoveFromCode(String code) {
        if (code.equals("0") || code.equals("2"))
            return Move.UP;
        else
            return Move.DOWN;
    }


}
