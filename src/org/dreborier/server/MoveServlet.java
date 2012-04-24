package org.dreborier.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dreborier.shared.CodeMoveTeamMatcher;
import org.dreborier.shared.CodeMoveTeamMatcher.Move;
import org.dreborier.shared.CodeMoveTeamMatcher.Team;

@SuppressWarnings("serial")
public class MoveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Game game = new Game();
        String code = req.getParameter("code");
        Team team = CodeMoveTeamMatcher.getTeamFromCode(code);
        Move move = CodeMoveTeamMatcher.getMoveFromCode(code);
        game.sendUpdateToConsole(team, move);
    }
}
