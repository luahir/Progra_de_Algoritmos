/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.library;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Braulio Rivera
 */
public class Edge {
        private Figure _figure1;
        private Figure _figure2;
        private Figure_Kind _kind;
        private int _curve;
        private int _thickness1;
        private Color _color;

        public Edge(Figure pFigure1, Figure pFigure2, Figure_Kind pKind, int pCurve, int pThickness, Color pColor) {
            this._figure1 = pFigure1;
            this._figure2 = pFigure2;
            this._kind = pKind;
            this._curve = pCurve;
            this._thickness1 = pThickness;
            this._color = pColor;
        }

        public void draw(Graphics2D g2) {
            QuadCurve2D q = new QuadCurve2D.Float();
            Point _point1 = _figure1.getLocation();
            Point _point2 = _figure2.getLocation();
            g2.setColor(_color);
            Point pointCurve = new Point();
            if (this._kind == Figure_Kind.Line)
            {           
                g2.drawLine(_point1.x, _point1.y, _point2.x, _point2.y);
            }
            else if (this._kind == Figure_Kind.Curve) {
                
                if (_curve == 1){
                    pointCurve.setLocation(_point2.x-50, _point2.y-((_point2.y-_point1.y)/2));
                    q.setCurve(_point1,pointCurve,_point2);
                    _pointCurve1 = pointCurve;
                }
                else if (_curve == 2){
                    pointCurve.setLocation(_point2.x-((_point2.x-_point1.x)/2),_point2.y+50);
                    q.setCurve(_point1,pointCurve,_point2);
                    _pointCurve2 = pointCurve;
                }
                g2.draw(q);
                
            }
            
            //g2.setStroke(new BasicStroke (this._thickness1));
        }
        
        public static List <Point> getcurvePoints(){
            List <Point> pointCurves = new ArrayList();
            pointCurves.add(_pointCurve1);
            pointCurves.add(_pointCurve2);
            return pointCurves;
        }
        
        private static Point _pointCurve1;
        private static Point _pointCurve2;
        
        public List <Point> intersect1(List<Edge> list) 
        {
            List <Point> points1 = new ArrayList();
            for (Edge n : list) 
            {
                points1.add(n._figure1.getLocation());
            }
            return points1;
        }
        public List <Point> intersect2(List<Edge> list) 
        {
            List <Point> points2 = new ArrayList();
            for (Edge n : list) 
            {
                points2.add(n._figure2.getLocation());
            }
            return points2;
        }
        
        
        public static void updateThickness(List<Edge> list, int thickness) 
        {
            for (Edge n : list) 
            {
                if (n._figure1.isSelected() && n._figure2.isSelected()) 
                {
                    n._thickness1 = thickness;
                }
            }
        }
}
