import fisica.*;

Model model;

public boolean[] pressed;
final static int W=0, A=1, S=2, D=3;

void setup() {
  size(1200, 900);
  frameRate(30);

  Fisica.init(this);
  model = new Model();
  
  pressed = new boolean[4];
}

void draw() {
  background(240);
  
  model.world.step();
  
  model.player1.draw(this);
  model.world.draw(this);
}

void keyPressed() {
  if (key == 'w' || key == 'W') pressed[W] = true; //W
  if (key == 'a' || key == 'A') pressed[A] = true; //A
  if (key == 's' || key == 'S') pressed[S] = true; //S
  if (key == 'd' || key == 'D') pressed[D] = true; //D
}

void keyReleased() {
  if (key == 'w' || key == 'W') pressed[W] = false; //W
  if (key == 'a' || key == 'A') pressed[A] = false; //A
  if (key == 's' || key == 'S') pressed[S] = false; //S
  if (key == 'd' || key == 'D') pressed[D] = false; //D
}