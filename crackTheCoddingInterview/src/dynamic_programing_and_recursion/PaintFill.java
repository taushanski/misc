package dynamic_programing_and_recursion;

public class PaintFill {

    enum Color {
        BLACK,
        WHITE,
        RED,
        YELLOW,
        GREEN
    }

    boolean paintFill(Color[][] screen, int r, int c, Color newColor) {
        if (screen[r][c] == newColor) {
            return false;
        }

        return paintFill(screen, r, c, screen[r][c], newColor);
    }

    private boolean paintFill(Color[][] screen, int r, int c, Color oldColor, Color newColor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
            return false;
        }

        if (screen[r][c] == oldColor) {
            screen[r][c] = newColor;
            paintFill(screen, r - 1, c, oldColor, newColor);// up
            paintFill(screen, r + 1, c, oldColor, newColor);//down
            paintFill(screen, r, c - 1, oldColor, newColor);//left
            paintFill(screen, r, c + 1, oldColor, newColor);//right
        }
        return true;

    }

}
