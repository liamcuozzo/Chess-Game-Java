public class Spot {
    private Piece piece;
    private int x,y;

    public Spot(int x, int y, Piece piece){
        setX(x);
        setY(y);
        setPiece(piece);
    }

    public int getX(){return this.x;}
    public int getY(){return this.y;}

    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}

    public Piece getPiece() throws NullPointerException {return this.piece;}
    public void setPiece(Piece piece){this.piece = piece;}
}
