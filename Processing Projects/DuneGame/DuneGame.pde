class UI
{
  public void drawHealth(int a, int b)
  {
  float percPlayer1 = (float)a / 100;
  float percPlayer2 = (float)b / 100;
  
  fill(255);
  textSize(32);
  text("Player 1", 50, 75);
  text("Player 2", 1025, 75);
  
  rect(50, 800, 500, 20, 7);
  rect(1150, 800, -500, 20, 7);
   
  fill(0, 230, 0);
  rect(50, 800, 500 * percPlayer1, 20, 7);
  rect(1150, 800, -500 * percPlayer2, 20, 7);
  }
}