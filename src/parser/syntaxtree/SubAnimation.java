/* Generated by JTB 1.4.7 */
package parser.syntaxtree;

import parser.visitor.*;

public class SubAnimation implements INode {

  public NodeToken f0;

  public NodeToken f1;

  public AnimationName f2;

  public NodeToken f3;

  public NodeToken f4;

  public Frame f5;

  public AnimationDef f6;

  private static final long serialVersionUID = 147L;

  public SubAnimation(final NodeToken n0, final NodeToken n1, final AnimationName n2, final NodeToken n3, final NodeToken n4, final Frame n5, final AnimationDef n6) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
    f3 = n3;
    f4 = n4;
    f5 = n5;
    f6 = n6;
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
