package gameplay;

import gameplay.MoveOption;
import tile.Tile;
import board.*;
import java.util.*;
import region.*;

public abstract class Player {

  private Stack<Tiger> availableTigers;
  private Stack<Tiger> placedTigers;
  private int score;

  public void init(){
    placedTigers = new Stack<Tiger>();
    availableTigers = new Stack<Tiger>();
    score = 0;
    for(int i = 0; i<7; i++){
      availableTigers.add(new Tiger(this));
    }
  }

  //public abstract MoveOption chooseMove(Tile t, Board b);

  public abstract TigerOption chooseMove(Tile t, Board b);

  public abstract int chooseTigerPlacement();

  public void addScore(int score){
    this.score += score;
  }

  public Tiger giveTiger(){
    Tiger givenTiger = availableTigers.pop();
    placedTigers.add(givenTiger);
    return givenTiger;
  }

  public void reclaimTigers(Collection<Tiger> tigers){
    placedTigers.removeAll(tigers);
    availableTigers.addAll(tigers);
  }

  public HashMap<Region, Boolean> relevantRegions(){
    HashMap<Region, Boolean> relevantRegions = new HashMap<Region, Boolean>();
    for(Tiger tiger : placedTigers){
      relevantRegions.put(tiger.getRegion(), true);
    }
    return relevantRegions;
  }

  public String toString(){
    return "player- tigers left: "+availableTigers.size()+" score: "+Integer.toString(score);
  }



}