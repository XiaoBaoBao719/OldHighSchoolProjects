
class Buggy extends FCompound {
  
  PVector dimensions;
  
  public Buggy() {
    dimensions = new PVector(40, 80);
    
    
    setBullet(true);
    setDamping(1);
    setAngularDamping(1);
    setDensity(0.1);
    setRotation(radians(180)); //Rotate Properly
    
    createBody();
  }
  
  void createBody() {
    FBox a = new FBox(dimensions.x, dimensions.y);
    addBody(a);
  }
  
  
}