import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;


public class CF_560C_GeraldsHexagon {
    static final double EPS = 1e-9;
      // In Java, we can use Math.PI instead of using Math.acos(-1.0)

      static double DEG_to_RAD(double d) { return d * Math.PI / 180.0; }
      double RAD_to_DEG(double r) { return r * 180.0 / Math.PI; }

      static class point implements Comparable<point>{
        double x, y;                   // only used if more precision is needed
        point() { x = y = 0.0; }                         // default constructor
        point(double _x, double _y) { x = _x; y = _y; }         // user-defined
        // use EPS (1e-9) when testing equality of two floating points
        public int compareTo(point other) {      // override less than operator
          if (Math.abs(x - other.x) > EPS)                // useful for sorting
            return (int)Math.ceil(x - other.x);       // first: by x-coordinate
          else if (Math.abs(y - other.y) > EPS)
            return (int)Math.ceil(y - other.y);      // second: by y-coordinate
          else
              
              return 0; } 
        public String toString()
        {
            return x+" "+y;
        }
      };                                    // they are equal

      class vec { double x, y;     // name: `vec' is different from Java Vector
        vec(double _x, double _y) { x = _x; y = _y; } };

      vec toVec(point a, point b) {               // convert 2 points to vector
        return new vec(b.x - a.x, b.y - a.y); }

      double dist(point p1, point p2) {                   // Euclidean distance
        return Math.hypot(p1.x - p2.x, p1.y - p2.y); }         // return double

      // returns the perimeter, which is the sum of Euclidian distances
      // of consecutive line segments (polygon edges)
      double perimeter(List<point> P) {
        double result = 0.0;
        for (int i = 0; i < (int)P.size()-1; i++)  // remember that P[0] = P[n-1]
          result += dist(P.get(i), P.get(i+1));
        return result; }

      // returns the area, which is half the determinant
      // works for both convex and concave polygons
      static double area(List<point> P) {
        double result = 0.0, x1, y1, x2, y2;
        for (int i = 0; i < (int)P.size()-1; i++) {
          x1 = P.get(i).x; x2 = P.get(i+1).x;
          y1 = P.get(i).y; y2 = P.get(i+1).y;
          result += (x1 * y2 - x2 * y1);
        }
        return Math.abs(result) / 2.0; }

      double dot(vec a, vec b) { return (a.x * b.x + a.y * b.y); }

      double norm_sq(vec v) { return v.x * v.x + v.y * v.y; }

      double angle(point a, point o, point b) {     // returns angle aob in rad
        vec oa = toVec(o, a), ob = toVec(o, b);
        return Math.acos(dot(oa, ob) / Math.sqrt(norm_sq(oa) * norm_sq(ob))); }

      double cross(vec a, vec b) { return a.x * b.y - a.y * b.x; }

      // note: to accept collinear points, we have to change the `> 0'
      // returns true if point r is on the left side of line pq
      boolean ccw(point p, point q, point r) {
        return cross(toVec(p, q), toVec(p, r)) > 0; }

      // returns true if point r is on the same line as the line pq
      boolean collinear(point p, point q, point r) {
        return Math.abs(cross(toVec(p, q), toVec(p, r))) < EPS; }

      // returns true if we always make the same turn while examining
      // all the edges of the polygon one by one
      boolean isConvex(List<point> P) {
        int sz = (int)P.size();
        if (sz <= 3) return false;   // a point/sz=2 or a line/sz=3 is not convex
        boolean isLeft = ccw(P.get(0), P.get(1), P.get(2)); // remember one result
        for (int i = 1; i < sz-1; i++)            // then compare with the others
          if (ccw(P.get(i), P.get(i+1), P.get((i+2) == sz ? 1 : i+2)) != isLeft)
            return false;            // different sign -> this polygon is concave
        return true; }                                  // this polygon is convex

      // returns true if point p is in either convex/concave polygon P
      boolean inPolygon(point pt, List<point> P) {
        if ((int)P.size() == 0) return false;
        double sum = 0; // assume first vertex = last vertex
        for (int i = 0; i < (int)P.size()-1; i++) {
          if (ccw(pt, P.get(i), P.get(i+1)))
               sum += angle(P.get(i), pt, P.get(i+1));   // left turn/ccw
          else sum -= angle(P.get(i), pt, P.get(i+1)); } // right turn/cw
        return Math.abs(Math.abs(sum) - 2*Math.PI) < EPS; }

      // line segment p-q intersect with line A-B.
      point lineIntersectSeg(point p, point q, point A, point B) {
        double a = B.y - A.y;
        double b = A.x - B.x;
        double c = B.x * A.y - A.x * B.y;
        double u = Math.abs(a * p.x + b * p.y + c);
        double v = Math.abs(a * q.x + b * q.y + c);
        return new point((p.x * v + q.x * u) / (u+v), (p.y * v + q.y * u) / (u+v)); }

