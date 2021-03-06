import java.util.*;

public abstract class Player {

  public abstract MoveOption chooseMove(Tile t, Board b);

  public abstract int chooseMeeplePlacement(Slot s);

}
