/* Generated by JTB 1.4.7 */
package poseParser.syntaxtree;

import poseParser.visitor.*;

public class Pose implements INode {

  public NodeToken f0;

  public PoseName f1;

  public PoseDef f2;

  private static final long serialVersionUID = 147L;

  public Pose(final NodeToken n0, final PoseName n1, final PoseDef n2) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }

  public <R> R accept(final IRetVisitor<R> vis) {
    return vis.visit(this);
  }

  public <A> void accept(final IVoidArguVisitor<A> vis, final A argu) {
    vis.visit(this, argu);
  }

  public void accept(final IVoidVisitor vis) {
    vis.visit(this);
  }

}