      // cuts polygon Q along the line formed by point a -> point b
      // (note: the last point must be the same as the first point)
      List<point> cutPolygon(point a, point b, List<point> Q) {
        List<point> P = new ArrayList<point>();
        for (int i = 0; i < (int)Q.size(); i++) {
          double left1 = cross(toVec(a, b), toVec(a, Q.get(i))), left2 = 0;
          if (i != (int)Q.size()-1) left2 = cross(toVec(a, b), toVec(a, Q.get(i+1)));
          if (left1 > -EPS) P.add(Q.get(i)); // Q[i] is on the left of ab
          if (left1 * left2 < -EPS) // edge (Q[i], Q[i+1]) crosses line ab
            P.add(lineIntersectSeg(Q.get(i), Q.get(i+1), a, b));
        }
        if (!P.isEmpty() && P.get(P.size()-1).compareTo(P.get(0)) != 0)
          P.add(P.get(0)); // make P's first point = P's last point
        return P; }

      point pivot = new point();
      List<point> CH(List<point> P) {
        int i, j, n = (int)P.size();
        if (n <= 3) {
          if (P.get(0).compareTo(P.get(n-1)) != 0) P.add(P.get(0)); // safeguard from corner case
          return P; // special case, the CH is P itself
        }

        // first, find P0 = point with lowest Y and if tie: rightmost X
        int P0 = 0;
        for (i = 1; i < n; i++)
          if (P.get(i).y  < P.get(P0).y ||
             (P.get(i).y == P.get(P0).y && P.get(i).x > P.get(P0).x))
            P0 = i;

        point temp = P.get(0); P.set(0, P.get(P0)); P.set(P0 ,temp); // swap P[P0] with P[0]

        // second, sort points by angle w.r.t. P0
        pivot = P.get(0); // use this global variable as reference
        Collections.sort(P, new Comparator<point>(){
          public int compare(point a, point b) { // angle-sorting function
            if (collinear(pivot, a, b))
              return dist(pivot, a) < dist(pivot, b) ? -1 : 1; // which one is closer?
            double d1x = a.x - pivot.x, d1y = a.y - pivot.y;
            double d2x = b.x - pivot.x, d2y = b.y - pivot.y;
            return (Math.atan2(d1y, d1x) - Math.atan2(d2y, d2x)) < 0 ? -1 : 1;
           }
        });

        // third, the ccw tests
        List<point> S = new ArrayList<point>();
        S.add(P.get(n-1)); S.add(P.get(0)); S.add(P.get(1)); // initial S
        i = 2; // then, we check the rest
        while (i < n) { // note: n must be >= 3 for this method to work
          j = S.size() - 1;
          if (ccw(S.get(j-1), S.get(j), P.get(i))) S.add(P.get(i++)); // left turn, accept
          else S.remove(S.size() - 1); // or pop the top of S until we have a left turn
        }
        return S; } // return the result
      
      static point rotate(point p, double theta, point to) {
            double rad = DEG_to_RAD(theta);       // multiply theta with PI / 180.0
            p.x -= to.x;
            p.y -= to.y;
            return new point((p.x * Math.cos(rad) - p.y * Math.sin(rad)+to.x),
                             (p.x * Math.sin(rad) + p.y * Math.cos(rad))+to.y); }
            

public static void main(String[] args) throws IOException {
    BufferedReader in;
    StringBuilder out = new StringBuilder();
    File file = new File("in");
    if (file.exists())
        in = new BufferedReader(new FileReader(file));
    else
        in = new BufferedReader(new InputStreamReader(System.in));
    String line, lines[];
    lines = in.readLine().split(" ");
    int arr[] = new int[lines.length];
    for ( int i = 0;i < lines.length; i++ )
    {
        arr[i] = Integer.parseInt(lines[i]);
    }
    point p1, p2, p3, p4, p5, p6;
    p1 = new point(0, 0);
    p2 = new point(arr[0], 0);
    
    p3 = new point(p2.x+arr[1], p2.y);
    p3 = rotate(p3,60.0 ,p2);
    
    p4 = new point(p3.x+arr[2], p3.y);
    p4 = rotate(p4,120.0 ,p3);
    
    p5 = new point(p4.x+arr[3], p4.y);
    p5 = rotate(p5,180.0 ,p4);
    
    
    p6 = new point(p5.x+arr[4], p5.y);
    p6 = rotate(p6,240.0 ,p5);
    double bb = Math.sqrt(1.0*1.0-0.5*0.5)/2.0;
//  System.out.println(p1);
//  System.out.println(p2);
//  System.out.println(p3);
//  System.out.println(p4);
//  System.out.println(p5);
//  System.out.println(p5);
    List<point> list = new ArrayList<point>();
    list.add(p1);
    list.add(p6);
    list.add(p5);
    list.add(p4);
    list.add(p3);
    list.add(p2);
    list.add(p1);
    String r = String.format("%.0f", area(list)/bb);
    System.out.println(r);
    
}
}