package first_iteration.object_oriented_design.jigsaw;


import java.util.LinkedList;

public class Puzzle {
    private LinkedList<Piece> pieces;
    private Piece[][] solution;

    private int size;

    public Puzzle(int size, LinkedList<Piece> pieces) {
        this.pieces = pieces;
        this.size = size;
        solution = new Piece[this.size][this.size];
    }

    /*Put piece into the solution, turn it appropriately, and remove from list.*/
    private void setEdgeInSolution(LinkedList<Piece> pieces, Edge edge, int row, int column, Orientation orientation) {
        Piece piece = edge.getParentPiece();
        piece.setEdgeAsOrientation(edge, orientation);
        pieces.remove(piece);
        solution[row][column] = piece;
    }

    private boolean fitNextEdge(LinkedList<Piece> piecesToSearch, int row, int column) {
        if (row == 0 && column == 0) { // On top left corner just put in a piece
            Piece p = piecesToSearch.remove();
            orientTopLeftCorner(p);
            solution[0][0] = p;
        } else {
            /*Get the right edge and list to match*/
            Piece pieceToMatch = column == 0 ? solution[row - 1][0] : solution[row][column - 1];
            Orientation orientationToMatch = column == 0 ? Orientation.BOTTOM : Orientation.RIGHT;

            Edge edgeToMatch = pieceToMatch.getEdgeWithOrientation(orientationToMatch);
            // Get matching edge
            Edge matchingEdge = getMatchingEdge(edgeToMatch, piecesToSearch);
            if (matchingEdge == null) { //Can't solve
                return false;
            }
            /*Insert piece and edge*/
            Orientation orientation = orientationToMatch.getOpposite();
            setEdgeInSolution(piecesToSearch, matchingEdge, row, column, orientation);
        }
        return true;
    }

    private Edge getMatchingEdge(Edge edgeToMatch, LinkedList<Piece> piecesToSearch) {
        return null;
    }

    private void orientTopLeftCorner(Piece p) {
    }

    public boolean solve() {
        LinkedList<Piece> cornerPieces = new LinkedList<>();
        LinkedList<Piece> borderPieces = new LinkedList<>();
        LinkedList<Piece> insidePieces = new LinkedList<>();
        groupPieces(cornerPieces, borderPieces, insidePieces);

        /*Walk through puzzle, finding the piece that joins the previous one. */
        solution = new Piece[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                LinkedList<Piece> piecesToSearch = getPieceListToSearch(cornerPieces, borderPieces, insidePieces, row,
                        column);
                if (!fitNextEdge(piecesToSearch, row, column)) {
                    return false;
                }
            }
        }

        return false;
    }

    private LinkedList<Piece> getPieceListToSearch(LinkedList<Piece> cornerPieces, LinkedList<Piece> borderPieces, LinkedList<Piece> insidePieces, int row, int column) {
        return null;
    }

    private void groupPieces(LinkedList<Piece> cornerPieces, LinkedList<Piece> borderPieces,
            LinkedList<Piece> insidePieces) {
    }
}
