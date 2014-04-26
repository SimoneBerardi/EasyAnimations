/* Generated by JTB 1.4.7 */
package poseParser.syntaxtree;

import poseParser.visitor.*;

public class BoneDef implements INode {

  public Position f0;

  public NodeToken f1;

  public Position f2;

  private static final long serialVersionUID = 147L;

  public BoneDef(final Position n0, final NodeToken n1, final Position n2) {
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