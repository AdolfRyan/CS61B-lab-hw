public class NBody {

  public static double readRadius(String fileName) {
    In in = new In(fileName);
    int num = in.readInt();
    double radius = in.readDouble();
    return radius;
  }

  public static Planet[] readPlanets(String fileName) {
    In in = new In(fileName);
    int tmp = in.readInt();
    double tmp2 = in.readDouble();
    Planet[] planets = new Planet[tmp];
    int count = 0;
    for (int i = 0; i < tmp; i++) {
      double xxP = in.readDouble();
      double yyP = in.readDouble();
      double xxV = in.readDouble();
      double yyV = in.readDouble();
      double m = in.readDouble();
      String img = in.readString();
      Planet tmPlanet = new Planet(xxP, yyP, xxV, yyV, m, img);
      planets[count] = tmPlanet;
      count++;
    }
    return planets;
  }

  public static void main(String[] args) {
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    Planet[] planets = readPlanets(filename);

    double[] xForces = new double[planets.length];
    double[] yForces = new double[planets.length];

    double radius = readRadius(filename);

    StdDraw.enableDoubleBuffering();

    double time = 0;
    while(time < T) {

      for(int i = 0;i < planets.length; i++) {
        xForces[i] = planets[i].calcNetForceExertedByX(planets);
        yForces[i] = planets[i].calcNetForceExertedByY(planets);
      }

      for (int i = 0;i <planets.length;i++) {
        planets[i].update(dt, xForces[i], yForces[i]);
      }
      
      StdDraw.setScale(-radius, radius);
      StdDraw.clear();
      StdDraw.picture(0, 0, "images/starfield.jpg");

      for(Planet p : planets) {
        p.draw();
      }
      StdDraw.show();
      StdDraw.pause(10);
      time += dt;
    }

    StdOut.printf("%d\n", planets.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < planets.length; i++) {
    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
    }
  }
}
