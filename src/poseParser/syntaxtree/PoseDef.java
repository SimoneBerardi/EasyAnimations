/* Generated by JTB 1.4.7 */
package poseParser.syntaxtree;

import poseParser.visitor.*;

public class PoseDef implements INode {

  public NodeToken f0;

  public NodeList f1;

  public NodeToken f2;

  private static final long serialVersionUID = 147L;

  public PoseDef(final NodeToken n0, final NodeList n1, final NodeToken n2) {
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
