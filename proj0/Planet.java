public class Planet {
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;
  
  private static final double GRAVITY_CONSTANT = 6.67e-11;

  public Planet(double xP, double yP, double xV,
      double yV, double m, String img) {
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;
  }

  public Planet(Planet p) {
    xxPos = p.xxPos;
    yyPos = p.yyPos;
    xxVel = p.xxVel;
    yyVel = p.yyVel;
    mass = p.mass;
    imgFileName = p.imgFileName;
  }

  public double calcDistance(Planet p) {
    double distance = (this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) +
        (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos);
    return Math.sqrt(distance);
  }

  public double calcForceExertedBy(Planet p) {
    double distance = this.calcDistance(p);
    double force = GRAVITY_CONSTANT * this.mass * p.mass / (distance * distance);
    return force;
  }

  public double calcForceExertedByX(Planet p) {
    double force = this.calcForceExertedBy(p);
    double distance = this.calcDistance(p);
    double xforce = force * (p.xxPos - this.xxPos) / distance;
    return xforce;
  }

  public double calcForceExertedByY(Planet p) {
    double force = this.calcForceExertedBy(p);
    double distance = this.calcDistance(p);
    double yforce = force * (p.yyPos - this.yyPos) / distance;
    return yforce;
  }

  public double calcNetForceExertedByX(Planet[] allPlanets) {
    double netForceX = 0;
    for (Planet p : allPlanets) {
      if (this.equals(p)) {
        continue;
      }
      netForceX += this.calcForceExertedByX(p);
    }
    return netForceX;
  }

  public double calcNetForceExertedByY(Planet[] allPlanets) {
    double netForceY = 0;
    for (Planet p : allPlanets) {
     if (this.equals(p)) {
        continue;
      }
      netForceY += this.calcForceExertedByY(p);
    }
    return netForceY;
  }

  public void update(double dt,double fX,double fY) {
    double aX = fX / this.mass;
    double aY = fY / this.mass;
    xxVel = this.xxVel + dt * aX;
    yyVel = this.yyVel + dt * aY;
    xxPos = this.xxPos + dt * xxVel;
    yyPos = this.yyPos + dt * yyVel;
  }

  public void draw() {
    String img_root = "images/" + this.imgFileName;
    StdDraw.picture(this.xxPos, this.yyPos, img_root);
  }
}
